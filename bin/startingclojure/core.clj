(ns startingclojure.app
  (:use (compojure handler
                   [core :only (GET POST defroutes)]))
  (:require [ring.adapter.jetty :as jetty]))

;(defn app 
;  [request]
;  {:status 200
;   :body (:uri request)})

(defn homepage
  [request])

(defn redirect
  [id]
  id)

(defroutes app
  (GET "/" request (homepage request))
  (GET "/:id" [id] (redirect id)))






