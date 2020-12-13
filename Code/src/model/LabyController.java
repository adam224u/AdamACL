package model;

import java.awt.event.KeyEvent;

import game.Cmd;
import game.GameController; 

public class LabyController implements GameController{






/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * controleur de type KeyListener
 * 
 */

	/**
	 * commande en cours
	 */
	private Cmd commandeEnCours;
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public LabyController() {
		this.commandeEnCours = Cmd.IDLE;
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand() {
		return this.commandeEnCours;
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {
		

		switch (e.getKeyChar()) {
		// si on appuie sur 'q',commande joueur est gauche
		case 'q':
			this.commandeEnCours = Cmd.LEFT;
			break;
		case 'Q':
			this.commandeEnCours = Cmd.LEFT;
			break;
		case 'z':
			this.commandeEnCours = Cmd.UP;
			break;
		case 'Z':
			this.commandeEnCours = Cmd.UP;
			break;
		case 's' : 
			this.commandeEnCours = Cmd.DOWN;
		break;
		case 'S' : 
			this.commandeEnCours = Cmd.DOWN;
		break;
		case 'D' : 
			this.commandeEnCours = Cmd.RIGHT;
		break;
		case 'd' : 
			this.commandeEnCours = Cmd.RIGHT;
		break;
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		this.commandeEnCours = Cmd.IDLE;
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}
}