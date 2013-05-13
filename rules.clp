(bind ?name andrew)
(bind ?sol (> 2 3))
(assert (dog_breeds andrew))
(defrule start-up
(andrew)
=>
(printout t "Hello indecisive homo sapien. " ?sol " The ‘wise one’ is here to help!" ?name crlf )
(printout t "Hello indecisive homo sapien. " crlf ))
(facts)
;(defrule check-cpu 
;=>
;(printout t "CPU level is: "?cpu crlf)
;)
 (deftemplate hungry-agent
            (slot name)
            (slot hungry))
(defrule eat-lunch2
            ?agent <- (hungry-agent (name ?name) (hungry TRUE))
            (food-available)
            =>
            (modify ?agent (hungry FALSE))
            (printout t ?name “ has lunch.” crlf))