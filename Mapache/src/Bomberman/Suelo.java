package Bomberman;

public class Suelo extends Coso {

	public Suelo(int x, int y, boolean bm) {
		this.x=x;
		this.y=y;
		img = 0;
		this.bm=bm;
	}
	
	public Suelo(int x, int y) {
		this.x=x;
		this.y=y;
		img = 0;
	}

	@Override
	protected boolean hit(boolean color) {
		// TODO Auto-generated method stub
		if(bm) {
			BombermanOO.bm.die();
		}
		if(en!=null&&color==true) {
			en.die();
		}
		Mapa m = Mapa.get();
		m.matriz[x][y] = new Deflagracion(x,y);
		return true;
	}

	@Override
	protected boolean move(boolean b) {
		// TODO Auto-generated method stub
		return true;
	}

}
