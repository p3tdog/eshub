import java.util.Iterator;

import jess.Deffacts;
import jess.Defglobal;
import jess.Fact;
import jess.JessException;
import jess.Rete;
import jess.Value;


public class Runner {

	/**
	 * @param args
	 * @throws JessException 
	 */
	public static void main(String[] args) throws JessException {
		// TODO Auto-generated method stub
		Rete engine = new Rete();
		engine.reset();

		// Load the pricing rules
		String name ="andrew";
		//engine.assertString(name);
		engine.batch("rules.clp");
		Iterator facts = engine.listFacts();

		Fact[] fac = new Fact[3];
		fac[2] = new Fact("andrew",engine);
		engine.assertFact(fac[2]);
		fac[2] = new Fact("food-available",engine);
		engine.assertFact(fac[2]);
		Value v=null;
		Deffacts da = new Deffacts("?cpu","2",engine);
		engine.addDeffacts(da);
		System.out.println();
		engine.run();
		while(facts.hasNext())
		{
			fac[0] = (Fact) facts.next();
			fac[1] = (Fact) facts.next();
			System.out.println("ID"+fac[0].getFactId());
			System.out.println("ID"+fac[1].getFactId());
		}
	}

}
