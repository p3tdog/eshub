package model;

public class Questions {
	boolean student = false;
	boolean gamer = false;
	boolean lecturer = false;
	boolean graphics_designer = false;
	boolean business = false;
	boolean dvdRead = false;
	boolean dvdWrite = false;
	boolean allFalse = true;
	boolean mobility = false;
	int maxprice = 100000000;
	int minprice = 0;
	public Questions(){

	}
	public Questions(boolean gamer)
	{
		this.gamer = gamer;
	}
	public boolean isStudent() {
		return student;
	}
	public void setStudent(boolean student) {
		this.student = student;
	}
	public boolean isGamer() {
		return gamer;
	}
	public void setGamer(boolean gamer) {
		this.gamer = gamer;
	}
	public boolean isLecturer() {
		return lecturer;
	}
	public void setLecturer(boolean lecturer) {
		this.lecturer = lecturer;
	}
	public boolean isGraphics_designer() {
		return graphics_designer;
	}
	public void setGraphics_designer(boolean graphics_designer) {
		this.graphics_designer = graphics_designer;
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
	public boolean isAllFalse()
	{
		return allFalse;
	}
	public void setAllFalse(boolean allFalse)
	{
		this.allFalse = allFalse;
	}
	public boolean isBusiness() {
		return business;
	}
	public void setBusiness(boolean business) {
		this.business = business;
	}
	public int getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}
	public int getMinprice() {
		return minprice;
	}
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	public boolean isMobility() {
		return mobility;
	}
	public void setMobility(boolean mobility) {
		this.mobility = mobility;
	}
	
}
