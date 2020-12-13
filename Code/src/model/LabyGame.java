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
	
	public static Heros heros;
	List<Entity> entite;
	public static String [][] laby;
	public static int fini = 0;

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public LabyGame(String source) {
		this.entite = new ArrayList<Entity>();
		LabyGame.laby= new String[21][21];
		BufferedReader helpReader = null;
		try {
			helpReader = new BufferedReader(new FileReader("Labyrinthe1.txt"));
			for (int y=0; y<=20;y++) {
				String ligne = helpReader.readLine();
				String[] mots = ligne.split ("") ;
				for (int x=0; x<=20;x++) {
					String mot =mots[x];
					laby[y][x]=mot;
					if (mot.equals("H")) {
						LabyGame.heros = new Heros(x*40,y*40,4);
						System.out.print("vie : ");
						System.out.println(LabyGame.heros.getvie());
					}
					else if (mot.equals("M")) {
						 this.entite.add(new Entity(x*40,y*40,0))  ;
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
		
		
		
		
	

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		return ((LabyGame.fini>=1) || (LabyGame.heros.getvie()==0));
	}

}




