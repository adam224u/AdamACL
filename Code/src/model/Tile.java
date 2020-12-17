package model;

public class Tile {
	
	private String type; 
	
	public Tile() {
		this.type = "0";
	}
	
	public void changeType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public boolean equalsType(String mot) {
		return this.type.equals(mot);
	}
	
	

}
