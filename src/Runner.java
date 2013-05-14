
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Item;
import model.Questions;

import database.Database;

import jess.Deffacts;
import jess.Defglobal;
import jess.Fact;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.Value;
import jess.WorkingMemoryMarker;


public class Runner {

	private static WorkingMemoryMarker marker;
	/**
	 * @param args
	 * @throws JessException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws JessException, FileNotFoundException {
		// TODO Auto-generated method stub
		Rete engine = new Rete();
		Database db = new Database();
		engine.reset();

		// Load the pricing rules
		String name ="andrew";
		//engine.assertString(name);
		engine.batch("rules.clp");
		engine.addAll(db.getCatalogItems());
		// Mark end of catalog data for later
		Iterator facts = engine.listFacts();
		ArrayList<Fact> fac = new ArrayList<Fact>();
		engine.assertFact(new Fact("andrew",engine));
		engine.assertFact(new Fact("food-available",engine));
		engine.assertFact(new Fact("pettey",engine));
		marker = engine.mark();
		for(int k = 0;k<=1;k++)
		{
			if(k==0)
				engine.add(new Questions(false));
			else
				engine.add(new Questions(true));
			engine.run();
			while(facts.hasNext())
			{
				fac.add((Fact) facts.next());
			}
			Iterator output = engine.getObjects(new Filter.ByClass(Item.class));
			System.out.println("fac size:"+fac.size());
			while(output.hasNext())
			{
				try{
					System.out.println(((Item)output.next()).getID());
				}
				catch (Exception e)
				{

				}
			}
			engine.resetToMark(marker);
		}
	}

}
