(ns sylvi.navi
  (:require [reagent.core :as reagent]
            ))

(defn navi-component []
  [:nav {:class "navbar navbar-default"}
   [:div {:class "container-fluid"}
    [:div {:class "navbar-header"}
     [:href {:class "navbar-brand" } "About"]
     ]
    ]
   ]
  )