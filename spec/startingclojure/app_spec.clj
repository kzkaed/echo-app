(ns startingclojure.app-spec
     (:require [speclj.core :refer :all]
               [startingclojure.app :refer :all]))
 
	(describe "shorten"
	   (it "should map a shortened string url of base 36 from a long url"
	       (should= {"7pt" "http://scuitgera.com"}  (shorten "http://scuitgera.com")))
    
  
	   
	)
  



