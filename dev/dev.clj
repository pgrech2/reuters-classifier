(ns dev
  (:require [clojure.java.io :as jio]
            [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pprint]]
            [clojure.reflect :refer [reflect]]
            [clojure.repl :refer [apropos dir doc find-doc pst source]]
            [clojure.set :as set]
            [clojure.string :as string]
            [clojure.test :as test]
            [clojure.tools.namespace.repl :refer [refresh refresh-all clear]]
            [com.stuartsierra.component :as component]
            [com.stuartsierra.component.repl :refer [reset set-init start stop system]]

            [clojure-data.io :as io]
            [clojure-data.load :as load]
            [clojure-data.helpers :as help]

            ;; [clojure-nlp.svm :as svm]

            [reuters-classifier :as rc]))

(clojure.tools.namespace.repl/set-refresh-dirs "dev" "src" "test")

(def data-file "data/r8-train-all-terms.txt")

(defn dev-system
  []
  (component/system-map
   :r8 (load/loader {:file data-file
                     :parse (partial io/read-file #"\t")})))

(set-init (fn [_] (dev-system)))

(defn fetch [sys]
  (load/records (:r8 system) identity))
