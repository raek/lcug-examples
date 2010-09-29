(ns se.raek.lcug.titlebot
  (:use irclj.irclj
	net.cgrand.enlive-html))

(defn on-message [m]
  (let [{:keys [nick channel message irc]} m]
    (when-let [url (re-find #"http://[^ ]+" message)]
      (try
	(let [title (-> url
			java.net.URL.
			html-resource
			(select [:title])
			first
			:content
			first)]
	  (when title
	    (send-message irc channel (str \" title \"))))
	(catch Exception _
	  nil)))))

(defonce bot
  (connect (create-irc {:name (format "titlebot%03d" (rand-int 1000))
			:server "irc.freenode.net"
			:fnmap {:on-message #'on-message}})
	   :channels ["#lcug"]
	   :in-encoding "X-UTF-8_with_ISO-8859-1_fallback"
	   :out-encoding "UTF-8"))
