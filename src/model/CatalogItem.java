package model;

public class CatalogItem {
	private String ID;
	private String description;
	float processorSpeed;
	int processorRating;
	int hardDrive;
	int memorySize;
	int memoryRating;
	boolean mobility;
	String graphicsCard;
	int graphicsRating;
	int dvdRead;
	int dvdWrite;
	int price;
	int warrentyType;
	int warrentyTime;
	int lan;

	public CatalogItem(String ID,String aDescription, float processorSpeed,int processorRating, int hardDrive, int memorySize, int memoryRating, boolean mobility, String graphicsCard, int graphicsRating,int dvdRead,int dvdWrite,int price, int warrentyType, int warrentyTime,int lan) {
		this.ID = ID;
		this.description = aDescription;
		this.processorSpeed = processorSpeed;
		this.processorRating=processorRating;
		this.hardDrive=hardDrive;
		this.memorySize=memorySize;
		this.memoryRating=memoryRating;
		this.mobility=mobility;
		this.graphicsCard=graphicsCard;
		this.graphicsRating=graphicsRating;
		this.dvdRead=dvdRead;
		this.dvdWrite=dvdWrite;
		this.price=price;
		this.warrentyType=warrentyType;
		this.warrentyTime=warrentyTime;
		this.lan=lan;
	}

	public String getID() {
		return ID;
	}

	public String getDescription() {
		return description;
	}

	public float getProcessorSpeed() {
		return processorSpeed;
	}

	public int getProcessorRating() {
		return processorRating;
	}

	public int getHardDrive() {
		return hardDrive;
	}

	public int getMemorySize() {
		return memorySize;
	}

	public int getMemoryRating() {
		return memoryRating;
	}

	public boolean getMobility() {
		return mobility;
	}

	public String getGraphicsCard() {
		return graphicsCard;
	}

	public int getGraphicsRating() {
		return graphicsRating;
	}

	public int getDvdRead() {
		return dvdRead;
	}

	public int getDvdWrite() {
		return dvdWrite;
	}

	public float getPrice() {
		return price;
	}

	public int getWarrentyType() {
		return warrentyType;
	}

	public int getWarrentyTime() {
		return warrentyTime;
	}

	public int getLan() {
		return lan;
	}
	public String toString()
	{
		return "" + ID + "        " + description + "                  " + processorSpeed + "                             " + memorySize + "                    " + hardDrive + "           " + price + "             ";
	}
}
