package Bomberman;

import java.io.Serializable;

public class BombermanEnemigo extends Enemigo implements Personaje, Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3856531570460144513L;
	int pwr=1;
	public int img=3;
	
	public BombermanEnemigo(int i, int j) {
		// TODO Auto-generated constructor stub
		x=i;
		y=j;
		Mapa.matriz[i][j].en=this;
		pwr=1;
		
	}

	@Override
	public void move() {
		
		
		// TODO Auto-generated method stub
		int rand = (int) (Math.random()*5);
		
		switch(rand) {
		case 0:
			//ARR
			if(Mapa.matriz[x-1][y].move(false)==true) {
				Mapa.matriz[x][y].en=null;
				Mapa.matriz[x-1][y].en=this;
				x--;
			}
			break;
		case 1:
			if(Mapa.matriz[x+1][y].move(false)==true) {
				Mapa.matriz[x][y].en=null;
				Mapa.matriz[x+1][y].en=this;
				x++;
			}
			break;
		case 2:
			if(Mapa.matriz[x][y-1].move(false)==true) {
				Mapa.matriz[x][y].en=null;
				Mapa.matriz[x][y-1].en=this;
				y--;
			}
			break;
		case 3:
			if(Mapa.matriz[x][y+1].move(false)==true) {
				Mapa.matriz[x][y].en=null;
				Mapa.matriz[x][y+1].en=this;
				y++;
			}
			break;
		case 4:
			action();
			break;
			
		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Bomba b = new Bomba(pwr,x,y,false,false,this);
		Mapa.matriz[x][y] = b; 
		BombermanOO.bombl.add(b);
		
	}

	public String toString() {
		return ("Negro en "+x+" "+y);
	}
	@Override
	public void die() {
		// TODO Auto-generated method stub
		img=9;
		BombermanOO.enemyl.remove(this);
		BombermanOO.punts+=10;
		
		
	}

}
