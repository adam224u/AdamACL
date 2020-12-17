package game;


import model.Tile;

public class Entity {
	
	private int x;
	private int y;
	private int vie;
	private Tile[][] laby;
	private int fini;
	
	
	public Entity(int x, int y, int vie, Tile[][] laby,int fini) {
		this.x=x;
		this.y=y;
		this.vie=vie;
		this.laby=laby;
		this.fini = fini;
	}
	
	public int getx() {
		return(this.x);
	}
	
	public int gety() {
		return(this.y);
	}
	
	public int getfini() {
		return this.fini;
	}
	
	public void Movement(Cmd commande) {
		int y = this.y;
		int x = this.x;
		String genre = laby[y/40][x/40].getType();
		switch (commande) {
		case IDLE :
			break;
		case LEFT :
			int x_nl=this.x - 40;
			int yl = this.y/40;
			int xl = x_nl/40;
			move(x,y,xl,yl,genre);
			break;
		case RIGHT :
			int x_nr=this.x + 40;
			int yr = this.y/40;
			int xr = x_nr/40;
			move(x,y,xr,yr,genre);
			break;
		case UP :
			int y_nu=this.y - 40;
			int yu = y_nu/40;
			int xu = this.x/40;
			move(x,y,xu,yu,genre);
			break;
		case DOWN :
			int y_nd=this.y + 40;
			int yd = y_nd/40;
			int xd = this.x/40;
			move(x,y,xd,yd,genre);
			break;
		}
		
	}
	
	public void move(int x,int y, int xnew, int ynew, String genre ) {
		if (laby[ynew][xnew].equalsType("0")) {
			laby[this.y/40][this.x/40].changeType("0");
			this.x = xnew*40;
			this.y = ynew*40;
			laby[ynew][xnew].changeType(genre);
		}
		else if (laby[ynew][xnew].equalsType("2") & (genre.equals("H"))) {
			fini=1;
		}
		else if ((laby[ynew][xnew].equalsType("M")) & (genre.equals("H"))) {
			fini=2;
		}
		else if ((laby[ynew][xnew].equalsType("H")) & (genre.equals("M"))) {   
			fini=2;
		}
		else if ((laby[ynew][xnew].equalsType("P")) & (genre.equals("H"))) {   
			laby[this.y/40][this.x/40].changeType("0");
			this.x = xnew*40;
			this.y = ynew*40;
			laby[ynew][xnew].changeType(genre);
			retirervie(2);
			
		}
		
	}
	
	public int getvie() {
		return(this.vie);
	}

	public void retirervie(int degat) {
		int v = this.vie -degat;
		if (v >= 0) {
			this.vie = v;
		}
		else {
			this.vie = 0;
		}
		
		
	}


}
