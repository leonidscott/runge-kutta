(ns runge-kutta.numerical-methods)

(def ^:private output-points (atom []))

(defn- k1
  "k1 = h f(ti yi)"
  [f ti yi h]
  (* (f ti yi) h))

(defn- k2-3
  "k2 = h f(ti + h/2, yi + k1/2)
   k3 = h f(ti + h/2, yi + k2/2)"
  [f ti yi h k]
  (* (f (+ ti (/ h 2))
        (+ yi (/ k 2)))
     h))

(defn- k4
  "k4 = h f(ti, wi + k3)"
  [f ti yi h k3]
  (* (f ti (+ yi k3))
     h))

(defn- y-ip1
  [f ti yi h]
  (let [k1 (k1 f ti yi h)
        k2 (k2-3 f ti yi h k1)
        k3 (k2-3 f ti yi h k2)
        k4 (k4 f ti yi h k3)]
    (+ yi (/ (+ k1 (* 2 k2) (* 2 k3) k4)
             6))))

(defn rk4
  "f = f(t,y) = dy/dt
   ivp = {:x0 :y0}
   input-points = [t0, t1, ..., tn]
   h = stepsize"
   [f {:keys [t0 y0]} domain h]
   (reset! output-points [{:t t0 :y y0}])
   (loop [ti t0
          yi y0
          current-step h]
    (if (> (+ current-step h) domain)
        @output-points
        (let [yip1 (y-ip1 f ti yi h)]
          (swap! output-points conj {:t (+ ti h) :y yip1})
          (recur (+ ti h)
                 yip1
                 (+ h current-step))))))
