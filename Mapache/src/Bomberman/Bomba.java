package Bomberman;


public class Bomba extends Coso {

	// params

	int pwr = 1;
	int contador;
	boolean color;//true normal false negra
	
	// metodos
	
	public Bomba(int pwr, int x, int y, boolean color, boolean bm, Enemigo en) {
		this.pwr=pwr;
		this.x=x;
		this.y=y;
		this.color=color;
		this.contador=3;
		img = 4;
		this.bm = bm;
		this.en = en;
	}
	
	
	
	
	
	

	private void explosion() {
		BombermanOO.bombl.remove(this);
		Mapa.matriz[x][y] = new Suelo(x,y,bm);
		Mapa.matriz[x][y].hit(color);
		for(int i =1; i<=pwr;i++) { //ARR
			boolean paso = Mapa.matriz[x-i][y].hit(color);
			if(!paso) {
				break;
			}
		}
		for(int i =1; i<=pwr;i++) { //AB
			boolean paso = Mapa.matriz[x+i][y].hit(color);
			if(!paso) {
				break;
			}
		}
		for(int i =1; i<=pwr;i++) { //IZ
			boolean paso = Mapa.matriz[x][y-i].hit(color);
			if(!paso) {
				break;
			}
		}
		for(int i =1; i<=pwr;i++) { //DER
			boolean paso = Mapa.matriz[x][y+i].hit(color);
			if(!paso) {
				break;
			}
		}
		

	}
	
	
	
	
	public void contabombas() {
		// TODO Auto-generated method stub
		this.contador--;
		if(contador<0) {
			this.explosion();
		}
		
	}
	
	
	public String toString() {
		return img+"";
	}
	
	public int getImg() {
		return img;
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
		this.explosion();
		return false;
	}




	@Override
	protected boolean move(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

}
