
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

The <strong>clj-ip2location-io</strong> functional documentation is [available here](documentation/COVER.md).

### Changelog

You can track the changes of the <strong>clj-ip2location-io</strong> library [here](CHANGES.md).

# Usage

### Index

- [How to configure the location service?](#how-to-configure-the-location-service)

- [How to locate an IP address?](#how-to-locate-an-ip-address)

### How to configure the location service?

Before using the `ip2location-io.api/locate-ip-address` function, provide your `ip2location.io`
API key in a configuration file that you have to place under the `environment/ip2location-io.config.edn`
filepath in the following format:

```
{:api-key "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}
```

### How to locate an IP address?

The [`ip2location-io.api/locate-ip-address`](documentation/clj/ip2location-io/API.md/#locate-ip-address)
function connects to the ip2location.io API and returns the location details of the given IP address.

```
(locate-ip-address "x.x.x.x")
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
