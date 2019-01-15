(ns db
  (:require [settings :refer [db-spec]]
            [jdbc.core :as jdbc])
  (:import [java.sql Connection DriverManager]
           (com.mchange.v2.c3p0 ComboPooledDataSource)))

(defn get-datasource [db-spec]
  (let [{url :url
         user :user
         password :password} db-spec]
    (doto (ComboPooledDataSource.)
              (.setDriverClass "com.mysql.jdbc.Driver")
              (.setJdbcUrl url)
              (.setUser user)
              (.setPassword password)
              ;; Pool Size Management
              (.setMinPoolSize 2)
              (.setMaxPoolSize 20)
              (.setAcquireIncrement 5)
              (.setMaxStatements 180)
              ;; Connection eviction
              (.setMaxConnectionAge 3600)
              (.setMaxIdleTime 1800)
              (.setMaxIdleTimeExcessConnections 120)
              ;; Connection testing
              (.setTestConnectionOnCheckin false)
              (.setTestConnectionOnCheckout false)
              (.setIdleConnectionTestPeriod 600))))

(def ds (get-datasource db-spec))
(defn db-conn [] (jdbc/connection ds))
