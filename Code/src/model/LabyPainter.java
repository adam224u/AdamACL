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
		int x1=game.getHeros().getx();
		int y1=game.getHeros().gety();
		crayon.fillOval(x1+3,y1+3,34,34);
		int dir = game.getHeros().getdir();
		if (dir == 0) {
			crayon.drawLine(x1+40-2*3,y1+3*2,x1+40,y1+20);
			crayon.drawLine(x1+40-2*3,y1+40-2*3,x1+40,y1+20);
		}	
		else if (dir == 1) {
			crayon.drawLine(x1+3*2,y1+40-2*3,x1+20,y1+40);
			crayon.drawLine(x1+40-2*3,y1+40-2*3,x1+20,y1+40);
		}
		else if (dir == 2) {
			crayon.drawLine(x1+3*2,y1+3*2,x1,y1+20);
			crayon.drawLine(x1+3*2,y1+40-2*3,x1,y1+20);
		}
		else if (dir == 3) {
			crayon.drawLine(x1+3*2,y1+3*2,x1+20,y1);
			crayon.drawLine(x1+40-2*3,y1+3*2,x1+20,y1);
		}
		
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
				else if (game.getlaby()[y][x].equalsType("T")) {
					crayon.setColor(Color.blue);
					crayon.fillRect(x*40+5,y*40,30 , 40);
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