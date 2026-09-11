(ns marketentry.marketentryllm
  "MarketEntry-LLM client -- the *contained intelligence node* for
  the YEM public-sector market-entry compliance actor.

  It normalizes engagement intake, drafts a per-jurisdiction market-
  entry evidence checklist, drafts the filing-draft action, and drafts
  the filing-submit action. CRITICAL: it is a smart-but-untrusted
  advisor. It returns a *proposal* (with a rationale + the fields it
  cited), never a committed record or a real government-tender
  submission. Every output is censored downstream by
  `marketentry.governor` before anything touches the SSoT, and
  `:filing/draft`/`:filing/submit` proposals NEVER auto-commit at any
  phase -- see README Actuation.

  `propose-submit`'s confidence deliberately also reflects whether the
  engagement's own declared non-Yemeni-worker ratio would clear
  Article 21 of Yemen's Labor Law No. 5/1995 (a 10% cap) whenever the
  engagement declares `:requires-foreign-worker-hiring? true` -- a
  mismatch is a genuine market-entry error (understaffing the
  Yemenization quota check), not a stylistic slip, so a low-confidence
  proposal here still gets independently re-checked (and rejected) by
  `marketentry.governor`'s flagship
  `non-yemeni-workforce-quota-exceeded` check regardless of what
  confidence this advisor reports.

  Like every sibling actor's advisor, this is a deterministic mock so
  the actor graph runs offline and the governor contract is exercised
  end-to-end."
  (:require [marketentry.facts :as facts]
            [marketentry.store :as store]))

(defn- normalize-intake
  [_db {:keys [patch]}]
  {:summary    (str "参入案件記録更新: " (pr-str (keys patch)))
   :rationale  "入力 patch の正規化のみ。新規事実の生成なし。"
   :cites      (vec (keys patch))
   :effect     :engagement/upsert
   :value      patch
   :stake      nil
   :confidence 0.97})

(defn- assess-jurisdiction
  "Per-jurisdiction market-entry evidence checklist draft. `:no-spec?`
  injects the failure mode we must defend against: proposing a
  checklist for a jurisdiction with NO official spec-basis."
  [db {:keys [subject no-spec?]}]
  (let [e (store/engagement db subject)
        iso3 (if no-spec? "ATL" (:jurisdiction e))
        sb (facts/spec-basis iso3)]
    (if (nil? sb)
      {:summary    (str iso3 " の公式spec-basisが見つかりません")
       :rationale  "marketentry.facts に未登録の法域。要件を推測で作らない。"
       :cites      []
       :effect     :assessment/set
       :value      {:jurisdiction iso3 :checklist [] :spec-basis nil}
       :stake      nil
       :confidence 0.9}
      {:summary    (str iso3 " (" (:owner-authority sb) ") 向け必要書類 "
                        (count (:required-evidence sb)) " 件を提案")
       :rationale  (str "公式ソース: " (:provenance sb) " / 法的根拠: " (:legal-basis sb))
       :cites      [(:legal-basis sb) (:provenance sb)]
       :effect     :assessment/set
       :value      {:jurisdiction iso3
                    :checklist (:required-evidence sb)
                    :spec-basis (:provenance sb)
                    :legal-basis (:legal-basis sb)}
       :stake      nil
       :confidence 0.9})))

(defn- propose-draft
  "Draft the actual FILING-DRAFT action. ALWAYS `:stake
  :actuation/draft-filing`."
  [db {:keys [subject]}]
  (let [e (store/engagement db subject)]
    {:summary    (str subject " 向け提出ドラフト提案"
                      (when e (str " (operator=" (:operator e) ")")))
     :rationale  (if e
                   (str "jurisdiction=" (:jurisdiction e))
                   "engagementが見つかりません")
     :cites      (if e [subject] [])
     :effect     :engagement/mark-drafted
     :value      {:engagement-id subject}
     :stake      :actuation/draft-filing
     :confidence (if e 0.9 0.3)}))

(defn- non-yemeni-ratio-ok?
  "Independently re-derives whether the engagement's own declared
  non-Yemeni:Yemeni worker headcounts would clear Article 21's 10%
  cap -- see `marketentry.governor`'s flagship check for the
  authoritative re-verification; this is only the advisor's own
  (untrusted) estimate."
  [{:keys [requires-foreign-worker-hiring? non-yemeni-worker-count yemeni-worker-count]}]
  (or (not (true? requires-foreign-worker-hiring?))
      (and non-yemeni-worker-count yemeni-worker-count (pos? yemeni-worker-count)
           (<= (* 100.0 (/ (double non-yemeni-worker-count) (double yemeni-worker-count))) 10.0))))

(defn- propose-submit
  "Draft the actual FILING-SUBMIT action. ALWAYS `:stake
  :actuation/submit-filing` -- real-world government-tender filing
  submission."
  [db {:keys [subject]}]
  (let [e (store/engagement db subject)]
    {:summary    (str subject " 向け政府調達フィリング提出提案"
                      (when e (str " (operator=" (:operator e) ")")))
     :rationale  (if e
                   (str "requires-foreign-worker-hiring?=" (:requires-foreign-worker-hiring? e)
                        " non-yemeni-worker-count=" (:non-yemeni-worker-count e)
                        " yemeni-worker-count=" (:yemeni-worker-count e)
                        " cr-verified?=" (:cr-verified? e)
                        " claimed-fee=" (:claimed-fee e))
                   "engagementが見つかりません")
     :cites      (if e [subject] [])
     :effect     :engagement/mark-submitted
     :value      {:engagement-id subject}
     :stake      :actuation/submit-filing
     :confidence (if (and e
                          (non-yemeni-ratio-ok? e)
                          (or (not (:requires-cr? e))
                              (:cr-verified? e)))
                   0.9 0.3)}))

(defprotocol Advisor
  (-advise [this db request] "Return a proposal map for `request`."))

(defrecord MockAdvisor []
  Advisor
  (-advise [_ db {:keys [op] :as request}]
    (case op
      :engagement/intake    (normalize-intake db request)
      :jurisdiction/assess  (assess-jurisdiction db request)
      :filing/draft         (propose-draft db request)
      :filing/submit        (propose-submit db request)
      {:summary "unknown op" :rationale "unsupported" :cites []
       :effect :noop :value {} :stake nil :confidence 0.0})))

(defn mock-advisor [] (->MockAdvisor))

(defn trace [request proposal]
  {:t :advisor-proposal
   :op (:op request)
   :subject (:subject request)
   :summary (:summary proposal)
   :confidence (:confidence proposal)
   :stake (:stake proposal)})
