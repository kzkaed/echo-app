(ns startingclojure.app
  (:use (compojure handler
                   [core :only (GET POST defroutes)]))
  (:require [ring.adapter.jetty :as jetty]))

;(defn app 
;  [request]
;  {:status 200
;   :body (:uri request)})

(defonce counter (atom 10000));;atomic reference , reference to mutable value 
(defonce urls (atom {}))


(defn shorten ;;could use db to store as opposed to in memory datastore(atom) 
  [url]
  (let [id (swap! counter inc)
        id (Long/toString id 36)];; long to string base 36 - 7pt , etc.
    (swap! urls assoc id url)))

;handler
(defn homepage
  [request]
  (str @urls));homepage function return nil so 404 - default jetty when no servlet handler

;handler
(defn redirect
  [id]
  id)

(defroutes app
  (GET "/" request (homepage request));ring request map call function and send request
  (GET "/:id" [id] (redirect id)));multi or single segment dispatched to handler redirect "/:id/:name" [id name]






