(ns runge-kutta.numerical-methods
    (:require [clj-auto-diff :as d]
              [clojure.math.numeric-tower :as math]))

(defn sqr
    [x]
    (math/expt x 2))

(sqr 6)
