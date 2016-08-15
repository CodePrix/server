(defproject codeprix "0.1.0-SNAPSHOT"
  :description "The Server Code for CodePrix"
  :url "https://github.com/JyotsnaGorle/CodePrix"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-anti-forgery "1.0.1"]
                 [cheshire "5.6.3"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler codeprix.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
