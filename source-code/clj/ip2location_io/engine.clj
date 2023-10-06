
(ns ip2location-io.engine
    (:require [clj-http.client]
              [audit.api          :as audit]
              [ip2location-io.env :as env]
              [json.api           :as json]
              [map.api            :as map]
              [reader.api         :as reader]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn locate-ip-address
  ; @warning
  ; Before using this function, provide your API key in the configuration file
  ; described in the README.MD!
  ;
  ; @param (string) ip-address
  ;
  ; @usage
  ; (locate-ip-address "x.x.x.x")
  ;
  ; @example
  ; (locate-ip-address "x.x.x.x")
  ; =>
  ; {:as           "Go P.L.C."
  ;  :asn          "15735"
  ;  :city-name    "Sliema"
  ;  :country-name "Malta"
  ;  :country-code "MT"
  ;  :ip           "195.158.84.203"
  ;  :is-proxy?    false
  ;  :latitude     "35.9125"
  ;  :longitude    "14.50194"
  ;  :region-name  "Sliema"
  ;  :time-zone    "+02:00"
  ;  :zip-code     "SLM 3180"}
  ;
  ; @return (map)
  ; {:as (string)
  ;   Autonomous system (AS) name.
  ;  :asn (string)
  ;   Autonomous system number (ASN).
  ;  :city-name (string)
  ;   City name.
  ;  :country-code (string)
  ;   Two-character country code based on ISO 3166.
  ;  :country-name (string)
  ;   Country name based on ISO 3166.
  ;  :ip (string)
  ;   IP address.
  ;  :isp (string)
  ;   Internet Service Provider or company's name.
  ;  :is-proxy? (boolean)
  ;  :latitude (string)
  ;   City latitude. Defaults to capital city latitude if city is unknown.
  ;  :longitude (string)
  ;   City longitude. Defaults to capital city longitude if city is unknown.
  ;  :region-name (string)
  ;   Region or state name.
  ;  :time-zone (string)
  ;   UTC time zone (with DST supported).
  ;  :zip-code (string)
  ;   ZIP/Postal code.}
  [ip-address]
  (if (audit/ip-address-valid? ip-address)
      (let [uri      (env/ip-address->uri ip-address)
            response (clj-http.client/get uri)]
           (-> ip-address utils/ip-address->uri
                          clj-http.client/get
                          :body
                          reader/json->map
                          json/hyphenize-keys
                          json/keywordize-keys
                          (map/rekey-item :is-proxy :is-proxy?)))))
