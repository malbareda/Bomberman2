
public class Bomba {

	// params

	int pwr = 1;
	int x, y;
	int contador;
	boolean color;//true normal false negra
	static int img = 6;

	// metodos
	
	public Bomba(int pwr, int x, int y, boolean color) {
		this.pwr=pwr;
		this.x=x;
		this.y=y;
		this.color=color;
		this.contador=3;
	}

	private void explosion() {
		MapaChe.mapa[x][y] = 7;
		for (int k = 1; k <= pwr; k++) {
			if ((MapaChe.mapa[x + k][y] == 0) || (MapaChe.mapa[x + k][y] == 5)) {
				MapaChe.mapa[x + k][y] = 7;
			}
			if ((MapaChe.mapa[x + k][y] == 2)) {
				MapaChe.mapa[x + k][y] = 8;
				MapaChe.muerte();
			}
			if ((MapaChe.mapa[x + k][y] == 3)) {
				MapaChe.mapa[x + k][y] = 9;
				MapaChe.win();
			}
			if ((MapaChe.mapa[x + k][y] == 13 || MapaChe.mapa[x + k][y] == 12 || MapaChe.mapa[x + k][y] == 11 || MapaChe.mapa[x + k][y] == 6)) {
				if ((MapaChe.mapa[x + k][y] == 6)) {
					MapaChe.muerte();
				}
				//explosion(x + k, y, pwr);

			}
			if ((MapaChe.mapa[x - k][y] == 0) || (MapaChe.mapa[x - k][y] == 5)) {
				MapaChe.mapa[x - k][y] = 7;
			}
			if ((MapaChe.mapa[x - k][y] == 2)) {
				MapaChe.mapa[x - k][y] = 8;
				MapaChe.muerte();
			}
			if ((MapaChe.mapa[x - k][y] == 3)) {
				MapaChe.mapa[x - k][y] = 9;
				MapaChe.win();
			}
			if ((MapaChe.mapa[x - k][y] == 13) || (MapaChe.mapa[x - k][y] == 12) || (MapaChe.mapa[x - k][y] == 11) || (MapaChe.mapa[x - k][y] == 6)) {
				if ((MapaChe.mapa[x - k][y] == 6)) {
					MapaChe.muerte();
				}
				//explosion(x - k, y, pwr);

			}
			if ((MapaChe.mapa[x][y + k] == 0) || (MapaChe.mapa[x][y + k] == 5)) {
				MapaChe.mapa[x][y + k] = 7;
			}
			if ((MapaChe.mapa[x][y + k] == 2)) {
				MapaChe.mapa[x][y + k] = 8;
				MapaChe.muerte();
			}
			if ((MapaChe.mapa[x][y + k] == 3)) {
				MapaChe.mapa[x][y + k] = 9;
				MapaChe.win();
			}
			if ((MapaChe.mapa[x][y + k] == 13 || MapaChe.mapa[x][y + k] == 12 || MapaChe.mapa[x][y + k] == 11 || MapaChe.mapa[x][y + k] == 6)) {
				if ((MapaChe.mapa[x][y + k] == 6)) {
					MapaChe.muerte();
				}
				//explosion(x, y + k, pwr);

			}
			if ((MapaChe.mapa[x][y - k] == 0) || (MapaChe.mapa[x][y - k] == 5)) {
				MapaChe.mapa[x][y - k] = 7;
			}
			if ((MapaChe.mapa[x][y - k] == 2)) {
				MapaChe.mapa[x][y - k] = 8;
				MapaChe.muerte();
			}
			if ((MapaChe.mapa[x][y - k] == 3)) {
				MapaChe.mapa[x][y - k] = 9;
				MapaChe.win();
			}
			if ((MapaChe.mapa[x][y - k] == 13) || (MapaChe.mapa[x][y - k] == 12) || (MapaChe.mapa[x][y - k] == 11) || (MapaChe.mapa[x][y - k] == 6)) {
				if ((MapaChe.mapa[x][y - k] == 6)) {
					MapaChe.muerte();
				}
				//explosion(x, y - k, pwr);

			}

		}
		System.out.println("boom");

	}

	private void explosionnegra() {
		MapaChe.mapa[x][y] = 7;
		for (int k = 1; k <= pwr; k++) {
			if ((MapaChe.mapa[x + k][y] == 0) || (MapaChe.mapa[x + k][y] == 5)) {
				MapaChe.mapa[x + k][y] = 7;
			}
			if ((MapaChe.mapa[x + k][y] == 2)) {
				MapaChe.mapa[x + k][y] = 8;
				MapaChe.muerte();
			}
			if ((MapaChe.mapa[x - k][y] == 0) || (MapaChe.mapa[x - k][y] == 5)) {
				MapaChe.mapa[x - k][y] = 7;
			}
			if ((MapaChe.mapa[x - k][y] == 2)) {
				MapaChe.mapa[x - k][y] = 8;
				MapaChe.muerte();
			}
			if ((MapaChe.mapa[x][y + k] == 0) || (MapaChe.mapa[x][y + k] == 5)) {
				MapaChe.mapa[x][y + k] = 7;
			}
			if ((MapaChe.mapa[x][y + k] == 2)) {
				MapaChe.mapa[x][y + k] = 8;
				MapaChe.muerte();
			}
			if ((MapaChe.mapa[x][y - k] == 0) || (MapaChe.mapa[x][y - k] == 5)) {
				MapaChe.mapa[x][y - k] = 7;
			}
			if ((MapaChe.mapa[x][y - k] == 2)) {
				MapaChe.mapa[x][y - k] = 8;
				MapaChe.muerte();
			}
		}
		System.out.println("boom negro");

	}
	
	
	
	
	private void contabombas() {
		// TODO Auto-generated method stub
		this.contador--;
		if(contador<0) {
			if(color==true) this.explosion();
			else this.explosionnegra();
		}
		
	}
	
	
	public String toString() {
		return img+"";
	}
	
	public int getImg() {
		return img;
	}

}
