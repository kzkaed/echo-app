(defproject startingclojure "0.1.0-SNAPSHOT"
  :description "description"
  :url "url"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.3.2"]
                 [compojure "1.3.3"]
                 [enlive "1.1.5"]
                 [ring-mock "0.1.3"]
                 [camel-snake-kebab "0.1.2"]
                 [speclj "3.2.0"]]
  :profiles {:dev {:dependencies [[speclj "3.2.0"]]}}
  :plugins [[speclj "3.2.0"]]
  :test-paths ["spec"])
