(ns codeprix.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.anti-forgery :refer :all]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.session.cookie :refer (cookie-store)]
            [cheshire.core :refer :all]))
(defn add
  [a b]
  (+ a b))

(defroutes app-routes
  (GET "/name/:name" [name] (str "Hello " name))
  (GET "/add/:a/:b" [a b] (str (add (Integer. a) (Integer. b))))
  (GET "/" [] (generate-string {:csrf-token *anti-forgery-token*}))
  (POST "/callback" {params :params} (str (pr-str params)))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
  (wrap-defaults site-defaults)
  (wrap-session {:cookie-attrs {:max-age 3600}
                 :store (cookie-store {:key "ahY9poQuaghahc7I"})})))
