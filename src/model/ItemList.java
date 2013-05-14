package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ItemList {

	/**
	 * @param args
	 */
	private List items;
	private float total;

	public ItemList(Collection theItems) {
		items = new ArrayList(theItems);
		for (Iterator it = items.iterator(); it.hasNext();) {
			CatalogItem item = (CatalogItem) it.next();
		}
	}

	public Iterator getItems() {
		return items.iterator();
	}

	public float getTotal() {
		return total;
	}

}
