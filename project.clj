(defproject db-api-app "0.1.0"
  :description "DB API example"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [yogthos/config "1.1.1"]
                 [funcool/clojure.jdbc "0.9.0"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [com.mchange/c3p0 "0.9.5"]]
  :main ^:skip-aot app
  :profiles {:dev {:resource-paths ["config/dev"]}})
