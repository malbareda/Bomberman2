package Bomberman;

public class Deflagracion extends Coso {

	public Deflagracion(int x, int y) {
		this.x=x;
		this.y=y;
		img = 7;
	}

	@Override
	protected boolean hit(boolean color) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean move(boolean b) {
		// TODO Auto-generated method stub
		return true;
		//pero te matare.
	}

	@Override
	public void limpiar() {
		Mapa.matriz[x][y] = new Suelo(x,y);
		
	}
}
