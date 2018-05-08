package Bomberman;

import java.io.Serializable;

public class Pared extends Coso implements Serializable{

	public Pared(int x, int y) {
		this.x=x;
		this.y=y;
		img = 1;
	}
	@Override
	protected boolean hit(boolean color) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean move(boolean b) {
		// TODO Auto-generated method stub
		System.out.println("pop");
		return false;
	}

}
