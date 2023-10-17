
# ip2location-io.api Clojure namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > ip2location-io.api

### Index

- [locate-ip-address](#locate-ip-address)

### locate-ip-address

```
@param (string) ip-address
@param (string) api-key
```

```
@usage
(locate-ip-address "x.x.x.x" "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
```

```
@example
(locate-ip-address "x.x.x.x" "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
=>
{:as           "Go P.L.C."
 :asn          "15735"
 :city-name    "Sliema"
 :country-name "Malta"
 :country-code "MT"
 :ip           "195.158.84.203"
 :is-proxy?    false
 :latitude     "35.9125"
 :longitude    "14.50194"
 :region-name  "Sliema"
 :time-zone    "+02:00"
 :zip-code     "SLM 3180"}
```

```
@return (map)
{:as (string)
  Autonomous system (AS) name.
 :asn (string)
  Autonomous system number (ASN).
 :city-name (string)
  City name.
 :country-code (string)
  Two-character country code based on ISO 3166.
 :country-name (string)
  Country name based on ISO 3166.
 :ip (string)
  IP address.
 :isp (string)
  Internet Service Provider or company's name.
 :is-proxy? (boolean)
 :latitude (string)
  City latitude. Defaults to capital city latitude if city is unknown.
 :longitude (string)
  City longitude. Defaults to capital city longitude if city is unknown.
 :region-name (string)
  Region or state name.
 :time-zone (string)
  UTC time zone (with DST supported).
 :zip-code (string)
  ZIP/Postal code.}
```

<details>
<summary>Source code</summary>

```
(defn locate-ip-address
  [ip-address api-key]
  (if (audit/ip-address-valid? ip-address)
      (-> (str "http://api.ip2location.io/?ip="ip-address"&key="api-key)
          (clj-http.client/get)
          (:body)
          (reader/json->map)
          (json/hyphenize-keys)
          (json/keywordize-keys)
          (map/rekey-item :is-proxy :is-proxy?))
      (throw (Exception. errors/INVALID-IP-ADDRESS))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [ip2location-io.api :refer [locate-ip-address]]))

(ip2location-io.api/locate-ip-address ...)
(locate-ip-address                    ...)
```

</details>

---

This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.

