# cloud-itonami-iso3166-yem

**`:implemented`** for **YEM** (Yemen). Flagship `non-yemeni-workforce-quota-exceeded`, secondary `cr-unverified`.

```
kbb -M:dev:test
```

AGPL-3.0-or-later.

## Yemen-specific grounding

- **Supreme Authority for Oversight of Tenders and Auctions (الهيئة
  العليا للرقابة على المناقصات والمزايدات)** -- Law No. 23 of 2007
  Concerning Tenders, Auctions and Government Warehouses
  (https://www.yemen-nic.info/db/laws_ye/detail.php?ID=15594), Art.
  42-43. Bid documentation per Art. 9(b): contractor/supplier
  classification certificate, professional-practice license, tax
  card, sales-tax registration certificate.
- **Commercial Registry** -- administered by the Ministry of Economy,
  Industry and Investment (https://www.moit.gov.ye/legislations/laws),
  under Republican Decree-Law No. 33 of 1991 (as amended). Art. 11:
  trading without registration is prohibited; merchant status attaches
  only from date of registration. Art. 3: 60-day registration
  deadline.
- **Commercial Companies Law No. 22 of 1997** (as amended by Law No.
  28/2004) -- minimum joint-stock company capital: 50 million YER
  (public subscription) / 15 million YER (closed/private).
- **Labor Law No. 5 of 1995** (as amended) -- Article 21: a foreign
  employer's non-Yemeni workforce may not exceed 10% of its Yemeni
  workforce. This is the flagship governor check's statutory ground.
- **Investment Law No. 22 of 2002** -- establishes the General
  Investment Authority (GIA); Art. 23 sets a 50 million YER minimum
  fixed-asset threshold (excluding land/buildings) to qualify under
  the law's guarantees regime.
- **CONTESTED**: a 2025 "Investment Law" (No. 3 of 1446H) is issued
  via Yemen's Sana'a-based Ministry of Economy, Industry and
  Investment -- a Houthi/Ansar Allah-aligned authority site, not the
  internationally-recognized government (IRG, seat in Aden). Its
  recognition outside Houthi-controlled territory was NOT confirmed
  this session; only a webpage-level summary was read (not the full
  PDF text), and no article-level claim from it appears anywhere in
  this repository.

See `docs/business-model.md`'s "Institutional-instability disclosure"
section for the full picture, including what could NOT be
independently confirmed this session: no income-tax law citation
(Ministry of Finance site unreachable), and ILO NATLEX was excluded
entirely after returning a genuine Cloudflare bot-detection challenge
(never bypassed, per this fleet's hard safety rules).

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Yemen:

- `src/culture/facts.cljk` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
