package Bomberman;
public class PowerUp extends Coso {

	public PowerUp(int x, int y) {
		this.x=x;
		this.y=y;
		img = 10;
	}
	

	@Override
	protected boolean hit(boolean color) {
		// TODO Auto-generated method stub
		
		Mapa.matriz[x][y] = new Suelo(x,y);
		return true;
	}

	@Override
	protected boolean move(boolean b) {
		// TODO Auto-generated method stub
		if(b) {
			BombermanOO.punts+=3;
			Mapa.matriz[x][y] = new Suelo(x,y);
			Bomberman.pwr++;
		}
		return true;
	}

}
