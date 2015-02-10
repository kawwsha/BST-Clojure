;; Lisp history
; car - Contents of Address part of Register number
;	=> used to get first element of list in lisps
; cdr - Contents of Decrement part of Register number
;	=> used to get the rest of the list in lisps

(deftype Node [info ptr])
; Lets make a linked list of ... noodles?
(def noodles  
	(Node. "Macaroni" 
		(Node. "Rigatoni" 
			(Node. "Spagetti" nil))))
; Node. syntax could be substituted as
; (new Node "foo" nil)
(println (.info noodles))
(println (.ptr noodles))

; Now we know how to make a STATIC linked list
; Unfortunately when this is compiled on the JVM
; the object and its attributes are FINAL / immutable

; So advance to LinkedList2.clj to learn mutable 
; Clojure structs.