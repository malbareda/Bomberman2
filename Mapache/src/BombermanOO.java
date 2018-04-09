import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class BombermanOO {

	static Timer timer = new Timer();
	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static ArrayList<Bomba> bombl = new ArrayList<>();
	static ArrayList<Enemigo> enemyl = new ArrayList<>();
	static Bomberman bm;

	public static void main(String[] args) {

		initgfx();
		jugar();

	}

	private static void jugar() {
		initpartida();

		view();

	}

	private static void bucle() {
		// TODO Auto-generated method stub
		for (Bomba b : bombl) {
			b.contabombas();
		}
		for (Enemigo e : enemyl) {
			//e.move();
		}

		bm.move();

		view();
		/*
		 * bombas personajes
		 * 
		 * mover(); moverenemigo(); limpieza(); contabombas();
		 */

	}

	static void win() {
		// TODO Auto-generated method stub

		if (enemyl.isEmpty()) {
			System.out.println("iu are e winer");
			timer.cancel();
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
		Mapa m = Mapa.get();
		bm = new Bomberman(1, 1);
		enemyl.add(new BombermanEnemigo(1, 13));
		enemyl.add(new BombermanEnemigo(1, 13));
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
				"bbnegro.png", "", "", "", "", "bomba.png", "bomba.png", "bomba.png" };
		t.setImatges(imatges);

	}

	private static void view() {
		t.dibuixa(Mapa.toIntMatrix());
		t.overdibuixa(Mapa.overdraw(bm,enemyl));
	}

	public static void gameOver() {
		// TODO Auto-generated method stub
		System.out.println("puto manco");
		timer.cancel();

	}
}
