(ns adjacency
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.string :as string])
  (:gen-class))

(def cli-options
  ;; An option with a required argument
  [["-m" "--matrix MATRIX" "adjacency matrix"]
   ["-f" "--file NAME" "File names to read"
    :multi true ; use :update-fn to combine multiple instance of -f/--file
    :default []
    ;; with :multi true, the :update-fn is passed both the existing parsed
    ;; value(s) and the new parsed value from each option
    :update-fn conj]

   ["-h" "--help" :default false]])


(defn usage []
  (->> [""
        "Usage: adj2dot [options] "
        ""
        "Options:"
        "  -m or --matrix      adjacency matrix defined as clojure vector e.g [[1 0] [0 1]]"
        "  -h or --help        usage help"
        ""
        "Please refer to the manual page for more information."]
       (string/join \newline)))


(defn -main
  [& args]
  (let [arguments (parse-opts args cli-options)
        options (:options arguments)
        summary (:summary arguments)]
    (if (:help options)
      (println (usage))
      (println (options)))))
