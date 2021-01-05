package model;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.Cmd;
import game.Entity;
import game.Game;
import game.Heros;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class LabyGame implements Game {
	
	private Heros heros;
	private List<Entity> entite;
	private Tile [][] laby;
	private int fini = 0;

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public LabyGame(String source) {
		this.entite = new ArrayList<Entity>();
		this.laby= new Tile[21][21];
		for (int i1=0; i1<=20;i1++) {
			for (int i2=0; i2<=20;i2++) {
				laby[i1][i2]= new Tile();
			}
		}
		
		constructeurLaby();
		
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		if (commande == Cmd.SHOOT) {
			heros.shoot();
		}
		else {
		heros.Movement(commande);
		//il faut ensuite faire évoluer la liste des entités 
		if (commande !=Cmd.IDLE) { 
		if (this.entite != null) {
			int k = this.entite.size();
		while (k>0) {
			Entity monstre = entite.get(k-1);
			if (monstre.getvie() == 0){
				this.entite.remove(monstre);
			}
			else {
				int xh=heros.getx()/40;
				int yh=heros.gety()/40;
				int xm=monstre.getx()/40;
				int ym=monstre.gety()/40;
				float xv = xh-xm;
				float yv = yh-ym;
				float longueur=(int) Math.sqrt(xv*xv+yv*yv);
				String tuile =laby[ym][xm].getType();
				float ynew=(float) (ym+0.5);
				float xnew=(float) (xm+0.5);
				//System.out.println(xnew);
				//System.out.println(ynew);
				while (tuile.equals("M")) {
					ynew=ynew + yv/(longueur*5);
					xnew=xnew + xv/(longueur*5);
					//System.out.println(xnew);
					//System.out.println(ynew);
					tuile = laby[(int) ynew][(int) xnew].getType();
					
				}
				while (!(tuile.equals("1")) && !(tuile.equals("H"))) {
					ynew=ynew + yv/(longueur*5);
					xnew=xnew + xv/(longueur*5);
					//System.out.println(xnew);
					//System.out.println(ynew);
					tuile = laby[(int) ynew][(int) xnew].getType();
				}
				if (tuile.equals("1")) {
					int r = (int) (Math.random()*6);
					//il faut maintenant faire un mouvement du monstre
					if (r==0) {
						monstre.Movement(Cmd.LEFT);	
					}
					else if (r==1) {
						monstre.Movement(Cmd.RIGHT);
					}
					else if (r==2) {
						monstre.Movement(Cmd.UP);
					}
					else if (r==3){
						monstre.Movement(Cmd.DOWN);
					}
					else {
						monstre.Movement(Cmd.IDLE);
					}
				}
				else if (tuile.equals("H")) {
					int bouge=0;
					if (xv!=0) {
						if ((xv<0) && !(laby[ym][xm-1].getType().equals("1"))) {
							monstre.Movement(Cmd.LEFT);
							bouge=1;
						}
						else if ((xv>0) && !(laby[ym][xm+1].getType().equals("1"))){
							monstre.Movement(Cmd.RIGHT);
							bouge=1;
							
						}
					}
					if ((yv!=0)&&(bouge==0)) {
						if ((yv<0) && !(laby[ym-1][xm].getType().equals("1"))) {
							monstre.Movement(Cmd.UP);
							
						}
						if ((yv>0) && !(laby[ym+1][xm].getType().equals("1"))) {
							monstre.Movement(Cmd.DOWN);
						}
						
					}
					else {
						monstre.Movement(Cmd.IDLE);
					}
				}
				
				
				
			}
		k=k-1;
		}
		
				
			}
		}
			}
		
		}
	
	public void constructeurLaby() {
		BufferedReader helpReader = null;
		try {
			helpReader = new BufferedReader(new FileReader("Labyrinthe1.txt"));
			for (int y=0; y<=20;y++) {
				String ligne = helpReader.readLine();
				String[] mots = ligne.split ("") ;
				for (int x=0; x<=20;x++) {
					String mot =mots[x];
					laby[y][x].changeType(mot);
					if (mot.equals("H")) {
						Heros h=new Heros(x*40,y*40,4,laby,fini,0);
						laby[y][x].addent(h);
						this.heros = h;
						System.out.print("vie : ");
						System.out.println(this.heros.getvie());
					}
					else if (mot.equals("M")) {
						Entity m=new Entity(x*40,y*40,2,laby,fini,0);
						laby[y][x].addent(m);
						this.entite.add(m);
					}
				}
			}
			helpReader.close();	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getfini() {
		return this.fini;
	}
	
	public Heros getHeros() {
		return this.heros;
	}
	
	public Tile [][] getlaby() {
		return laby;
	}
	
		
		
		
	

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		int t =0;
		for(Entity monstre: this.entite) {
			if (monstre.getfini()==2) {
				t=1;
			}
		}
		if ((t==1) || (heros.getfini()==2) || (this.heros.getvie()==0)) {
			this.fini = 2;
		}
		else if (heros.getfini()==1) {
			this.fini = 1;
		}
		return (this.fini>=1);
	}

}




