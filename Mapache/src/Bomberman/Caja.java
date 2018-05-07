package Bomberman;

public class Caja extends Coso{

	int powerup;
	public Caja(int x, int y) {
		this.x=x;
		this.y=y;
		img = 5;
	}
	@Override
	protected boolean hit(boolean color) {
		
		
		if (color) {
			BombermanOO.punts++;
		}
		int r = (int) (Math.random()*4);
		if (r==3) {
			Mapa.matriz[x][y] = new PowerUp(x,y);	
		}else
		Mapa.matriz[x][y] = new Suelo(x,y);
		return false;
		// TODO Auto-generated method stub
		
	}
	@Override
	protected boolean move(boolean b) {
		// TODO Auto-generated method stub
		System.out.println("pop");
		return false;
	}
	
	

}
