package game;

public class Heros extends Entity{
	
	public Heros(int x, int y,int vie) {
		super(x, y, vie);
	}

	public int x;
	public int y;
	public int vie;
	
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
