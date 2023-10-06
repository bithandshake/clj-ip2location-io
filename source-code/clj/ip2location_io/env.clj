
(ns ip2location-io.env
    (:require [io.api                :as io]
              [ip2location-io.config :as config]
              [ip2location-io.state  :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-api-key
  ; @ignore
  []
  (or @state/API-KEY (reset! state/API-KEY (-> config/CONFIG-FILE-FILEPATH io/read-edn-file :api-key))))

(defn ip-address->uri
  ; @ignore
  ;
  ; @param (string) ip-address
  ;
  ; @usage
  ; (ip-address->uri "x.x.x.x")
  ;
  ; @return (string)
  [ip-address]
  (let [api-key (get-api-key)]
       (str "http://api.ip2location.io/?ip="ip-address"&key="api-key)))
