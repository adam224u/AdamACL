package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import game.GamePainter;

import game.Heros;
import game.Entity; 
import model.LabyGame;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class LabyPainter implements GamePainter {

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 840;
	protected static final int HEIGHT = 840;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public LabyPainter() {
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(LabyGame.heros.getx(),LabyGame.heros.gety(),40,40);
		crayon.setColor(Color.black);
		for (int x=2;x<=19;x++) {
			crayon.drawLine(x*40, 0, x*40, 840);
			crayon.drawLine(0, x*40, 840, x*40);
		}
		for (int y=0; y<=20;y++) {
			for (int x=0; x<=20;x++) {
				if (LabyGame.laby[y][x].equals("1")) {
					crayon.setColor(Color.black);
					crayon.fillRect(x*40,y*40,40 , 40);
				}
				else if (LabyGame.laby[y][x].equals("2")) {
					crayon.setColor(Color.yellow);
					crayon.fillRect(x*40,y*40,40 , 40);
				}
				else if (LabyGame.laby[y][x].equals("M")) {
					crayon.setColor(Color.green);
					crayon.fillOval(x*40,y*40,40 , 40);
				}
				else if (LabyGame.laby[y][x].equals("P")) {
					crayon.setColor(Color.gray);
					crayon.drawLine(x*40,y*40,(x+1)*40 , (y+1)*40);
					crayon.drawLine(x*40,(y+1)*40,(x+1)*40 , y*40);
				}
			}
		}		
	}
			
	
		
		
		
		
		
	

		
	
	
	
	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}
}