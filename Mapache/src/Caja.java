
public class Caja extends Coso{

	int powerup;
	@Override
	protected boolean hit() {
		Mapa m = Mapa.get();
		m.matriz[x][y] = new Suelo(x,y);
		return false;
		// TODO Auto-generated method stub
		
	}
	@Override
	protected boolean move() {
		// TODO Auto-generated method stub
		System.out.println("pop");
		return false;
	}
	
	

}
