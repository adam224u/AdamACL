package engine;
import java.awt.event.KeyListener;

public interface GameController extends KeyListener {
	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand();

}

