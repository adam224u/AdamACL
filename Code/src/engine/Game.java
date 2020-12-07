package engine;

public interface Game {

	/**
	 * methode qui contient l'evolution du jeu en fonction de la commande
	 *
	 * @param userCmd
	 *            commande utilisateur
	*/
	public void evolve(Cmd userCmd);

	/**
	* @return true si et seulement si le jeu est fini
	*/
	public boolean isFinished();

}

