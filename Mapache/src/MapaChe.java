import java.util.Scanner;

public class MapaChe {
	///esto es un comentario random
	static int x;
	static int y;
	static int pwr=1;
	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);
	static int[][] mapa = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

	public static void main(String[] args) {

		initgfx();
		view();
		jugar();

	}

	private static void jugar() {
		initpartida();
		while (true) {
			view();
			mover();
			contabombas();
		}
	}

	private static void contabombas() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 15; j++) {
				if (mapa[i][j]==11) {
					explosion(i,j,pwr);
				}
				if (mapa[i][j]==12) {
					mapa[i][j]=11;
				}
				if (mapa[i][j]==13) {
					mapa[i][j]=12;
				}
			}
		}
	}

	private static void explosion(int i, int j, int pwr2) {
		mapa[i][j]=7;
		for(int k = 1; k<=pwr; k++) {
			if(mapa[i+k][j]!=1) {
				mapa[i+k][j]=7;
			}
			if(mapa[i-k][j]!=1) {
				mapa[i-k][j]=7;
			}
			if(mapa[i][j+k]!=1) {
				mapa[i][j+k]=7;
			}
			if(mapa[i][j-k]!=1) {
				mapa[i][j-k]=7;
			}
		}
		System.out.println("boom");
			
		
	}

	private static void mover() {
		// TODO Auto-generated method stub
		String opt = sc.nextLine();
		switch (opt) {
		case "w":
			if (mapa[x - 1][y] == 0) {
				mapa[x - 1][y] = 2;    
				if (mapa[x][y] == 6) {   //si hay un bb, dejas la bomba atras
					mapa[x][y] = 13;
				} else {
					mapa[x][y] = 0;    //si no era un bb, simplemente dejas espacio en blanco atras
				}
				x--;
			}
			break;
		case "a":
			if (mapa[x][y - 1] == 0) {
				mapa[x][y - 1] = 2;
				if (mapa[x][y] == 6) {
					mapa[x][y] = 13;
				} else {
					mapa[x][y] = 0;
				}
				y--;
			}
			break;
		case "s":
			if (mapa[x + 1][y] == 0) {
				mapa[x + 1][y] = 2;
				if (mapa[x][y] == 6) {
					mapa[x][y] = 13;
				} else {
					mapa[x][y] = 0;
				}
				x++;
			}
			break;
		case "d":
			if (mapa[x][y + 1] == 0) {
				mapa[x][y + 1] = 2;
				if (mapa[x][y] == 6) {
					mapa[x][y] = 13;
				} else {
					mapa[x][y] = 0;
				}
				y++;
			}
			break;
		case "z":
			mapa[x][y] = 6;
		}

	}

	private static void initpartida() {
		// 2 bm
		// 3 bmn
		// 4 bomba
		// 5 bloque
		// 6 bb
		// 7 llama
		// 11 bomba-1turno
		// 12 bomba-2turno
		// 13 bomba-3turno

		mapa[1][1] = 2;
		mapa[11][13] = 3;
		for (int i = 3; i < 10; i = i + 2) {
			for (int j = 3; j < 12; j = j + 2) {
				mapa[i][j] = 5;
			}
		}
		x = 1;
		y = 1;

	}

	private static void initgfx() {
		// background
		t.setActimgbackground(true);
		t.setImgbackground("mapab.jpg");
		t.setPAD(0);
		// imagenes
		t.setActimatges(true);
		String[] imatges = { "", "", "bomberman.png", "bombermannegro.png", "bomba.png", "bloque.png", "bb.png","llama.png","","","","bomba.png","bomba.png","bomba.png" };
		t.setImatges(imatges);

	}

	private static void view() {
		t.dibuixa(mapa);
	}
}
