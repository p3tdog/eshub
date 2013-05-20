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
(ID ?ID) (mobility ?mob_cat))
=>
(add (new Item ?ID))
)

(defrule all-items
(Questions {allFalse == TRUE}) 
(CatalogItem
(ID ?ID) )
=>
(add (new Item ?ID))
)

(defrule gamer-items
(Questions {gamer == TRUE} ) 
(CatalogItem {warrentyTime > 3} 
{memoryRating >= 4} 
{memorySize >= 16} 
{processorRating >= 4}
(ID ?ID) )
=>
(add (new Item ?ID))
)

(defrule lecturer-items
(Questions {lecturer == TRUE} ) 
(CatalogItem {warrentyTime > 2} 
{memoryRating >= 2} 
{memorySize <= 2} 
{processorRating >= 2}
(ID ?ID) )
=>
(add (new Item ?ID))
)

(defrule graphics-items
(Questions {graphics_designer == TRUE} (maxprice ?max) (minprice ?min) (mobility ?mob_que)) 
(CatalogItem {warrentyTime > 3} 
{memoryRating >= 4} 
{memorySize >= 16} 
{processorRating >= 4}
{price < ?max}
{price > ?min}
(ID ?ID) (mobility ?mob_cat) (dvdRead ?dvdRead) (dvdWrite ?dvdWrite) )
=>
(add (new Item ?ID))
)

(defrule business-items
(Questions {business == TRUE} (maxprice ?max) (minprice ?min) (mobility ?mob_que)) 
(CatalogItem {warrentyTime > 1} 
{memoryRating >= 1} 
{memorySize >= 1} 
{processorRating >= 1}
{price < ?max}
{price > ?min}
(ID ?ID) (mobility ?mob_cat) (dvdRead ?dvdRead) (dvdWrite ?dvdWrite) )
=>
(add (new Item ?ID))
)
(defrule pricechecker  
(Questions (maxprice ?max) (minprice ?min))
(CatalogItem (price ?price) (ID ?ID) )
=>
	(if(> ?max ?price) then
		(if(< ?min ?price) then
			(add (new Item ?ID))
		)
	)
)

(defrule dvdReadChecker  
(Questions (dvdRead ?dvdRead) )
(CatalogItem (dvdRead ?dRead) (ID ?ID) )
=>
	(if(= ?dRead 1) then
		(if(= ?dvdRead TRUE) then
				(add (new Item ?ID))
		)
	else
	(add (new Item ?ID))
	)
)
(defrule dvdWriteChecker  
(Questions  (dvdWrite ?dvdWrite))
(CatalogItem (dvdWrite ?dWrite) (ID ?ID) )
=>
	(if(= ?dWrite 1) then
		(if(= ?dvdWrite TRUE) then
				(add (new Item ?ID))
		)
	else
	(add (new Item ?ID))
	)
)
(defrule mobilityChecker  
(Questions  (mobility ?mob_que))
(CatalogItem (mobility ?mob_cat) (ID ?ID) )
=>
	(if(= ?mob_que TRUE) then
		(if(= ?mob_cat TRUE) then
				(add (new Item ?ID))
		)
	else
	(add (new Item ?ID))
	)
)

;Written but did not work correctly
;(deffunction check_rules (?ID ?mob_que ?mob_cat ?max ?min ?price ?dvdRead ?dvdWrite ?dRead ?dWrite )
;
;	(if(= ?mob_que ?mob_cat) then
;		(if(> ?price ?max) then
;			(if(< ?price ?min) then
;				(if(= ?dRead TRUE) then
;					(if(= ?dvdRead TRUE ) then
;						(add (new Item ?ID))
;					)
;						else
;						(if(= ?dWrite TRUE) then
;							(if(= ?dvdWrite TRUE) then
;								(add (new Item ?ID))
;							)
;						)
;				)
;			)
;		)
;	)
;)