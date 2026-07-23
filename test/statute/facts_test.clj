(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is testing]]
            [statute.facts :as facts]))

(deftest yem-has-spec-basis
  (let [sb (facts/spec-basis "YEM")]
    (is (= 7 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["YEM" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["yem.tenders-auctions-warehouses-law-23-2007"]
         (mapv :statute/id (facts/by-topic "YEM" :public-procurement))))
  (is (= ["yem.decree-law-5-1995-labor-law"]
         (mapv :statute/id (facts/by-topic "YEM" :labor))))
  (is (= ["yem.law-22-1997-commercial-companies"]
         (mapv :statute/id (facts/by-topic "YEM" :company-law))))
  (is (= #{"yem.law-22-2002-investment-law" "yem.law-3-1446-2025-investment-law-contested"}
         (set (mapv :statute/id (facts/by-topic "YEM" :foreign-investment)))))
  (is (empty? (facts/by-topic "YEM" :data-protection)))
  (is (empty? (facts/by-topic "ATL" :labor))))

(deftest contested-2025-investment-law-is-flagged
  (testing "the Sana'a-authority-issued 2025 investment law is disclosed as contested, never presented as uncontested"
    (let [e (first (filter #(= (:statute/id %) "yem.law-3-1446-2025-investment-law-contested")
                            (facts/spec-basis "YEM")))]
      (is (some? e))
      (is (str/includes? (:statute/title e) "CONTESTED"))
      (is (= :official-moit-gov-ye-sanaa-authority-contested-legitimacy-webpage-summary-only
             (:statute/url-provenance e))))))
