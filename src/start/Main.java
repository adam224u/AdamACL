package START;

import MODEL.LabyPainter;
import GAME.GameEngineGraphical;
import MODEL.LabyController;
import MODEL.LabyGame;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		LabyGame game = new LabyGame("helpFilePacman.txt");
		LabyPainter painter = new LabyPainter();
		LabyController controller = new LabyController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}
	
}