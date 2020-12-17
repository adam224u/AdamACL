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
		heros.Movement(commande);
		//il faut ensuite faire évoluer la liste des entités 
		if (commande !=Cmd.IDLE) { 
		if (this.entite != null) {
		for(Entity monstre: this.entite) {
			int r = (int) (Math.random()*8);
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
						this.heros = new Heros(x*40,y*40,4,laby,fini);
						System.out.print("vie : ");
						System.out.println(this.heros.getvie());
					}
					else if (mot.equals("M")) {
						this.entite.add(new Entity(x*40,y*40,0,laby,fini))  ;
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




