# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Yemen

## Classification

- Repository: `cloud-itonami-iso3166-yem`
- ISO 3166: `YEM` (Yemen)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:yemeni-sme-market-access :public-spend-transparency :yemenization-labor-quota-compliance]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Yemeni
  public contract
- a foreign SME or contractor entering the public sector in Yemen for
  the first time, particularly one that intends to hire non-Yemeni
  staff and needs to independently verify it clears the Yemenization
  labor quota before submitting a tender
- a `cloud-itonami-M6910` client that has just completed incorporation
  and now needs public-sector market access

## Offer

- registration/classification walkthrough against the requirements of
  Law No. 23 of 2007 Concerning Tenders, Auctions and Government
  Warehouses (Art. 9(b): contractor/supplier classification
  certificate, professional-practice license, tax card, sales-tax
  registration certificate)
- business/registration checklist: Commercial Registry entry
  (Decree-Law No. 33/1991, as amended, administered by the Ministry of
  Economy, Industry and Investment)
- Yemenization labor-quota pre-check: independently recompute a
  prospective foreign employer's declared non-Yemeni:Yemeni worker
  ratio against Labor Law No. 5/1995 Article 21's 10% statutory cap
  BEFORE a filing is submitted, not after
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual tender registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold that
  cannot be overridden by human approval alone — it must be corrected
  against a cited official source first
- a non-Yemeni workforce ratio that exceeds Labor Law No. 5/1995
  Article 21's 10% statutory cap is a HARD hold: the governor
  independently recomputes the ratio from the engagement's own
  declared headcounts every time, never trusting a claimed percentage
  — a human approver cannot waive a statutory quota
- an unverified Commercial Registry number on a filing that requires
  one (Decree-Law No. 33/1991 Art. 11: trading without registration is
  prohibited) is a HARD hold
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Yemeni-licensed counsel or a registered agent
- every requirement cites the official statute or legislation-database
  record, never invented

## Institutional-instability disclosure (read before relying on any single source)

Yemen has had two competing governing authorities since roughly
2014-2015 — the internationally-recognized government (IRG,
Presidential Leadership Council, seat relocated to Aden) and the
Houthi/Ansar Allah-aligned de facto authorities controlling Sana'a and
much of the north/west. This session found direct, current evidence of
that fragmentation rather than assuming it from memory:

- Yemen's General Investment Authority (`gia.gov.ye`) has NO live web
  presence this session found — the Internet Archive's own 2022-06-30
  snapshot shows only a parked cPanel default page ("Yemen Net Cpanel
  Default Page"), not a functioning GIA site.
- The Ministry of Finance (`mof.gov.ye`) refused a live HTTPS
  connection outright this session (connection refused); its
  2025-08-12 Wayback snapshot is a WordPress-style site with no
  readily browsable legislation index found this session. No
  income-tax (ضريبة الدخل) law citation could be confirmed as a
  result — an honest, disclosed gap, not an invented figure.
- ILO NATLEX (`webapps.ilo.org`) returned a genuine Cloudflare "Just a
  moment..." bot-detection challenge when fetched this session
  (confirmed via the literal page title and Cloudflare challenge
  script in the response body). Per this project's hard safety rules,
  no attempt was made to bypass it, and no Internet Archive Wayback
  Machine snapshot of the Yemen country page could be found either —
  ILO NATLEX was simply unusable as a source this session.
- `moit.gov.ye` ("Ministry of Economy, Industry and Investment") IS
  live and richly populated (a legislation library with direct PDF
  downloads of real, verifiable laws), but its own branches-offices
  page confirms its head office is in **Sana'a** — i.e. it is a
  Sana'a-based / Houthi-aligned-authority ministry site, **not** the
  internationally-recognized government (IRG, seat in Aden). Its "2025
  Investment Law" (Law No. 3 of 1446H) is issued via "المكتب القانوني
  للدولة" (State Legal Bureau), a legislative mechanism specific to
  the Houthi/Sana'a authorities. Whether/how this 2025 law is
  recognized outside Houthi-controlled territory was NOT confirmed
  this session — it is catalogued in `src/statute/facts.cljc` WITH
  this caveat attached (`:statute/url-provenance
  :official-moit-gov-ye-sanaa-authority-contested-legitimacy-webpage-summary-only`),
  never presented as uncontested national law. Only a webpage-level
  summary of this 2025 law was read this session (the underlying
  ~20MB PDF was not fully downloaded/read), so no article-level
  provision from it is asserted anywhere in this repository.
- By contrast, `www.yemen-nic.info` (Yemen's National Information
  Center legislation database) is live, and every law cited from it in
  this repository (1991-2007) predates the 2014-2015 political split,
  so their status as general Yemeni statute does not turn on which
  post-2014 authority currently controls this particular hosting site
  — pre-2014 legislation is generally understood to continue in force
  under both administrations absent explicit repeal, though this
  session did NOT independently obtain a side-by-side IRG-specific
  confirmation for each individual law (a disclosed limitation, not
  resolved by assumption). This database's own "About the Center" page
  footer reads "Copyright (c) National Information Center 2014", and
  its law-year search filter tops out at 2021 — treated here as a
  reasonably neutral historical legal-text repository for the
  pre-split laws it hosts, not as a live current-affairs source.
- The flagship governor check (`non-yemeni-workforce-quota-exceeded`,
  Labor Law No. 5/1995 Article 21) is grounded in a law that predates
  the 2014-2015 split by nearly 20 years, fetched from the
  pre-2014-split `yemen-nic.info` database — chosen deliberately over
  building a check on the CONTESTED 2025 investment law, precisely
  because the political-authority ambiguity around the latter would
  make a HARD, unoverridable governor check built on it unsafe to
  ship.

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law). This blueprint assumes incorporation is already done and
  handles public-procurement market entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Yemen).
