package GAME;

public class Entity {
	
	public static int x;
	public static int y;
	
	public Entity() {
		this.x=0;
		this.y=0;
	}
	
	public static void Movement(Cmd commande) {
		switch (commande) {
		case IDLE :
			break;
		case LEFT :
			Entity.x = Entity.x - 3;
			break;
		case RIGHT :
			Entity.x = Entity.x + 3;
			break;
		case UP :
			Entity.y = Entity.y - 3;
			break;
		case DOWN :
			Entity.y = Entity.y + 3;
			break;
		}
		
	}

}
