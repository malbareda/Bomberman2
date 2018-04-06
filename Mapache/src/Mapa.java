

public class Mapa {
	
	static Mapa mapa=null;
	static Coso[][] matriz=null;
	final int FILAS = 13;
	final int COLUMNAS = 15;
	
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
	
	static Mapa get() {
		
		if(mapa==null) {
			mapa= new Mapa();
			return mapa;
		}
		return mapa;
		
	}
	

}
