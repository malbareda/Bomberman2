

public class Mapa {
	
	static Mapa mapa=null;
	static Coso[][] matriz=null;
	final static int FILAS = 13;
	final static int COLUMNAS = 15;
	
	private Mapa(){
		for(int i=0;i<FILAS;i++) {
			matriz[i][0] = new Pared(i, 0);
			matriz[i][COLUMNAS-1] = new Pared(i, COLUMNAS-1);
		}
		for(int i=0;i<COLUMNAS;i++) {
			matriz[0][i] = new Pared(0, i);
			matriz[FILAS-1][i] = new Pared(FILAS-1, i);
		}
		for(int i=1;i<FILAS-1;i++) {
			for(int j=1;j<COLUMNAS-1;j++) {
				if(i%2==0&&j%2==0) {
					matriz[i][j]= new Pared(i,j);
				}else {
					matriz[i][j]= new Suelo(i,j);
				}
			}
		}
		
		
		
	}
	
	public static Mapa get() {
		
		if(mapa==null) {
			mapa= new Mapa();
			return mapa;
		}
		return mapa;
		
	}
	
	public static int[][] toIntMatrix(){
		int[][] imat = new int[FILAS][COLUMNAS];
		for(int i=1;i<FILAS-1;i++) {
			for(int j=1;j<COLUMNAS-1;j++) {
				imat[i][j] = matriz[i][j].img;
			}
		}
		return imat;
		
	}
	
	public static int enemiesLeft() {
		int contador=0;
		for(int i=1;i<FILAS-1;i++) {
			for(int j=1;j<COLUMNAS-1;j++) {
				if(matriz[i][j] instanceof Enemigo) {
					contador++;
				}
			}
		}
		
		
		
		return contador;
		
	}
	
	
	

}
