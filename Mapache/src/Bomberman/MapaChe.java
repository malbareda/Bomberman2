package Bomberman;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MapaChe {
	/// esto es un comentario random
	// esto tambien
	static int x;
	static int y;
	static int pwr = 1;
	static Timer timer = new Timer();
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

	}

	private static void bucle() {
		// TODO Auto-generated method stub
		view();
		mover();
		moverenemigo();
		limpieza();
		contabombas();

	}

	private static void moverenemigo() {

		for (int x = 0; x < 13; x++) {
			for (int y = 0; y < 15; y++) {
				if (mapa[x][y] == 3 || mapa[x][y] == 16) {
					int opt = (int) (Math.random() * 5);
					switch (opt) {
					case 0:
						if (mapa[x - 1][y] == 0) {
							mapa[x - 1][y] = 3;
							if (mapa[x][y] == 16) { // si hay un bb, dejas la bomba atras
								mapa[x][y] = 23;
							} else {
								mapa[x][y] = 0; // si no era un bb, simplemente dejas espacio en blanco atras
							}
							x--;
						}
						break;
					case 1:
						if (mapa[x][y - 1] == 0) {
							mapa[x][y - 1] = 3;
							if (mapa[x][y] == 16) {
								mapa[x][y] = 23;
							} else {
								mapa[x][y] = 0;
							}
							y--;
						}
						break;
					case 2:
						if (mapa[x + 1][y] == 0) {
							mapa[x + 1][y] = 3;
							if (mapa[x][y] == 16) {
								mapa[x][y] = 23;
							} else {
								mapa[x][y] = 0;
							}
							x++;
						}
						break;
					case 3:
						if (mapa[x][y + 1] == 0) {
							mapa[x][y + 1] = 3;
							if (mapa[x][y] == 16) {
								mapa[x][y] = 23;
							} else {
								mapa[x][y] = 0;
							}
							y++;
						}
						break;
					case 4:
						mapa[x][y] = 16;
					}
				}
			}
		}

	}

	private static void contabombas() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 15; j++) {

				if (mapa[i][j] == 11) {
					explosion(i, j, pwr);
				}
				if (mapa[i][j] == 12) {
					mapa[i][j] = 11;
				}
				if (mapa[i][j] == 13) {
					mapa[i][j] = 12;
				}
				
				if (mapa[i][j] == 21) {
					explosionnegra(i, j, pwr);
				}
				if (mapa[i][j] == 22) {
					mapa[i][j] = 21;
				}
				if (mapa[i][j] == 23) {
					mapa[i][j] = 22;
				}

			}
		}
	}

	private static void explosionnegra(int i, int j, int pwr2) {
		mapa[i][j] = 7;
		for (int k = 1; k <= pwr; k++) {
			if ((mapa[i + k][j] == 0) || (mapa[i + k][j] == 5)) {
				mapa[i + k][j] = 7;
			}
			if ((mapa[i + k][j] == 2)) {
				mapa[i + k][j] = 8;
				muerte();
			}
			if ((mapa[i - k][j] == 0) || (mapa[i - k][j] == 5)) {
				mapa[i - k][j] = 7;
			}
			if ((mapa[i - k][j] == 2)) {
				mapa[i - k][j] = 8;
				muerte();
			}
			if ((mapa[i][j + k] == 0) || (mapa[i][j + k] == 5)) {
				mapa[i][j + k] = 7;
			}
			if ((mapa[i][j + k] == 2)) {
				mapa[i][j + k] = 8;
				muerte();
			}
			if ((mapa[i][j - k] == 0) || (mapa[i][j - k] == 5)) {
				mapa[i][j - k] = 7;
			}
			if ((mapa[i][j - k] == 2)) {
				mapa[i][j - k] = 8;
				muerte();
			}
		}
		System.out.println("boom negro");
		
	}

	private static void explosion(int i, int j, int pwr2) {
		mapa[i][j] = 7;
		for (int k = 1; k <= pwr; k++) {
			if ((mapa[i + k][j] == 0) || (mapa[i + k][j] == 5)) {
				mapa[i + k][j] = 7;
			}
			if ((mapa[i + k][j] == 2)) {
				mapa[i + k][j] = 8;
				muerte();
			}
			if ((mapa[i + k][j] == 3)) {
				mapa[i + k][j] = 9;
				win();
			}
			if ((mapa[i + k][j] == 13 || mapa[i + k][j] == 12 || mapa[i + k][j] == 11 || mapa[i + k][j] == 6 )) {
				if ((mapa[i+k][j] == 6)) {
					muerte();
				}
				explosion(i+k,j,pwr);
				
			}
			if ((mapa[i - k][j] == 0) || (mapa[i - k][j] == 5)) {
				mapa[i - k][j] = 7;
			}
			if ((mapa[i - k][j] == 2)) {
				mapa[i - k][j] = 8;
				muerte();
			}
			if ((mapa[i - k][j] == 3)) {
				mapa[i - k][j] = 9;
				win();
			}
			if ((mapa[i - k][j] == 13) ||(mapa[i - k][j] == 12) ||(mapa[i - k][j] == 11) ||(mapa[i - k][j] == 6) ) {
				if ((mapa[i-k][j] == 6)) {
					muerte();
				}
				explosion(i-k,j,pwr);
				
			}
			if ((mapa[i][j + k] == 0) || (mapa[i][j + k] == 5)) {
				mapa[i][j + k] = 7;
			}
			if ((mapa[i][j + k] == 2)) {
				mapa[i][j + k] = 8;
				muerte();
			}
			if ((mapa[i][j + k] == 3)) {
				mapa[i][j + k] = 9;
				win();
			}
			if ((mapa[i][j + k] == 13 || mapa[i][j + k] == 12 || mapa[i][j + k] == 11 || mapa[i][j + k] == 6)) {
				if ((mapa[i][j + k] == 6)) {
					muerte();
				}
				explosion(i,j+k,pwr);

			}
			if ((mapa[i][j - k] == 0) || (mapa[i][j - k] == 5)) {
				mapa[i][j - k] = 7;
			}
			if ((mapa[i][j - k] == 2)) {
				mapa[i][j - k] = 8;
				muerte();
			}
			if ((mapa[i][j - k] == 3)) {
				mapa[i][j - k] = 9;
				win();
			}
			if ((mapa[i][j - k] == 13) ||(mapa[i][j - k] == 12) ||(mapa[i][j - k] == 11) ||(mapa[i][j - k] == 6) ) {
				if ((mapa[i][j - k] == 6)) {
					muerte();
				}
				explosion(i,j-k,pwr);
				
			}
			
			
		}
		System.out.println("boom");

	}

	static void win() {
		// TODO Auto-generated method stub
		int contan = 0;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				if (mapa[i][j] == 3 || mapa[i][j] == 16) {
					contan++;
				}

			}
		}
		if (contan == 0) {
			System.out.println("iu are e winer");
			timer.cancel();
		}

	}

	static void muerte() {
		// TODO Auto-generated method stub
		System.out.println("puto manco");
		timer.cancel();

	}

	private static void mover() {
		// TODO Auto-generated method stub
		char opt = f.getActualChar();
		switch (opt) {
		case 'w':
			if (mapa[x - 1][y] == 0) {
				mapa[x - 1][y] = 2;
				if (mapa[x][y] == 6) { // si hay un bb, dejas la bomba atras
					mapa[x][y] = 13;
				} else {
					mapa[x][y] = 0; // si no era un bb, simplemente dejas espacio en blanco atras
				}
				x--;
			}
			break;
		case 'a':
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
		case 's':
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
		case 'd':
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
		case 'z':
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
		// 8 gore
		// 9 goren
		// 11 bomba-1turno
		// 12 bomba-2turno
		// 13 bomba-3turno
		// 16 bbnegro
		// 21 bomban-1turno
		// 22 bomban-2turno
		// 33 bomban-3turno

		mapa[1][1] = 2;
		mapa[11][13] = 3;
		mapa[1][13] = 3;
		for (int i = 3; i < 10; i = i + 2) {
			for (int j = 3; j < 12; j = j + 2) {
				mapa[i][j] = 5;
			}
		}
		x = 1;
		y = 1;

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				bucle();
			}

		}, 0, 600);
	}

	private static void initgfx() {
		// background
		t.setActimgbackground(true);
		t.setImgbackground("mapab.jpg");
		t.setPAD(0);
		// imagenes
		t.setActimatges(true);
		String[] imatges = { "", "", "bomberman.png", "bombermannegro.png", "bomba.png", "bloque.png", "bb.png",
				"llama.png", "gore.png", "humornegro.png", "", "bomba.png", "bomba.png", "bomba.png", "", "",
				"bbnegro.png","","","","","bomba.png","bomba.png","bomba.png" };
		t.setImatges(imatges);

	}

	private static void limpieza() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				// TODO Auto-generated method stub
				if (mapa[i][j] == 7 || mapa[i][j] == 9) {
					mapa[i][j] = 0;
				}
			}
		}
	}

	private static void view() {
		t.dibuixa(mapa);
	}
}
