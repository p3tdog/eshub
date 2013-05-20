(import model.*)
(deftemplate CatalogItem (declare (from-class CatalogItem)))
(deftemplate ItemList (declare (from-class ItemList)))
(deftemplate Questions (declare (from-class Questions)))
(deftemplate Item (declare (from-class Item)))

;Items deemed for students
;warrenty time greater than 2 years
;memory rating greater or equal to 3
;memory size greater or equal to 2 
(defrule student-items
(Questions {student == TRUE} (maxprice ?max) (minprice ?min) (mobility ?mob_que)) 
(CatalogItem {warrentyTime > 2} 
{memoryRating >= 3} 
{memorySize >= 2} 
{processorRating >= 3}
{price < ?max}
{price > ?min}
(ID ?ID) (mobility ?mob_cat) (dvdRead ?dvdRead) (dvdWrite ?dvdWrite) )
=>
(if(= ?mob_que ?mob_cat) then
(add (new Item ?ID )) else
(if(= ?mob_que FALSE) then
(add (new Item ?ID))))
)

(defrule all-items
(Questions {allFalse == TRUE} (maxprice ?max) (minprice ?min) (mobility ?mob_que))
(CatalogItem (ID ?ID) (mobility ?mob_cat)
{price < ?max}
{price > ?min}
)
=>
(if(= ?mob_que ?mob_cat) then
(add (new Item ?ID )) else
(if(= ?mob_que FALSE) then
(add (new Item ?ID))))
)

(defrule gamer-items
(Questions {gamer == TRUE}  (maxprice ?max) (minprice ?min) (mobility ?mob_que)) 
(CatalogItem {warrentyTime > 2} 
{memoryRating > 0}
{memoryRating < 5}
{memorySize > 2} 
{processorRating >= 3}
{price < ?max}
{price > ?min}
(ID ?ID) (description ?description) (mobility ?mob_cat) )
=>
(if(= ?mob_que ?mob_cat) then
(add (new Item ?ID )) else
(if(= ?mob_que FALSE) then
(add (new Item ?ID))))
)

(defrule lecturer-items
(Questions {lecturer == TRUE} (maxprice ?max) (minprice ?min) (mobility ?mob_que)) 
(CatalogItem {warrentyTime > 2} 
{memoryRating > 0}
{memoryRating < 5}
{memorySize > 2} 
{processorRating >= 3}
{price < ?max}
{price > ?min}
(ID ?ID) (description ?description) (mobility ?mob_cat))
=>

(if(= ?mob_que ?mob_cat) then
(add (new Item ?ID )) else
(if(= ?mob_que FALSE) then
(add (new Item ?ID))))
)

(defrule graphics-items
(Questions {graphics_designer == TRUE} (mobility ?mob_que)) 
(CatalogItem {warrentyTime > 2} 
{memoryRating > 0}
{memoryRating < 5}
{memorySize > 2} 
{processorRating >= 3}
(ID ?ID) (description ?description) (mobility ?mob_cat))
=>

(if(= ?mob_que ?mob_cat) then
(add (new Item ?ID )) else
(if(= ?mob_que FALSE) then
(add (new Item ?ID))))
)

(defrule business-items
(Questions {business == TRUE} (mobility ?mob_que)) 
(CatalogItem {warrentyTime > 2} 
{memoryRating > 0}
{memoryRating < 5}
{memorySize > 2} 
{processorRating >= 3}
(ID ?ID) (description ?description) (mobility ?mob_cat) )
=>
(if(= ?mob_que ?mob_cat) then
(add (new Item ?ID )) else
(if(= ?mob_que FALSE) then
(add (new Item ?ID))))
)
