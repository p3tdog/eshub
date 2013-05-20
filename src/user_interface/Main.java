package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.*;

import jess.Fact;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;
import model.CatalogItem;
import model.Item;
import model.Questions;
import database.Database;

public class Main extends JFrame{


	// Variables declaration - do not modify//GEN-BEGIN:variables

	private static WorkingMemoryMarker marker;
	static Questions questions = new Questions();
	static Rete engine;
	static Database db;
	static ArrayList<String> items;
	private JCheckBox gamerCheckBox;
	private JCheckBox studentCheckBox;
	private JCheckBox lecturerCheckBox;
	private JCheckBox graphicsCheckBox;
	private JCheckBox businessCheckBox;
	private JCheckBox dvdReadCheckBox;
	private JCheckBox dvdWriteCheckBox;
	private JComboBox priceHigh;
	private JComboBox priceLow;
	private JList dataList;

	private JLabel empty;
	private JLabel emptytwo;
	private JLabel emptythree;
	private JLabel emptyfour;
	private JLabel emptyfive;
	private JLabel emptysix;
	private JLabel emptyseven;

	private JScrollPane scrollpane;
	private static JTextArea logtextarea;


	JLabel maxLabel = new JLabel("Price Max");
	JLabel minLabel = new JLabel("Price Min");
	JCheckBox mobileCheckBox;
	JPanel main = new JPanel();
	JPanel quesWho = new JPanel();
	JPanel quesPara = new JPanel();
	JPanel answers = new JPanel();
	JPanel progresspanel;
	int maxrules = 1;
	// End of variables declaration//GEN-END:variables
	/**
	 * 
	 */
	private static final long serialVersionUID = -1518859226523483868L;

	/**
	 * @param args
	 * @throws JessException 
	 * @throws FileNotFoundException 
	 */
	public Main() throws FileNotFoundException, JessException
	{
		createEngine();
		getList();
		initComponents();
	}

	public static void addDatatoLog(String data)
	{
		logtextarea.append(data);
	}
	public static void clearDataLog()
	{
		logtextarea.setText("");
		logtextarea.append("========================================= Matching results ==========================================\n" +
				"              ID                     |    Descriptions    |  Processor Speed  |  Memory Size  |  Hardrive  |  Price (R)  |  Match Rating  |\n");
	}

	private void initComponents() {
		gamerCheckBox = new JCheckBox();
		studentCheckBox = new JCheckBox();
		lecturerCheckBox = new JCheckBox();
		graphicsCheckBox = new JCheckBox();
		businessCheckBox = new JCheckBox();
		mobileCheckBox = new JCheckBox();
		dvdReadCheckBox = new JCheckBox();
		dvdWriteCheckBox = new JCheckBox();
		String[] prices = new String[10];
		for(int i = 0;i<10;i++)
			prices[i] = i*1000+"";
		priceHigh = new JComboBox(prices);
		priceHigh.setSelectedIndex(9);
		priceLow = new JComboBox(prices);
		gamerCheckBox.setLabel("Gamer");
		studentCheckBox.setLabel("Student");
		lecturerCheckBox.setLabel("Lecturer");
		graphicsCheckBox.setLabel("Graphics");
		businessCheckBox.setLabel("Business Man");
		mobileCheckBox.setLabel("Mobile");
		dvdReadCheckBox.setLabel("Read DVDs");
		dvdWriteCheckBox.setLabel("Write DVDs");
		gamerCheckBox.addActionListener(new onClickListener());
		studentCheckBox.addActionListener(new onClickListener());
		lecturerCheckBox.addActionListener(new onClickListener());
		graphicsCheckBox.addActionListener(new onClickListener());
		businessCheckBox.addActionListener(new onClickListener());
		mobileCheckBox.addActionListener(new onClickListener());
		dvdReadCheckBox.addActionListener(new onClickListener());
		dvdWriteCheckBox.addActionListener(new onClickListener());
		priceHigh.addActionListener(new onClickListener());
		priceLow.addActionListener(new onClickListener());
		dvdReadCheckBox.addActionListener(new onClickListener());
		dvdWriteCheckBox.addActionListener(new onClickListener());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Computer Choice Expert System");


		empty = new JLabel(" ");
		emptytwo = new JLabel(" ");
		emptythree = new JLabel(" ");
		emptyfour = new JLabel("ADD ONS : ");
		emptyfive = new JLabel(" ");
		emptysix = new JLabel("USER CATEGORY");
		emptyseven = new JLabel(" ");

		main.setLayout(new BorderLayout());
		JTextArea txt = new JTextArea();

		//set the log text area data
		logtextarea = new JTextArea();
		logtextarea.setEnabled(true);
		logtextarea.append("========================================= Matching results ==========================================\n" +
				"              ID                     |    Descriptions    |  Processor Speed  |  Memory Size  |  Hardrive  |  Price (R)  |  Match Rating  |\n");


		scrollpane = new JScrollPane(logtextarea);
		scrollpane.setPreferredSize(new Dimension(450, 250));

		progresspanel =  new JPanel(new BorderLayout());
		progresspanel.add(scrollpane, BorderLayout.SOUTH);


		quesPara.setLayout(new GridLayout(2,4));
		quesWho.add(gamerCheckBox);
		quesWho.add(studentCheckBox);
		quesWho.add(lecturerCheckBox);
		quesWho.add(graphicsCheckBox);
		quesWho.add(businessCheckBox);

		quesPara.add(emptyfour, BorderLayout.NORTH);
		quesPara.add(mobileCheckBox, BorderLayout.NORTH);
		quesPara.add(dvdReadCheckBox, BorderLayout.NORTH);
		quesPara.add(dvdWriteCheckBox, BorderLayout.NORTH);

		quesWho.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 4;
		gc.gridy = 0;
		quesWho.add(emptysix, gc);
		gc.gridx = 4;
		gc.gridy = 1;
		quesWho.add(emptyfive, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		quesWho.add(gamerCheckBox, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		quesWho.add(empty, gc);
		gc.gridx = 2;
		gc.gridy = 2;
		quesWho.add(studentCheckBox, gc);		
		gc.gridx = 3;
		gc.gridy = 2;
		quesWho.add(emptytwo, gc);
		gc.gridx = 4;
		gc.gridy = 2;
		quesWho.add(lecturerCheckBox, gc);
		gc.gridx = 5;
		gc.gridy = 2;
		quesWho.add(graphicsCheckBox, gc);		
		gc.gridx = 6;
		gc.gridy = 2;
		quesWho.add(businessCheckBox, gc);

		quesPara.add(emptyseven, BorderLayout.WEST);
		quesPara.add(maxLabel, BorderLayout.WEST);
		quesPara.add(priceHigh, BorderLayout.CENTER);
		quesPara.add(minLabel, BorderLayout.CENTER);
		quesPara.add(priceLow, BorderLayout.EAST);


		main.add(quesWho, BorderLayout.NORTH);
		//main.add(answers, BorderLayout.SOUTH);
		main.add(quesPara, BorderLayout.CENTER);
		main.add(progresspanel, BorderLayout.SOUTH);
		this.setContentPane(main);
		this.setSize(1024, 720);
	}
	/**
	 * @param args the command line arguments
	 * @throws FileNotFoundException 
	 * @throws JessException 
	 */
	public static void main(String args[]) throws FileNotFoundException, JessException {
		// TODO Auto-generated method stub
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main().setVisible(true);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	public void collectQuestions(){
		maxrules = 2;
		questions.setGamer(gamerCheckBox.isSelected());
		questions.setGraphics_designer(graphicsCheckBox.isSelected());
		questions.setLecturer(lecturerCheckBox.isSelected());
		questions.setStudent(studentCheckBox.isSelected());
		questions.setBusiness(businessCheckBox.isSelected());
		questions.setDvdRead(dvdReadCheckBox.isSelected());
		questions.setDvdWrite(dvdWriteCheckBox.isSelected());
		questions.setMaxprice(Integer.parseInt(priceHigh.getSelectedItem()+""));
		questions.setMinprice(Integer.parseInt(priceLow.getSelectedItem()+""));
		questions.setMobility(mobileCheckBox.isSelected());
		if(gamerCheckBox.isSelected())
			maxrules++;
		if(graphicsCheckBox.isSelected())
			maxrules++;
		if(lecturerCheckBox.isSelected())
			maxrules++;
		if(studentCheckBox.isSelected())
			maxrules++;
		if(businessCheckBox.isSelected())
			maxrules++;
		if(dvdReadCheckBox.isSelected())
			maxrules++;
		if(dvdWriteCheckBox.isSelected())
			maxrules++;
		if(mobileCheckBox.isSelected())
			maxrules++;

		if(gamerCheckBox.isSelected()==false&&graphicsCheckBox.isSelected()==false&&lecturerCheckBox.isSelected()==false&&studentCheckBox.isSelected()==false&&mobileCheckBox.isSelected()==false&&businessCheckBox.isSelected()==false&&dvdWriteCheckBox.isSelected()==false&&dvdReadCheckBox.isSelected()==false)
			questions.setAllFalse(true);
		else
			questions.setAllFalse(false);
	}
	public void getList() throws JessException{
		engine.add(questions);
		engine.run();
		Iterator output = engine.getObjects(new Filter.ByClass(Item.class));
		items = new ArrayList<String>();
		while(output.hasNext())
		{
			try{
				Item item = ((Item)output.next());
				items.add(item.getID());
			}
			catch (Exception e)
			{

			}
		}
		engine.resetToMark(marker);
	}
	public void createEngine() throws FileNotFoundException, JessException{
		// TODO Auto-generated method stub
		engine = new Rete();
		db = new Database();
		engine.reset();

		// Load the pricing rules
		String name ="andrew";
		//engine.assertString(name);
		engine.batch("rules.clp");
		engine.addAll(db.getCatalogItems());
		// Mark end of catalog data for later
		Iterator facts = engine.listFacts();
		ArrayList<Fact> fac = new ArrayList<Fact>();
		marker = engine.mark();
	}
	public void updateList() throws FileNotFoundException
	{
		if(maxrules==0)
		{
			maxrules=1;
		}
		Database database = new Database();
		ArrayList x = (ArrayList) database.getCatalogItems();
		Collection ar = database.getCatalogItems();
		ArrayList<String> data = new ArrayList<String>();
		clearDataLog();
		while(x.isEmpty()==false)
		{
			int count = 0;
			CatalogItem hold = (CatalogItem)x.remove(0);
			for(int i = 0;i<items.size();i++)
			{
				if(items.get(i).equals(hold.getID()))
				{
					count++;
				}
			}
			if(items.contains(hold.getID()))
			{ 
				items.remove(hold.getID());
				double solution = ((double)count/maxrules)*100;
				//data.add(hold.toString() +(int)solution + "%");
				if(solution>100)
					solution=100;
				addDatatoLog(hold.toString() + (int)solution + "%\n");
			}
		}
		data = null;
		x = null;
	}
	class onClickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			collectQuestions();
			try {
				getList();
				updateList();
			} catch (JessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Error");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

