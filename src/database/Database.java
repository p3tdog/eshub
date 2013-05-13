package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import model.CatalogItem;

public class Database {

	/**
	 * @param args
	 */
	private ArrayList items;
	private Map orders;

	public Database() throws FileNotFoundException {
		createCatalogItems();
	}

	private void createCatalogItems() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("data.csv")).useDelimiter(";");
		sc.nextLine();
		items = new ArrayList();
		while(sc.hasNextLine()){
			items.add(new CatalogItem(sc.next(), sc.next(),sc.nextFloat(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextFloat(),sc.nextInt(),sc.nextInt(),Integer.parseInt(sc.next().charAt(0)+"")));
			sc.nextLine();
		}
		System.out.println(items.size());
		for(int i = 0;i<items.size();i++)
			System.out.println(((CatalogItem)items.get(i)).getID());
	}

	public Collection getCatalogItems() {
		return items;
	}

}
