(ns settings
  (:require [config.core :refer [env]]))

(defn create-db-spec [runtime-env-db]
  (let [{subprotocol :dbtype
         host :host
         port :port
         user :user
         password :password
         dbname :dbname} runtime-env-db
         subname (format "//%s:%s/%s" host port dbname)]
    {:url (str "jdbc:" subprotocol ":" subname)
     :user user
     :password password}))

(def db-spec (create-db-spec (get-in env [:runtime :db])))
(def redis-spec (get-in env [:runtime :redis]))
