
# clj-ip2location-io

### Overview

The <strong>clj-ip2location-io</strong> is a simple Clojure API library for ip2location.io.

### deps.edn

```
{:deps {bithandshake/clj-ip2location-io {:git/url "https://github.com/bithandshake/clj-ip2location-io"
                                         :sha     "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}}
```

### Current version

Check out the latest commit on the [release branch](https://github.com/bithandshake/clj-ip2location-io/tree/release).

### Documentation

The <strong>clj-ip2location-io</strong> functional documentation is [available here](https://bithandshake.github.io/clj-ip2location-io).

### Changelog

You can track the changes of the <strong>clj-ip2location-io</strong> library [here](CHANGES.md).

# Usage

> Some parameters of the following functions and some further functions are not discussed in this file.
  To learn more about the available functionality, check out the [functional documentation](documentation/COVER.md)!

### Index

- [How to locate an IP address?](#how-to-locate-an-ip-address)

### How to locate an IP address?

The [`ip2location-io.api/locate-ip-address`](documentation/clj/ip2location-io/API.md/#locate-ip-address)
function connects to the ip2location.io API and returns the location details of the given IP address.

```
(locate-ip-address "x.x.x.x" "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
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
```
