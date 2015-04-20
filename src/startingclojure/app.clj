(ns startingclojure.app
  (:use (compojure handler
                   [core :only (GET POST defroutes)]))
  (:require [net.cgrand.enlive-html :as en]
            [ring.util.response :as response]
            [ring.adapter.jetty :as jetty]))


(defonce counter (atom 10000));;atomic reference , reference to mutable value 
(defonce urls (atom {}))


(defn shorten ;;could use db to store as opposed to in memory datastore(atom) 
  [url]
  (let [id (swap! counter inc)
        id (Long/toString id 36)];; long to string base 36 - 7pt , etc.
    (swap! urls assoc id url)))

;handler
(en/deftemplate homepage
  (en/xml-resource "homepage.html");;loads content from classpath in resources
  [request]
)

;handler
(defn redirect
  [id]
  (response/redirect (@urls id)))

(defroutes app
  (GET "/" request (homepage request))
  (POST "/shorten" request (let [id (shorten ( -> request :params :url))]
                              (response/redirect "/")))
  (GET "/show/get" request (str request))
  (POST "/show/post" request (str request))
  (GET "/:id" [id] (redirect id)))
                         







