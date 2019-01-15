(ns app
  (:gen-class)
  (:require [config.core :refer [env]]
            [models.users :as users]))

(defn -main [& args]
  (println "Create users!")
  (users/create-user {:username "user1" :email "user1@example.com" :title "Mr" :first_name "James" :surname "Kook"})
  (println "Read users!")
  (println (users/read-user {:username "user1"}))
  (println "Delete users!")
  (users/delete-user {:username "user1"}))
