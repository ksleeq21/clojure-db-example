(ns models.users
  (:use [jdbc.core :as jdbc]
        [db :refer [db-conn]]))

(defn read-user [data]
  (with-open [conn (db-conn)]
    (let [{username :username} data
          query "SELECT id, username, email, title, first_name, surname, created_at, updated_at
                 FROM users
                 WHERE username = ?"]
     (jdbc/fetch conn [query username]))))

(defn create-user [row]
  (with-open [conn (db-conn)]
    (let [{username :username
           email :email
           title :title
           first_name :first_name
           surname :surname} row
          query "INSERT INTO users (username, email, title, first_name, surname)
                 VALUES (?, ?, ?, ?, ?)"]
     (jdbc/execute conn [query username, email, title, first_name, surname]))))

(defn delete-user [data]
  (with-open [conn (db-conn)]
    (let [{username :username} data
          query "DELETE FROM users WHERE username = ?"]
     (jdbc/execute conn [query username]))))
