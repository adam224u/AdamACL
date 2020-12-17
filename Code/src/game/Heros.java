package game;

import model.Tile;

public class Heros extends Entity{
	
	public Heros(int x, int y,int vie,Tile[][] laby, int fini) {
		super(x, y, vie,laby,fini);
	}

	private int x;
	private int y;
	private int vie;
	private Tile[][] laby;
	private int fini;
	
	
	public int getx() {
		return super.getx();
	}

	
	public int gety() {
		return super.gety();
	}

	public void Movement(Cmd commande) {
		super.Movement(commande);
	}
	public int getvie() {
		return(super.getvie());
	}
	
	public void retirervie(int degat) {
		super.retirervie(degat);
		System.out.print("vie : ");
		System.out.println(this.getvie());
	
	}

}
