package model;

public class Questions {
	boolean student = false;
	boolean gamer = true;
	boolean lecturer = false;
	boolean graphics_designer = false;
	boolean dvdRead = false;
	boolean dvdWrite = false;
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

}
