package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import game.GamePainter;



/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class LabyPainter implements GamePainter {

	
	protected static final int WIDTH = 840;
	protected static final int HEIGHT = 840;
	private LabyGame game;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public LabyPainter(LabyGame game) {
		this.game = game ;
	}


	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(game.getHeros().getx(),game.getHeros().gety(),40,40);
		crayon.setColor(Color.black);
		for (int x=2;x<=19;x++) {
			crayon.drawLine(x*40, 0, x*40, 840);
			crayon.drawLine(0, x*40, 840, x*40);
		}
		for (int y=0; y<=20;y++) {
			for (int x=0; x<=20;x++) {
				if (game.getlaby()[y][x].equalsType("1")) {
					crayon.setColor(Color.black);
					crayon.fillRect(x*40,y*40,40 , 40);
				}
				else if (game.getlaby()[y][x].equalsType("2")) {
					crayon.setColor(Color.yellow);
					crayon.fillRect(x*40,y*40,40 , 40);
				}
				else if (game.getlaby()[y][x].equalsType("M")) {
					crayon.setColor(Color.green);
					crayon.fillOval(x*40,y*40,40 , 40);
				}
				else if (game.getlaby()[y][x].equalsType("P")) {
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