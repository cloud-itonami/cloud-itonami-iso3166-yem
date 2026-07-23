# Operator Guide

## First Deployment

1. Confirm the client's incorporation/legal-entity status is complete
   (route to `cloud-itonami-M6910` or local counsel first if not).
2. Register the client's intake: business type, target public function,
   whether the client intends to hire any non-Yemeni workers.
3. Run the advisor in read-only mode against Law No. 23 of 2007
   Concerning Tenders, Auctions and Government Warehouses (bid-
   documentation requirements: contractor/supplier classification
   certificate, professional-practice license, tax card, sales-tax
   registration certificate).
4. Compare the checklist against the client's current documentation
   (Commercial Registry entry under Decree-Law No. 33/1991).
5. If the client intends to hire non-Yemeni workers, run the
   Yemenization labor-quota pre-check (Labor Law No. 5/1995 Art. 21 --
   non-Yemeni headcount may not exceed 10% of Yemeni headcount) BEFORE
   drafting a filing, not after.
6. Enable gated filing-draft assistance once the Market-Entry Compliance
   Governor contract is trusted; actual submission always requires human
   sign-off.

## Yemenization labor-quota check — do not conflate with generic registration

Article 21 of Labor Law No. 5/1995 (as amended) caps a single
employer's non-Yemeni workforce at 10% of its Yemeni workforce. This
is a PER-EMPLOYER ratio, not a national aggregate, and it is
independent of whether the employer's Commercial Registry or tender
classification paperwork is otherwise complete — an operator can be
fully registered and still fail this check if its declared foreign-
hiring plan exceeds the ratio. The governor recomputes the ratio from
the engagement's own declared `:non-yemeni-worker-count` /
`:yemeni-worker-count` fields every time; it never trusts a claimed
percentage, and it never fires for an engagement that does not declare
foreign-hiring intent at all (`:requires-foreign-worker-hiring?
false`).

## Minimum Production Controls

- client-owned data store for business/tax registration documents
- clear provenance (official statute/legislation-database citation)
  for every requirement surfaced
- approval workflow for any tender registration or filing submission
- named referral relationship with Yemeni-licensed counsel or a
  registered agent for anything beyond checklist/draft assistance
- monthly audit export
- awareness that Yemen's government web infrastructure is genuinely
  fragmented across two competing governing authorities (this session
  found Yemen's General Investment Authority reduced to a parked
  placeholder page, the Ministry of Finance unreachable, and ILO
  NATLEX behind an active Cloudflare challenge) -- operators should
  independently verify a citation's freshness and its issuing
  authority's current recognition before relying on it for a live
  filing, rather than assuming any single government portal speaks for
  all of Yemen

## Certification

Certified operators must prove data provenance, audit traceability, that
automated actions cannot bypass the Market-Entry Compliance Governor, and
a working referral relationship with Yemeni-licensed counsel or a
registered agent for whatever licensed representation the law of
Yemen requires for actual public-procurement filings.
