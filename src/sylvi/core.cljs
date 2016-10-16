(ns sylvi.core
  (:require [reagent.core :as reagent]
            ))

;; -------------------------
;; Views

(defn home-render []
  [:div {:style {:height "600px" :width "900px"}}
   ])

(defn google-map [map-canvas map-options]
  (js/google.maps.Map. map-canvas map-options)
  )

(defn home-did-mount [this]
  (let [map-canvas (reagent/dom-node this)
        map-options (clj->js {"center" (google.maps.LatLng. 61.387595, 24.5059)
                              "zoom"   8})
        google-map (google-map map-canvas map-options)]
    (js/google.maps.Marker. (clj->js {"position" (google.maps.LatLng. 61.387595, 24.5059) "map" google-map}))
    (print google-map)

    google-map
    ))

(defn home []
  (reagent/create-class {:reagent-render      home-render
                         :component-did-mount home-did-mount}))

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
