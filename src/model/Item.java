package model;

public class Item {

	private String ID;
	private String type;
	public Item (String ID)
	{
		this.ID = ID;
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
