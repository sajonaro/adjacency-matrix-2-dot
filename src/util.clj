(ns util
  ((:require '[clojure.pprint :as pp])))


(defn print-table [aseq column-width]
  (binding [*out* (get-pretty-writer *out*)]
    (doseq [row aseq]
      (doseq [col row]
        (cl-format true "~4D~7,vT" col column-width))
      (prn))))
    
(print-table (map #(vector % (* % %) (* % % %)) (range 1 11)) 8)


