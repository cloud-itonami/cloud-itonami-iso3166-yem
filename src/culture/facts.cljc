(ns culture.facts
  "Country-level regional-culture catalog for Yemen (YEM) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"YEM"
   [{:culture/id "yem.dish.saltah"
     :culture/name "Saltah"
     :culture/country "YEM"
     :culture/kind :dish
     :culture/summary "National dish of Yemen: a brown meat-broth stew (maraq) topped with fenugreek foam (hulbah) and sahawiq (a chili-tomato-herb sauce), widely eaten in the north for lunch and scooped up with khubz mulawah flatbread."
     :culture/url "https://en.wikipedia.org/wiki/Saltah"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "yem.dish.mandi"
     :culture/name "Mandi"
     :culture/country "YEM"
     :culture/kind :dish
     :culture/summary "Meat-and-rice dish cooked in an underground pit with a special spice blend; Yemen is its region of origin, traditionally served on large communal platters with a tangy tomato sauce, and it spread through Yemeni migration to Hyderabadi cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Mandi_(food)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "yem.dish.bint-al-sahn"
     :culture/name "Bint al-sahn"
     :culture/country "YEM"
     :culture/kind :dish
     :culture/summary "Traditional Yemeni pastry (also known as sabayah) of white flour, eggs, yeast and clarified butter (samn) baked in paper-thin layers and topped with honey and black cumin seeds; rarely found in restaurants and usually made at home."
     :culture/url "https://en.wikipedia.org/wiki/Bint_al-sahn"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "yem.product.mokha-coffee"
     :culture/name "Mokha coffee"
     :culture/country "YEM"
     :culture/kind :product
     :culture/summary "Coffee beans from Ethiopia and inland Yemen were shipped abroad through the Yemeni port of Mokha from the 16th through 19th centuries, giving the world the term 'mocha coffee'; Mokha beans remain prized for their distinctive flavor today."
     :culture/url "https://en.wikipedia.org/wiki/Mokha"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "yem.craft.jambiya"
     :culture/name "Jambiya"
     :culture/country "YEM"
     :culture/kind :craft
     :culture/summary "Short ceremonial dagger worn by men in Yemen, originating from the Hadhramaut region; the handle material is a traditional measure of the dagger's value and its owner's social status."
     :culture/url "https://en.wikipedia.org/wiki/Jambiya"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "yem.heritage.old-city-of-sanaa"
     :culture/name "Old City of Sana'a"
     :culture/country "YEM"
     :culture/kind :heritage
     :culture/summary "UNESCO World Heritage Site (designated 1986) in Yemen's Amanat Al Asimah Governorate, a mountain-valley city inhabited for more than 2,500 years known for its many-storeyed tower-houses built of rammed earth."
     :culture/url "https://en.wikipedia.org/wiki/Old_City_of_Sanaa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "yem.heritage.shibam"
     :culture/name "Shibam"
     :culture/country "YEM"
     :culture/kind :heritage
     :culture/summary "Town in eastern Yemen's Hadhramaut region renowned for its distinctive mudbrick high-rise architecture, designated a UNESCO World Heritage Site in 1982."
     :culture/url "https://en.wikipedia.org/wiki/Shibam"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-iso3166-yem culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "YEM"))
                 " YEM entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
