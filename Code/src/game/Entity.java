package game;

import model.LabyGame;

public class Entity {
	
	public int x;
	public int y;
	public int vie;
	
	public Entity(int x, int y, int vie) {
		this.x=x;
		this.y=y;
		this.vie=vie;
	}
	
	public int getx() {
		return(this.x);
	}
	
	public int gety() {
		return(this.y);
	}
	
	public void Movement(Cmd commande ) {
		int y = this.y;
		int x = this.x;
		String genre = LabyGame.laby[y/40][x/40];
		switch (commande) {
		case IDLE :
			break;
		case LEFT :
			int x_nl=this.x - 40;
			int yl = this.y/40;
			int xl = x_nl/40;
			if (LabyGame.laby[yl][xl].equals("0")) {
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.x = x_nl;
				LabyGame.laby[yl][xl]=genre;
			}
			else if (LabyGame.laby[yl][xl].equals("2") & (genre.equals("H"))) {
				LabyGame.fini=1;
			}
			else if ((LabyGame.laby[yl][xl].equals("M")) & (genre.equals("H"))) {
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yl][xl].equals("H")) & (genre.equals("M"))) {   
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yl][xl].equals("P")) & (genre.equals("H"))) {   
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.x = x_nl;
				LabyGame.laby[yl][xl]=genre;
				retirervie(2);
				
			}
			break;
		case RIGHT :
			int x_nr=this.x + 40;
			int yr = this.y/40;
			int xr = x_nr/40;
			if (LabyGame.laby[yr][xr].equals("0")) {
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.x = x_nr;
				LabyGame.laby[yr][xr]=genre;
			}
			else if (LabyGame.laby[yr][xr].equals("2") & (genre.equals("H"))) {
				LabyGame.fini=1;
			}
			else if ((LabyGame.laby[yr][xr].equals("M")) & (genre.equals("H"))) {
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yr][xr].equals("H")) & (genre.equals("M"))) {
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yr][xr].equals("P")) & (genre.equals("H"))) {   
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.x = x_nr;
				LabyGame.laby[yr][xr]=genre;
				retirervie(2);
			}
			break;
		case UP :
			int y_nu=this.y - 40;
			int yu = y_nu/40;
			int xu = this.x/40;
			if (LabyGame.laby[yu][xu].equals("0")) {
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.y = y_nu;
				LabyGame.laby[yu][xu]=genre;
		}
			else if (LabyGame.laby[yu][xu].equals("2") & (genre.equals("H"))) {
				LabyGame.fini=1;
			}
			else if ((LabyGame.laby[yu][xu].equals("M")) & (genre.equals("H"))) {
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yu][xu].equals("H")) & (genre.equals("M"))) {
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yu][xu].equals("P")) & (genre.equals("H"))) {   
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.y = y_nu;
				LabyGame.laby[yu][xu]=genre;
				retirervie(2);
			}
			break;
		case DOWN :
			int y_nd=this.y + 40;
			int yd = y_nd/40;
			int xd = this.x/40;
			if (LabyGame.laby[yd][xd].equals("0")) {
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.y = y_nd;
				LabyGame.laby[yd][xd]=genre;
		}
			else if (LabyGame.laby[yd][xd].equals("2") & (genre.equals("H"))) {
				LabyGame.fini=1;
			}
			else if ((LabyGame.laby[yd][xd].equals("M")) & (genre.equals("H"))) {
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yd][xd].equals("H")) & (genre.equals("M"))) {
				LabyGame.fini=2;
			}
			else if ((LabyGame.laby[yd][xd].equals("P")) & (genre.equals("H"))) {   
				LabyGame.laby[this.y/40][this.x/40]="0";
				this.y = y_nd;
				LabyGame.laby[yd][xd]=genre;
				retirervie(2);
			}
			break;
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
