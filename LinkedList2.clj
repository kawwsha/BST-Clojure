(definterface iNode 
	(getInfo [])
	(getPtr  [])
	(setInfo [x])
	(setPtr  [x]))

(deftype Node 
	[^:volatile-mutable info 
	 ^:volatile-mutable ptr]
; Woah what is ^:volatile-mutable!?

;; To learn about Metadata read: http://clojure.org/metadata

; volatile allows our field to be visible to 
; all other threads.
; ¿! Heads Up ¡?
; When we make a field volatile it makes it PRIVATE!
; So lets apply the interface for setters and getters
	iNode
	(getInfo [this] info)
	(getPtr  [this] ptr)
	(setInfo [this x] (set! info x))
	(setPtr  [this x] (set! ptr  x)))

(def bbq     (Node. "barbeque" nil))
(def mayo    (Node. "mayonaise" nil))
(def mustard (Node. "mustard" nil))
(def ketchup (Node. "katsup" nil)); oops! who calls it that

;(println (.getInfo ketchup))
(.setInfo ketchup "ketchup") ; much better ;)
(println (.getInfo ketchup))

; A saucey Linked-list using a head node 
; (no difference between head node and )
(def sauces (Node. "Sauces" bbq))
(.setPtr bbq mayo)
(.setPtr mayo  mustard)
(.setPtr mustard ketchup)

; One last thing, lets go through the chain
(defn chain-print [current]
	(when (some? current)
		(println (.getInfo current))
		(chain-print (.getPtr current))
; Returns this string at the end since 
; returning nil is :(
	"Reached end of Linked-List"))
; woo! -- recursion
(chain-print sauces)