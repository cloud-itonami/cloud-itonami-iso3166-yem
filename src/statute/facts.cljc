(ns statute.facts
  "General-law compliance catalog for Yemen (YEM) -- extends this
  repo's existing `marketentry.facts` (narrow public-procurement
  scope) with a second, orthogonal catalog of statutes a company
  generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-esp/-egy/-are/-sau/-omn/-tur/-kwt/
  -irq/-lbn's `statute.facts` (ADR-2607141700,
  cloud-itonami-compliance-fact-federation).

  Every entry below was fetched and read directly this session --
  either the full statute text (downloaded PDF + pdftotext, or a
  legislation-database detail page reproducing full article text) or,
  for one entry explicitly flagged below, only a webpage-level summary
  (disclosed as such, never presented as full-text-verified).

  INSTITUTIONAL FRAGILITY DISCLOSURE (read before trusting any single
  entry as uncontested): Yemen has had two competing governing
  authorities since roughly 2014-2015 -- the internationally-
  recognized government (IRG, Presidential Leadership Council, seat
  relocated to Aden) and the Houthi/Ansar Allah-aligned de facto
  authorities controlling Sana'a and much of the north/west. This
  session found direct, current evidence of that fragmentation rather
  than assuming it from memory:

    - Yemen's General Investment Authority (gia.gov.ye) has NO live
      web presence this session found -- the Internet Archive's own
      2022-06-30 snapshot shows only a parked cPanel default page
      ('Yemen Net Cpanel Default Page'), not a functioning GIA site.
    - The Ministry of Finance (mof.gov.ye) refused a live HTTPS
      connection outright this session (ECONNREFUSED); its 2025-08-12
      Wayback snapshot is a WordPress-style site with no readily
      browsable legislation index found this session. No income-tax
      (ضريبة الدخل) law citation could be confirmed as a result -- an
      honest, disclosed gap, not an invented figure.
    - ILO NATLEX (webapps.ilo.org / www.ilo.org) returned a genuine
      Cloudflare 'Just a moment...' bot-detection challenge when
      fetched this session (confirmed via the literal page title and
      Cloudflare challenge script in the response body). Per this
      project's hard safety rules, no attempt was made to bypass it,
      and no Wayback Machine snapshot of the Yemen country page could
      be found either -- ILO NATLEX is simply unusable as a source
      this session, disclosed rather than silently worked around.
    - `moit.gov.ye` ('Ministry of Economy, Industry and Investment')
      IS live and richly populated (a legislation library with direct
      PDF downloads), but its own branches-offices page confirms its
      head office is in Sana'a -- i.e. it is a Sana'a-based / Houthi-
      aligned-authority ministry site, NOT the IRG. Its 'Investment Law
      2025' (Law No. 3 of 1446H) is issued via 'المكتب القانوني
      للدولة' (State Legal Bureau), a legislative mechanism specific to
      the Houthi/Sana'a authorities (they do not operate through the
      internationally-recognized Parliament). Whether/how this 2025 law
      is recognized outside Houthi-controlled territory was NOT
      confirmed this session -- it is catalogued below WITH this
      caveat, not presented as uncontested national law.
    - By contrast, `www.yemen-nic.info` (Yemen's National Information
      Center legislation database) is live, and every law cited from
      it below (1991-2007) predates the 2014-2015 political split, so
      their status as general Yemeni statute does not turn on which
      post-2014 authority currently controls this particular hosting
      site -- pre-2014 legislation is generally understood to continue
      in force under both administrations absent explicit repeal,
      though this session did NOT independently obtain a side-by-side
      IRG-specific confirmation for each individual law (a disclosed
      limitation, not resolved by assumption). This database's own
      'About the Center' page footer reads 'Copyright (c) National
      Information Center 2014', and its law-year search filter tops
      out at 2021, suggesting the site itself has not been
      substantively maintained/re-branded by either post-split
      authority -- treated here as a reasonably neutral historical
      legal-text repository for the pre-split laws it hosts, not as a
      live current-affairs source.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries."
  {"YEM"
   [{:statute/id "yem.tenders-auctions-warehouses-law-23-2007"
     :statute/title "Law Concerning Tenders, Auctions and Government Warehouses (قانون المناقصات والمزايدات والمخازن الحكومية), establishing the Supreme Authority for Oversight of Tenders and Auctions (الهيئة العليا للرقابة على المناقصات والمزايدات)"
     :statute/jurisdiction "YEM"
     :statute/kind :law
     :statute/law-number "Law No. 23 of 2007 (repealed prior Law No. 3 of 1997)"
     :statute/url "https://www.yemen-nic.info/db/laws_ye/detail.php?ID=15594"
     :statute/url-provenance :official-yemen-nic-info-legislation-database
     :statute/enacted-date "2007-08-14"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:public-procurement :market-entry}}
    {:statute/id "yem.decree-law-33-1991-commercial-registry"
     :statute/title "Republican Decree-Law Concerning the Commercial Registry, as amended (القرار الجمهوري بالقانون بشأن السجل التجاري المعدل)"
     :statute/jurisdiction "YEM"
     :statute/kind :decree
     :statute/law-number "Decree-Law No. 33 of 1991 (repealed prior Sana'a Law No. 12/1976 and Aden Law No. 14/1969)"
     :statute/url "https://www.moit.gov.ye/legislations/laws"
     :statute/url-provenance :official-moit-gov-ye-legislation-library-sanaa-authority
     :statute/enacted-date "1991-04-13"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:market-entry :corporate-governance :incorporation}}
    {:statute/id "yem.law-22-1997-commercial-companies"
     :statute/title "Commercial Companies Law, as amended by Law No. 28 of 2004 (قانون الشركات التجارية وتعديلاته)"
     :statute/jurisdiction "YEM"
     :statute/kind :law
     :statute/law-number "Law No. 22 of 1997, as amended by Law No. 28 of 2004"
     :statute/url "https://www.moit.gov.ye/legislations/laws"
     :statute/url-provenance :official-moit-gov-ye-legislation-library-sanaa-authority
     :statute/enacted-date "1997-04-06"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:company-law :corporate-governance}}
    {:statute/id "yem.decree-law-5-1995-labor-law"
     :statute/title "Labor Law, as amended by Laws No. 25/1997, No. 11/2001, No. 25/2003 (قانون العمل وتعديلاته)"
     :statute/jurisdiction "YEM"
     :statute/kind :decree
     :statute/law-number "Republican Decree-Law No. 5 of 1995, as amended by Laws No. 25/1997, No. 11/2001, No. 25/2003"
     :statute/url "https://www.yemen-nic.info/db/laws_ye/detail.php?ID=11439"
     :statute/url-provenance :official-yemen-nic-info-legislation-database
     :statute/enacted-date "1995-03-09"
     :statute/last-revised-date "2003-03-05"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :market-entry}}
    {:statute/id "yem.law-19-2001-general-sales-tax"
     :statute/title "General Sales Tax Law, as amended by Laws No. 36/2002 and No. 14/2004 (قانون الضريبة العامة على المبيعات وتعديلاته)"
     :statute/jurisdiction "YEM"
     :statute/kind :law
     :statute/law-number "Law No. 19 of 2001, as amended by Law No. 36 of 2002 and Law No. 14 of 2004"
     :statute/url "https://www.yemen-nic.info/db/laws_ye/detail.php?ID=11733"
     :statute/url-provenance :official-yemen-nic-info-legislation-database
     :statute/enacted-date "2001-12-31"
     :statute/last-revised-date "2004-06-30"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:tax}}
    {:statute/id "yem.law-22-2002-investment-law"
     :statute/title "Investment Law (قانون الاستثمار), establishing the General Investment Authority (الهيئة العامة للاستثمار / GIA) -- the pre-2014-split, still-standing founding statute of Yemen's national investment regime"
     :statute/jurisdiction "YEM"
     :statute/kind :law
     :statute/law-number "Law No. 22 of 2002 (itself superseding earlier Law No. 22 of 1991 as amended by Decree-Law No. 14 of 1995)"
     :statute/url "https://www.yemen-nic.info/db/laws_ye/detail.php?ID=11773"
     :statute/url-provenance :official-yemen-nic-info-legislation-database
     :statute/enacted-date "2002-07-20"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:foreign-investment :tax}}
    {:statute/id "yem.law-3-1446-2025-investment-law-contested"
     :statute/title "'Investment Law 2025' (قانون الاستثمار 2025) -- CONTESTED: issued via the Sana'a-based Ministry of Economy, Industry and Investment's own legislative process (State Legal Bureau), not confirmed recognized by the internationally-recognized government (IRG, seat in Aden); see catalog docstring disclosure. Only a webpage-level summary was read this session, NOT the full ~20MB PDF text -- no article-level provision from this specific law is asserted anywhere in this repository"
     :statute/jurisdiction "YEM"
     :statute/kind :law
     :statute/law-number "Law No. 3 of 1446H (2025)"
     :statute/url "https://www.moit.gov.ye/Investment-Law"
     :statute/url-provenance :official-moit-gov-ye-sanaa-authority-contested-legitimacy-webpage-summary-only
     :statute/enacted-date "2025-01-05"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:foreign-investment}}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-yem statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "YEM")) " YEM statutes seeded, sourced from "
                 "yemen-nic.info (pre-2014-split laws: tenders/auctions, labor, "
                 "sales tax, 2002 investment law) and moit.gov.ye (Sana'a-authority "
                 "PDF library: Commercial Registry, Commercial Companies laws, plus "
                 "one explicitly CONTESTED 2025 investment law). No income-tax law "
                 "citation was confirmable this session (Ministry of Finance site "
                 "unreachable; ILO NATLEX Cloudflare-gated) -- disclosed as a gap, "
                 "never fabricated. Extend `statute.facts/catalog`, never fabricate "
                 "a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
