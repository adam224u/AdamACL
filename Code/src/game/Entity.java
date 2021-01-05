package game;


import model.Tile;

public class Entity {
	
	private int x;
	private int y;
	private int vie;
	private Tile[][] laby;
	private int fini;
	private int direction;
	
	
	public Entity(int x, int y, int vie, Tile[][] laby,int fini,int direction) {
		this.x=x;
		this.y=y;
		this.vie=vie;
		this.laby=laby;
		this.fini = fini;
		this.direction = direction;
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
		//System.out.print(genre);
		//if (!(laby[y/40][x/40].getent() == null)) {
			//System.out.println(laby[y/40][x/40].getent().getx());
			//System.out.println(laby[y/40][x/40].getent().gety());
		//}
		switch (commande) {
		case IDLE :
			break;
		case SHOOT :
			break;
		case LEFT :
			int x_nl=this.x - 40;
			int yl = this.y/40;
			int xl = x_nl/40;
			move(x,y,xl,yl,genre);
			this.direction = 2;
			break;
		case RIGHT :
			int x_nr=this.x + 40;
			int yr = this.y/40;
			int xr = x_nr/40;
			move(x,y,xr,yr,genre);
			this.direction = 0;
			break;
		case UP :
			int y_nu=this.y - 40;
			int yu = y_nu/40;
			int xu = this.x/40;
			move(x,y,xu,yu,genre);
			this.direction = 3;
			break;
		case DOWN :
			int y_nd=this.y + 40;
			int yd = y_nd/40;
			int xd = this.x/40;
			move(x,y,xd,yd,genre);
			this.direction = 1;
			break;	
		}
		
		
	}
	
	public void move(int x,int y, int xnew, int ynew, String genre ) {
		if (laby[ynew][xnew].equalsType("0")) {
			this.x = xnew*40;
			this.y = ynew*40;
			laby[y/40][x/40].echange(laby[ynew][xnew]);
			
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
			this.x = xnew*40;
			this.y = ynew*40;
			laby[y/40][x/40].transfert(laby[ynew][xnew]);
			retirervie(2);
			
		}
		else if ((laby[ynew][xnew].equalsType("T")) & (genre.equals("H"))) { 
			int n= laby.length;
			int xt=-1;
			int yt=-1;
			int yc=1;
			int xc=1;
			while ((xt==-1) && (yt==-1)) {
				if ((yc!=ynew) || (xc!=xnew)) {
						if (laby[yc][xc].equalsType("T")) {
							xt=xc;
							yt=yc;
						}
				}
				xc++;
				if (xc>(n-2)) {
					yc++;
					xc=1;
				}
				
						
					
				
			}
			this.x = xt*40;
			this.y = yt*40;
			laby[y/40][x/40].transfert(laby[yt][xt]);
			laby[y/40][x/40].transfert(laby[ynew][xnew]);
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
	public int getdir() {
		return this.direction ;
	}
	public Tile[][] getlaby() {
		return laby;
	}

}
