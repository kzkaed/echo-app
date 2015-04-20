(ns startingclojure.app-test
  (:require [clojure.test :refer :all]
            [startingclojure.app :refer :all]))


(deftest shorten-test
  (testing "maps a shortened url from a url"
           (is (= {"7pt" "http://scuitgera.com"} (shorten "http://scuitgera.com")))))
