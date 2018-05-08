package Bomberman;

import java.io.Serializable;

public abstract class Enemigo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2195328996528578907L;
	public int x;
	public int y;
	public int img=3;
	
	public abstract void move();
	public abstract void die();
	public void action() {
		
	}
	
}
