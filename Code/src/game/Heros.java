package game;

import java.awt.List;
import java.util.ArrayList;

import model.Tile;

public class Heros extends Entity{
	
	private int x;
	private int y;
	private int vie;
	private Tile[][] laby;
	private int fini;
	private int direction;   //direction : 0 = droite  , 1=bas, 2=gauche, 3=haut
	
	public Heros(int x, int y,int vie,Tile[][] laby, int fini,int direction) {
		super(x, y, vie,laby,fini,direction);
	}
	
	public int getx() {
		return super.getx();
	}

	public int gety() {
		return super.gety();
	}
	public int getdir() {
		return super.getdir() ;
	}

	public void Movement(Cmd commande) {
		super.Movement(commande);
	}
	public void move(int x,int y, int xnew, int ynew, String genre ) {
		super.move(x, y, xnew, ynew, genre);
	}
	public int getvie() {
		return(super.getvie());
	}
	
	public void retirervie(int degat) {
		super.retirervie(degat);
		System.out.print("vie : ");
		System.out.println(this.getvie());
	
	}

	public void shoot() {
		int x=this.getx()/40;
		int y=this.gety()/40;
		int dir = this.getdir();
		int plusy = 0;
		int plusx = 0;
		if (dir == 0) {
			plusx= 1;
			plusy = 0;
		}
		else if (dir == 1) {
			plusx = 0;
			plusy = 1;
		}
		else if (dir == 2) {
			plusx = -1;
			plusy = 0;
		}
		else if (dir == 3) {
			plusx = 0;
			plusy = -1;
		}
		
		while (!(this.getlaby()[y][x].equalsType("1")) & (!(this.getlaby()[y][x].equalsType("M")))) {
			y=y+plusy;
			x=x+plusx;
		}
		if 	(this.getlaby()[y][x].equalsType("M")) {
			this.getlaby()[y][x].retirervie(2);
			if (this.getlaby()[y][x].getent().getvie()==0) {
				this.getlaby()[y][x].supprent();
				
			}
		}
			
		
	}

}
