package Bomberman;

import java.io.Serializable;

public abstract class Coso implements Serializable {
	
	int x, y;
	public int img;
	Enemigo en;
	boolean bm;
	
	protected abstract boolean hit(boolean color);
	
	protected abstract boolean move(boolean b);

	public void limpiar() {
		// TODO Auto-generated method stub
		
	}




}
