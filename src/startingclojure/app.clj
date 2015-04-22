(ns startingclojure.app
  (:use (compojure handler
                   [core :only (GET POST defroutes)]))
  (:require [net.cgrand.enlive-html :as html]
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
(html/deftemplate homepage
  (html/xml-resource "homepage.html");;loads content from classpath in resources
  [request]
)

(html/deftemplate list-template 
  "other.html" [request])

;handler
(defn redirect
  [id]
  (response/redirect (@urls id)))

(defn lists [name]
  (str name))

(defn list-html [content]
  (str content))

(defroutes app
  (GET "/" request (homepage request))
  (GET "/template" request (list-template request))
  (POST "/shorten" request (let [id (shorten ( -> request :params :url))]
                              (response/redirect "/")))
  (GET "/show/get" request 
       {:status 200
        :body (with-out-str(println request))
        :headers {"Content-Type" "text/plain"}});jump out of compojure and use ring response directly
  (POST "/show/post" request (str request))
  (GET "/:id" [id] (redirect id)) 
  (GET "/names/:name" [name] (lists (str name)))
  (GET "/names/:ring" [ring]
       {:status 200
        :body (list-html (str ring))
        :header {"Content-Type" "text/html"}}))
                         







