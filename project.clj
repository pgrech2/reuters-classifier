(defproject reuters-classifier "0.1.0-SNAPSHOT"
  :description "A clojure project to classify the Reuters-21578 R8 Dataset"
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"]
                 [com.stuartsierra/component "0.3.2"]

                 [clojure-nlp "0.1.0-snapshot"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]
                                  [clojure-data "0.1.0-snapshot"]]
                   :source-paths ["dev"]}})
