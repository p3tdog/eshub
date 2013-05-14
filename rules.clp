(import model.*)
(deftemplate CatalogItem (declare (from-class CatalogItem)))
(deftemplate ItemList (declare (from-class ItemList)))
(deftemplate Questions (declare (from-class Questions)))
(deftemplate Item (declare (from-class Item)))
(defrule start-up
(Questions {student == TRUE} ) (CatalogItem {warrentyTime > 3} (ID ?ID) (description ?description))
=>
(add (new Item ?ID )))

(defrule run-up
(Questions {student == FALSE} {gamer == FALSE} ) 
(CatalogItem {warrentyTime > 2} 
{memoryRating > 4} 
{memorySize > 12} 
{processorRating >= 4}
(ID ?ID) (description ?description))
=>
(add (new Item ?ID )))

(defrule hold-up
(Questions {student == FALSE} {gamer == TRUE} ) 
(CatalogItem {warrentyTime > 2} 
{memoryRating > 0}
{memoryRating < 5}
{memorySize > 2} 
{processorRating >= 3}
(ID ?ID) (description ?description))
=>
(add (new Item ?ID )))