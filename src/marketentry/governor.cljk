(ns marketentry.governor
  "Market-Entry Compliance Governor -- the independent compliance layer
  that earns the MarketEntry-LLM the right to commit. The LLM has no
  notion of jurisdictional procurement law, whether a foreign
  employer's non-Yemeni workforce actually clears the statutory
  Yemenization quota, whether a claimed engagement fee actually equals
  base + months x rate, whether a Commercial Registry number has been
  verified for a filing that requires it, or when a draft stops being
  a draft and becomes a real-world tender submission, so this MUST be
  a separate system able to *reject* a proposal and fall back to HOLD.

  `:itonami.blueprint/governor` is `:market-entry-compliance-governor`
  (shared family keyword on blueprints).

  This blueprint's own text (docs/business-model.md Trust Controls:
  'any actual tender registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off'; 'a false or fabricated regulatory-requirement claim
  is a HARD hold') names exactly the checks below.

  Seven checks, in priority order, ALL HARD violations: a human
  approver CANNOT override them. The confidence/actuation gate is
  SOFT: it asks a human to look (low confidence / actuation), and the
  human may approve -- but see `marketentry.phase`: for `:stake
  :actuation/draft-filing`/`:actuation/submit-filing` NO phase ever
  allows auto-commit either. Two independent layers agree that
  actuation is always a human call.

    1. Spec-basis                  -- did the jurisdiction proposal cite
                                       an OFFICIAL source
                                       (`marketentry.facts`), or invent
                                       one?
    2. Evidence incomplete         -- for `:filing/draft`/
                                       `:filing/submit`, has the
                                       jurisdiction actually been
                                       assessed with a full evidence
                                       checklist on file?
    3. Non-Yemeni workforce quota
       exceeded                      -- for `:filing/submit`, when the
                                       engagement declares
                                       `:requires-foreign-worker-hiring?
                                       true`, INDEPENDENTLY recompute
                                       the engagement's own declared
                                       `:non-yemeni-worker-count` /
                                       `:yemeni-worker-count` ratio and
                                       verify it does not exceed
                                       `yemenization-floor-percent`.
                                       FLAGSHIP genuinely new check for
                                       the iso3166 family (grep-verified
                                       absent as a governor-check theme
                                       -- both by function/rule name
                                       among the KWT/IRQ/LBN sibling
                                       repos studied in full this
                                       session, and by FLAGSHIP-docstring
                                       theme among the SAU/OMN/ARE Gulf
                                       siblings' governor.cljc, which
                                       are all a differently-shaped
                                       'local-entity-missing' check, not
                                       a workforce-nationalization
                                       quota). Grounded in Yemen's Labor
                                       Law -- Republican Decree-Law No.
                                       5 of 1995 (as amended by Laws No.
                                       25/1997, No. 11/2001, No.
                                       25/2003), Article 21, fetched and
                                       read verbatim this session from
                                       Yemen's National Information
                                       Center legislation database
                                       (yemen-nic.info): 'لا يجوز أن
                                       يزيد عدد العمال غير اليمنيين لدى
                                       صاحب العمل على 10% من إجمالي
                                       العمال اليمنيين' -- the number of
                                       non-Yemeni workers with an
                                       employer may not exceed 10% of
                                       the total number of Yemeni
                                       workers. This is a per-employer
                                       statutory cap, not a national
                                       aggregate, so it maps directly
                                       onto a single market-entry
                                       engagement.
    4. Engagement fee mismatch     -- for `:filing/submit`,
                                       INDEPENDENTLY recompute whether
                                       the engagement's own `:claimed-
                                       fee` equals `base-fee +
                                       monthly-rate x monitoring-
                                       months` -- honest reapplication
                                       of the ground-truth-recompute
                                       discipline sibling actors use.
    5. Commercial-registry (CR)
       unverified                    -- for `:filing/submit`, when the
                                       engagement declares
                                       `:requires-cr? true`,
                                       INDEPENDENTLY check
                                       `:cr-verified?`. CONDITIONAL on
                                       the engagement's own ground
                                       truth. Grounded in Republican
                                       Decree-Law No. 33 of 1991
                                       Concerning the Commercial
                                       Registry, as amended, Article 11
                                       (trading without registration is
                                       prohibited; merchant status
                                       attaches only from the date of
                                       registration) and Article 3
                                       (60-day registration deadline),
                                       fetched and read in full
                                       (pdftotext) from Yemen's Ministry
                                       of Economy, Industry and
                                       Investment legislation library
                                       this session.
    6. Confidence floor / actuation
       gate                          -- LLM confidence below threshold,
                                       OR the op is `:filing/draft`/
                                       `:filing/submit` (REAL acts)
                                       -> escalate.

  Two more guards, double-draft/double-submit prevention, are enforced
  off dedicated `:drafted?`/`:submitted?` facts (never a `:status`
  value)."
  (:require [marketentry.facts :as facts]
            [marketentry.registry :as registry]
            [marketentry.store :as store]))

(def confidence-floor 0.6)

(def high-stakes
  "Stakes grave enough to always require a human, even when clean.
  Drafting a real tender package and submitting a real tender
  filing are the two real-world actuation events this actor
  performs."
  #{:actuation/draft-filing :actuation/submit-filing})

;; ----------------------------- checks -----------------------------

(defn- spec-basis-violations
  "A `:jurisdiction/assess` (or `:filing/draft`/`:filing/submit`)
  proposal with no spec-basis citation is a HARD violation -- never
  invent a jurisdiction's market-entry requirements."
  [{:keys [op]} proposal]
  (when (contains? #{:jurisdiction/assess :filing/draft :filing/submit} op)
    (let [value (:value proposal)]
      (when (or (empty? (:cites proposal))
                (and (contains? value :spec-basis) (nil? (:spec-basis value))))
        [{:rule :no-spec-basis
          :detail "公式spec-basisの引用が無い提案は法域要件として扱えない"}]))))

(defn- evidence-incomplete-violations
  "For `:filing/draft`/`:filing/submit`, the jurisdiction's required
  registration evidence must actually be satisfied."
  [{:keys [op subject]} st]
  (when (contains? #{:filing/draft :filing/submit} op)
    (let [e (store/engagement st subject)
          assessment (store/assessment-of st subject)]
      (when-not (and assessment
                     (facts/required-evidence-satisfied?
                      (:jurisdiction e) (:checklist assessment)))
        [{:rule :evidence-incomplete
          :detail "法域の必要書類(CR/入札者分類証明/職業許可証/税カード等)が充足していない状態での提案"}]))))

(def yemenization-floor-percent
  "Labor Law No. 5 of 1995 (as amended by Laws No. 25/1997, No.
  11/2001, No. 25/2003), Article 21's own stated statutory cap --
  'لا يجوز أن يزيد عدد العمال غير اليمنيين لدى صاحب العمل على 10% من
  إجمالي العمال اليمنيين' (the number of non-Yemeni workers with an
  employer may not exceed 10% of the total number of Yemeni workers).
  Expressed here as the maximum allowed ratio of non-Yemeni to Yemeni
  workers, per employer. No Council-of-Ministers or ministerial
  adjustment decision affecting this ratio was independently fetched
  this session, so this constant is the law's own stated baseline,
  not a possibly-superseded number."
  10.0)

(defn- non-yemeni-workforce-quota-exceeded-violations
  "FLAGSHIP genuinely new check for the iso3166 family. For
  `:filing/submit`, when the engagement declares
  `:requires-foreign-worker-hiring? true` (the employer intends to
  hire non-Yemeni workers), INDEPENDENTLY recompute the non-Yemeni:
  Yemeni worker ratio from the engagement's own
  `:non-yemeni-worker-count` / `:yemeni-worker-count` fields and
  verify it does not exceed `yemenization-floor-percent` (Article 21's
  10% statutory cap). A missing/zero Yemeni-worker count with a
  foreign-hiring intent is ALSO a violation -- there is no way to
  independently verify a ratio clears the cap without both counts on
  file. CONDITIONAL on the engagement's own
  `:requires-foreign-worker-hiring?` ground truth -- an engagement
  that does not intend to hire any non-Yemeni worker never triggers
  this check, see the paired positive-case test."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (let [e (store/engagement st subject)]
      (when (true? (:requires-foreign-worker-hiring? e))
        (let [nyc (:non-yemeni-worker-count e)
              yc  (:yemeni-worker-count e)
              ratio (when (and nyc yc (pos? yc)) (* 100.0 (/ (double nyc) (double yc))))]
          (when (or (nil? ratio) (> ratio yemenization-floor-percent))
            [{:rule :non-yemeni-workforce-quota-exceeded
              :detail (str subject " の非イエメン人労働者比率(非イエメン人=" nyc
                          ", イエメン人=" yc ")が労働法5号/1995(改正)第21条の"
                          "法定上限" yemenization-floor-percent "%を超過または未確認 -- "
                          "提出提案は進められない")}]))))))

(defn- engagement-fee-mismatch-violations
  "For `:filing/submit`, INDEPENDENTLY recompute whether the
  engagement's own claimed fee equals base + months x rate."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (let [e (store/engagement st subject)]
      (when-not (registry/engagement-fee-matches-claim? e)
        [{:rule :engagement-fee-mismatch
          :detail (str subject " の申告手数料(" (:claimed-fee e)
                      ")が独立再計算値(" (registry/compute-engagement-fee e) ")と一致しない")}]))))

(defn- cr-unverified-violations
  "For `:filing/submit`, when the engagement declares
  `:requires-cr? true`, INDEPENDENTLY check
  `:cr-verified?` -- CONDITIONAL on the engagement's own
  ground truth. Grounded in Decree-Law No. 33/1991 Art. 11."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (let [e (store/engagement st subject)]
      (when (and (true? (:requires-cr? e))
                 (not (true? (:cr-verified? e))))
        [{:rule :cr-unverified
          :detail (str subject " はCR(商業登記/السجل التجاري)確認を要するが未確認 -- 提出提案は進められない")}]))))

(defn- already-drafted-violations
  "For `:filing/draft`, refuses to draft the SAME engagement twice."
  [{:keys [op subject]} st]
  (when (= op :filing/draft)
    (when (store/engagement-already-drafted? st subject)
      [{:rule :already-drafted
        :detail (str subject " は既にドラフト済み")}])))

(defn- already-submitted-violations
  "For `:filing/submit`, refuses to submit the SAME engagement twice."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (when (store/engagement-already-submitted? st subject)
      [{:rule :already-submitted
        :detail (str subject " は既に提出済み")}])))

(defn check
  "Censors a MarketEntry-LLM proposal against the governor rules.
  Returns {:ok? bool :violations [..] :confidence c :escalate? bool
  :high-stakes? bool :hard? bool}."
  [request _context proposal st]
  (let [hard (into []
                   (concat (spec-basis-violations request proposal)
                           (evidence-incomplete-violations request st)
                           (non-yemeni-workforce-quota-exceeded-violations request st)
                           (engagement-fee-mismatch-violations request st)
                           (cr-unverified-violations request st)
                           (already-drafted-violations request st)
                           (already-submitted-violations request st)))
        conf (:confidence proposal 0.0)
        low? (< conf confidence-floor)
        stakes? (boolean (high-stakes (:stake proposal)))
        hard? (boolean (seq hard))]
    {:ok?          (and (not hard?) (not low?) (not stakes?))
     :violations   hard
     :confidence   conf
     :hard?        hard?
     :escalate?    (and (not hard?) (or low? stakes?))
     :high-stakes? stakes?}))

(defn hold-fact
  "The audit fact written when a proposal is rejected (HOLD)."
  [request context verdict]
  {:t          :governor-hold
   :op         (:op request)
   :actor      (:actor-id context)
   :subject    (:subject request)
   :disposition :hold
   :basis      (mapv :rule (:violations verdict))
   :violations (:violations verdict)
   :confidence (:confidence verdict)})
