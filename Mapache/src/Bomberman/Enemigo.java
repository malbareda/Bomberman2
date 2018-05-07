package Bomberman;

public abstract class Enemigo {

	public int x;
	public int y;
	public int img=3;
	
	public abstract void move();
	public abstract void die();
	public void action() {
		
	}
	
}
