
(ns ip2location-io.api
    (:require [ip2location-io.engine :as engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (ip2location-io.engine/*)
(def locate-ip-address engine/locate-ip-address)
