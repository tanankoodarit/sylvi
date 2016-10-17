(ns sylvi.core
  (:require [reagent.core :as reagent]
            [cljsjs.bootstrap]
            [sylvi.navi :refer [navi-component]]
            [sylvi.map :refer [google-map-component]]
            ))

;; -------------------------
;; Views


(defn home []
  [:div
   [navi-component]
   [:div {:class "container"}
    [:div {:class "row"}
     [google-map-component]
     ]]]
  )

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
