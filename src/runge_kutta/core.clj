(ns runge-kutta.core
    (:require [runge-kutta.numerical-methods :as nm]))

(use 'prc)

(defn poly-ex
    "y'(t) = -2y^2 + ty + t^2"
    [t y]
    (+ (* -2 (* y y))
       (* t y)
       (* t t)))

(proto-repl-charts.charts/line-chart
    "RK4 Chart"
    {"RK4" (nm/rk4 poly-ex {:t0 0 :y0 1} 1.0 0.1)}
    {:labels (range 0 1 0.1)})

(proto-repl-charts.table/table
    "RK Table"
    (nm/rk4 poly-ex {:t0 0 :y0 1} 1.0 0.1)
    )

(defn -main []
  (println (nm/rk4 poly-ex {:t0 0 :y0 1} 1.0 0.1)))
