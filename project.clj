(defproject runge-kutta "0.1.0-SNAPSHOT"
    :description "ODE numerical methods including Runge-Kutta Order 4"
    :dependencies [[org.clojure/clojure "1.9.0"]
                   [org.clojure/math.numeric-tower "0.0.4"]
                   [clj-auto-diff "0.1.3"]]
    :main runge-kutta.core)
