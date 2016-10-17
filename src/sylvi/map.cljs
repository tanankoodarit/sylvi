(ns sylvi.map
  (:require [reagent.core :as reagent]
            ))

(defn map-render []
  [:div {:class "col-md-12" :style {:height "600px"}}])

(defn google-map [map-canvas map-options]
  (js/google.maps.Map. map-canvas map-options)
  )

(def routes
  [{:lat 61.387595 :lng 24.5059}
   {:lat 60.8806011 :lng 24.4371625}
   {:lat 60.6477312 :lng 24.7697714}
   {:lat 60.5027627 :lng 24.9842778}
   {:lat 60.3300189 :lng 24.2560676}
   ]
  )

(defn route-lines [google-map]
  (let [lines (js/google.maps.Polyline. (clj->js {:path         routes
                                                  :strokeColor  "#FF0000" :strokeOpacity 1.0,
                                                  :strokeWeight 2}))]
    (.setMap lines google-map)
    )
  )

(defn markerPlace [google-map location]
  (println location)
  (js/google.maps.Marker. (clj->js {"position" (google.maps.LatLng. (:lat location), (:lng location))
                                    "map" google-map
                                    "icon" "https://maps.google.com/mapfiles/kml/shapes/info-i_maps.png"
                                    "title" "Hello World!"}))
  )

(defn map-did-mount [this]
  (let [map-canvas (reagent/dom-node this)
        map-options (clj->js {"center"         (google.maps.LatLng. 61.387595, 24.5059)
                              "zoom"           8

                              "mapTypeControl" true})
        google-map (google-map map-canvas map-options)
        ]
    (doseq [location routes]
      (markerPlace google-map location))
    (route-lines google-map)
    google-map
    ))

(defn google-map-component []
  (reagent/create-class {:reagent-render      map-render
                         :component-did-mount map-did-mount}))