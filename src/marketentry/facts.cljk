(ns marketentry.facts
  "Yemen market-entry catalog -- public-sector procurement market
  entry (narrow scope; the broader general-compliance catalog is
  `statute.facts`).

  Every fact below was fetched and read directly this session (no
  training-data paraphrase, no invented act/article/URL). Yemen's
  institutional/web infrastructure is genuinely fragmented by the
  ongoing conflict between the internationally-recognized government
  (IRG, Presidential Leadership Council, seat relocated to Aden) and
  the Houthi/Ansar Allah-aligned de facto authorities controlling
  Sana'a and much of the north/west -- this catalog discloses that
  fragmentation per-fact rather than presenting a single source as
  unambiguously, uncontestedly nationally authoritative.

    - `:owner-authority`/`:legal-basis`/`:provenance` (public
      procurement): Law No. 23 of 2007 Concerning Tenders, Auctions
      and Government Warehouses (قانون رقم 23 لسنة 2007 بشأن
      المناقصات والمزايدات والمخازن الحكومية), fetched and read (full
      text, 114 articles across 10 chapters, repealed prior Law No. 3
      of 1997) from Yemen's National Information Center legislation
      database (https://www.yemen-nic.info/db/laws_ye/detail.php?ID=15594)
      this session. Article 42 establishes 'الهيئة العليا للرقابة على
      المناقصات والمزايدات' (Supreme Authority for Oversight of
      Tenders and Auctions); Article 43 sets its composition (7
      members -- 1 president + 6 members appointed by presidential
      decree from Shura Council nominations, representing commercial/
      industrial/civil-society/judicial sectors). This law predates
      the 2014-2015 political split by 7 years; whether/how it is
      currently administered uniformly by a single authority across
      all of Yemen's territory was NOT independently confirmed this
      session -- disclosed as an open question, not resolved by
      assumption.
    - `:required-evidence`: Article 9(b)(1) of the same law lists the
      mandatory bid-documentation set verbatim, for tenders above a
      regulation-set financial threshold: registration & classification
      certificate for contractors/suppliers (شهادة التسجيل والتصنيف
      للمقاولين والموردين), professional-practice license (شهادة
      مزاولة المهنة), tax card (البطاقة الضريبية), sales-tax
      registration certificate, and other law-required certificates.
      Article 9(b)(2): competent authorities maintain classification
      registries per applicable law; foreign companies provide
      equivalent certified documents from their home country.
    - `:rep-*` / `:corporate-number-*` (business registration /
      Commercial Registry): Republican Decree-Law No. 33 of 1991
      Concerning the Commercial Registry, as amended (القرار الجمهوري
      بالقانون رقم 33 لسنة 1991 بشأن السجل التجاري المعدل) --
      downloaded as a PDF and read in full (pdftotext -layout, 5
      pages) from Yemen's Ministry of Economy, Industry and Investment
      legislation library (https://www.moit.gov.ye/legislations/laws).
      Article 11(1): trading at a commercial premises is prohibited
      except for one registered in the Commercial Registry of the
      district where the premises is located; merchant status attaches
      from the date of registration. Article 3: 60-day registration
      deadline from commencement of activity, separately addressing
      individual traders, domestic companies/institutions, AND foreign
      company branches/agencies headquartered abroad (the last of
      these must attach certified copies of the foreign company's
      incorporation documents plus a certified Arabic translation).
      DISCLOSURE: moit.gov.ye's own branches-offices page confirms its
      head office is in Sana'a, i.e. this is a Sana'a-based / Houthi-
      aligned-authority ministry site, NOT the internationally-
      recognized government (IRG, seat in Aden). This 1991 Commercial
      Registry Law itself predates the 2014-2015 political split by 23
      years and was originally jointly signed by both pre-unification
      North/South Yemen leaders (Ali Abdullah Saleh, Haidar Abu Bakr
      Al-Attas) -- a unification-era harmonization law whose Art. 27
      repeals the separate prior Sana'a (1976) and Aden (1969)
      commercial-registry laws -- so its status as general Yemeni
      statute does not depend on which post-2014 authority currently
      hosts this particular PDF copy. No independent IRG-side
      confirmation of this specific PDF's text was obtained this
      session, however -- disclosed, not assumed away.

  GAP DISCLOSURE: no dedicated national e-procurement PLATFORM brand
  (comparable to Kuwait's CAPT portal or Lebanon's PPA e-Procurement
  Platform) was found or confirmed this session, so `:national-spec`
  below describes the documentation-based classification/registration
  regime Law No. 23/2007 itself specifies rather than naming an
  unverified IT system, and no `:portal` field is asserted here
  (following cloud-itonami-iso3166-irq's discipline of dropping a
  field rather than inventing a value). Yemen's General Investment
  Authority (GIA, gia.gov.ye) -- relevant to `statute.facts`'
  investment-law entries, not this procurement-scoped catalog -- was
  found to be a parked placeholder page (Wayback snapshot 2026-06-30),
  not a functioning site, this session; that gap is disclosed in
  `statute.facts`, not repeated here. No reference-jurisdiction rows
  (USA/SAU/etc., carried by some other sibling catalogs) are copied
  into this catalog -- they would be unverified-this-session facts
  about OTHER countries; this catalog is intentionally YEM-only,
  following cloud-itonami-iso3166-irq's discipline over
  cloud-itonami-iso3166-kwt's/-lbn's inherited reference rows.")

(def catalog
  {"YEM"
   {:name "Republic of Yemen"
    :owner-authority "Supreme Authority for Oversight of Tenders and Auctions (الهيئة العليا للرقابة على المناقصات والمزايدات), Law No. 23/2007 Art. 42-43"
    :legal-basis "Law No. 23 of 2007 Concerning Tenders, Auctions and Government Warehouses (قانون رقم 23 لسنة 2007 بشأن المناقصات والمزايدات والمخازن الحكومية)"
    :national-spec "Documentation-based contractor/supplier classification & registration regime (Art. 9(b)) -- no independently-confirmed national e-procurement platform brand"
    :provenance "https://www.yemen-nic.info/db/laws_ye/detail.php?ID=15594"
    :required-evidence ["Contractor/supplier registration & classification certificate (شهادة التسجيل والتصنيف, Law No. 23/2007 Art. 9(b)(1))"
                         "Professional-practice license (شهادة مزاولة المهنة)"
                         "Tax card (البطاقة الضريبية)"
                         "Sales-tax registration certificate (Law No. 19/2001 Art. 6)"
                         "Commercial Registration record (Decree-Law No. 33/1991)"]
    :rep-owner-authority "Ministry of Economy, Industry and Investment -- Commercial Registry Administration (Sana'a-based ministry site; see catalog docstring disclosure)"
    :rep-legal-basis "Republican Decree-Law No. 33 of 1991 Concerning the Commercial Registry, as amended, Art. 3 (60-day registration deadline) / Art. 11 (registration precondition to trading)"
    :rep-provenance "https://www.moit.gov.ye/legislations/laws"
    :corporate-number-owner-authority "Ministry of Economy, Industry and Investment -- Commercial Registry"
    :corporate-number-legal-basis "Republican Decree-Law No. 33 of 1991 Concerning the Commercial Registry, as amended"
    :corporate-number-provenance "https://www.moit.gov.ye/legislations/laws"}})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed -- YEM only, no peer-jurisdiction rows copied without re-verification"})))

(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))

(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))

(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))

(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
