
public class Bomberman implements Personaje{

	static int pwr=1;
	int x,y;
	static int img=2;
	
	public Bomberman(int i, int j) {
		// TODO Auto-generated constructor stub
		x=i;
		y=j;
		Mapa.matriz[i][j].bm=true;
		pwr=1;
		
	}

	@Override
	public void move() {
		
		
		// TODO Auto-generated method stub
		char opt = BombermanOO.f.getActualChar();
		
		switch(opt) {
		case 'w':
			//ARR
			if(Mapa.matriz[x-1][y].move(true)==true) {
				Mapa.matriz[x][y].bm=false;
				Mapa.matriz[x-1][y].bm=true;
				x--;
			}
			break;
		case 's':
			if(Mapa.matriz[x+1][y].move(true)==true) {
				Mapa.matriz[x][y].bm=false;
				Mapa.matriz[x+1][y].bm=true;
				x++;
			}
			break;
		case 'a':
			if(Mapa.matriz[x][y-1].move(true)==true) {
				Mapa.matriz[x][y].bm=false;
				Mapa.matriz[x][y-1].bm=true;
				y--;
			}
			break;
		case 'd':
			if(Mapa.matriz[x][y+1].move(true)==true) {
				Mapa.matriz[x][y].bm=false;
				Mapa.matriz[x][y+1].bm=true;
				y++;
			}
			break;
		case 'z':
			action();
			break;
			
		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Bomba b = new Bomba(pwr,x,y,true,true,null);
		Mapa.matriz[x][y] = b; 
		BombermanOO.bombl.add(b);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		img = 8;
		BombermanOO.gameOver();
		
	}

}
