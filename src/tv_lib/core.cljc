(ns tv-lib.core
  (:require 
    [clojure.string :as str]))

(def belongs-to-mature #{:MA})

(defn family-show?
  "Checks if the show if family oriented or not"
  [{:keys [rating]}]
  (-> rating
      keyword
      belongs-to-mature
      nil?))

(defn- replace-the
  [name]
  (clojure.string/replace-first name #"(?i)^the\ *" ""))

(defn cmp-without-the
  "Compares two names without the word `the` in the title"
  [name1 name2]
  (->> [name1 name2]
       (map (comp str/lower-case replace-the))
       (apply compare)))
  

