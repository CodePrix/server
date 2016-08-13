(ns codeprix.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [codeprix.handler :refer :all]))

(deftest test-app
  (testing "name route"
    (let [response (app (mock/request :get "/name/Jyo"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello Jyo"))))

  (testing "add route"
    (let [reposnse (app (mock/request :get "/add/1/2"))]
      (is (= (:status reposnse) 200))
      (is (= (:body reposnse) "3"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
