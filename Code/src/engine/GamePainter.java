package engine;

import java.awt.image.BufferedImage;

public interface GamePainter {
	/**
	 * methode dessiner a completer. Elle construit une image correspondant au
	 * jeu. Game est un attribut de l'afficheur
	 * 
	 * @param image
	 *            image sur laquelle dessiner
	 */
	public abstract void draw(BufferedImage image);

	public abstract int getWidth();

	public abstract int getHeight();
	
}

