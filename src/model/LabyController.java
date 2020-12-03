package model;

import java.awt.event.KeyEvent;

import engine.Cmd;
import engine.GameController; 

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
		switch (e.getKeyCode()) {
		// si on appuie sur 'q',commande joueur est gauche
		
		// z 90 s 83 q 81 d 68 up 38 left 37 down 40 right 39
		case 81:
			this.commandeEnCours = Cmd.LEFT;
			break;
		
		case 37:
			this.commandeEnCours = Cmd.LEFT;
			break;
			
		case 90:
			this.commandeEnCours = Cmd.UP;
			break;
		
		case KeyEvent.VK_UP:
			this.commandeEnCours = Cmd.UP;
			break;
			
		case 83 : 
			this.commandeEnCours = Cmd.DOWN;
		break;
		
		
		case KeyEvent.VK_DOWN : 
			this.commandeEnCours = Cmd.DOWN;
		break;
		
		case 68 : 
			this.commandeEnCours = Cmd.RIGHT;
		break;
		
		case KeyEvent.VK_RIGHT : 
			this.commandeEnCours = Cmd.RIGHT;
		break;
		}

		
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
