package Bomberman;
import java.util.ArrayList;

public class Mapa {
	
	static Mapa mapa=null;
	final static int FILAS = 13;
	final static int COLUMNAS = 15;
	public static Coso[][] matriz=new Coso[FILAS][COLUMNAS];

	
	private Mapa(){
		matriz = new Coso[FILAS][COLUMNAS];
		for(int i=0;i<FILAS;i++) {
			for(int j=0;j<COLUMNAS;j++) {
				matriz[i][j] = new Suelo(i, j);
			}
		}
		for(int i=0;i<FILAS;i++) {
			matriz[i][0] = new Pared(i, 0);
			matriz[i][COLUMNAS-1] = new Pared(i, COLUMNAS-1);
		}
		for(int i=0;i<COLUMNAS;i++) {
			matriz[0][i] = new Pared(0, i);
			matriz[FILAS-1][i] = new Pared(FILAS-1, i);
		}
		
		/*for(int i=1;i<FILAS-1;i++) {
			for(int j=1;j<COLUMNAS-1;j++) {
				if(i%2==0&&j%2==0) {
					matriz[i][j]= new Pared(i,j);
				}
				else if(i%2==1&&j%2==1&&i>2&&j>2) {
					matriz[i][j]= new Caja(i,j);
				}
				else {
					matriz[i][j]= new Suelo(i,j);
				}
			}
		}*/
		
		
		
	}
	
	public static Mapa get() {
		
		if(mapa==null) {
			mapa= new Mapa();
			return mapa;
		}
		return mapa;
		
	}
	
	
	
	
	public static int[][] toIntMatrix(){
		int pared=0;
		int[][] imat = new int[FILAS][COLUMNAS];
		for(int i=0;i<FILAS;i++) {
			for(int j=0;j<COLUMNAS;j++) {
				imat[i][j] = matriz[i][j].img;
				if(imat[i][j]==1) pared++;
			}
		}
		//System.out.println(pared);
		return imat;
		
	}

	public static int[][] overdraw(Bomberman bm, ArrayList<Enemigo> enemyl) {
		int[][] over=new int[FILAS][COLUMNAS];
		over[bm.x][bm.y]=Bomberman.img;
		for (Enemigo en : enemyl) {
			over[en.x][en.y]=en.img;
		}
		
		return over;
		// 2 bm
				// 3 bmn
				// 4 bomba
				// 5 bloque
				// 6 bb
				// 7 llama
				// 8 gore
				// 9 goren
				// 11 bomba-1turno
				// 12 bomba-2turno
				// 13 bomba-3turno
				// 16 bbnegro
				// 21 bomban-1turno
				// 22 bomban-2turno
				// 33 bomban-3turno
		
	}
	
	/**public static int enemiesLeft() {
		int contador=0;
		for(int i=1;i<FILAS-1;i++) {
			for(int j=1;j<COLUMNAS-1;j++) {
				if(matriz[i][j] instanceof Enemigo) {
					contador++;
				}
			}
		}
		
		
		
		return contador;
		
	}**/
	
	
	

}
