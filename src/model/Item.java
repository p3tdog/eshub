package model;

public class Item {

	private String ID;
	private String type;
	private int price;
	private boolean dvdRead;
	private boolean dvdWrite;
	private boolean mobility;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isDvdRead() {
		return dvdRead;
	}
	public void setDvdRead(boolean dvdRead) {
		this.dvdRead = dvdRead;
	}
	public boolean isDvdWrite() {
		return dvdWrite;
	}
	public void setDvdWrite(boolean dvdWrite) {
		this.dvdWrite = dvdWrite;
	}
	public boolean isMobility() {
		return mobility;
	}
	public void setMobility(boolean mobility) {
		this.mobility = mobility;
	}
	
}
