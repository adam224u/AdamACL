package model;



import game.Entity;

public class Tile {
	
	private String type; 
	private Entity ent;
	
	public Tile() {
		this.type = "0";
		this.ent = null;
	}
	
	public void changeType(String type) {
		this.type=type;
	}
	public void addent(Entity ent) {
		this.ent = ent;
	}
	
	public String getType() {
		return this.type;
	}
	
	public boolean equalsType(String mot) {
		return this.type.equals(mot);
	}
	 public void supprent() {
		this.type = "0";
		this.ent = null;
	 }
	
	
	public Entity getent(){
		return(ent);
	}
	public void echange(Tile t) {
		String type_aux = this.type;
		Entity ent_aux = this.ent;
		this.type = t.type;
		this.ent = t.ent;
		t.type = type_aux;
		t.ent = ent_aux;
	}
	public void transfert(Tile t) {
		t.type = this.type;
		t.ent = this.ent;
		this.type = "0";
		this.ent = null;
	}
	public void retirervie(int degats) {
		this.ent.retirervie(degats);
	}
	

}
