import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class BombermanOO {

	
	/// esto es un comentario random
	// esto tambien
	static int x;
	static int y;
	static int pwr = 1;
	static Timer timer = new Timer();
	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);
	
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
				/*
				mover();
				moverenemigo();
				limpieza();
				contabombas();
				*/

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

			private static void view() {
				t.dibuixa(Mapa.toIntMatrix());
			}
		}

}

}
