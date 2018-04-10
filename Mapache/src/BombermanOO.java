import java.util.ArrayList;
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
		limpieza();
		bm.move();
		ArrayList<Bomba> tb = new ArrayList<>();
		tb.addAll(bombl);
		for (Bomba b : tb) {
			b.contabombas();
		}
		ArrayList<Enemigo> te = new ArrayList<>();
		te.addAll(enemyl);
		for (Enemigo e : te) {
			e.move();
		}
		



		view();
		/*
		 * bombas personajes
		 * 
		 * mover(); moverenemigo(); limpieza(); contabombas();
		 */

	}

	private static void limpieza() {
		for(int i=1;i<Mapa.FILAS-1;i++) {
			for(int j=1;j<Mapa.COLUMNAS-1;j++) {
				if(Mapa.matriz[i][j] instanceof Deflagracion) {
					Mapa.matriz[i][j].limpiar();
				}
					
				}
			}
		
	}

	static void win() {
		// TODO Auto-generated method stub

		if (enemyl.isEmpty()) {
			System.out.println("iu are e winer");
			timer.cancel();
		}

	}

	private static void initpartida() {
		bm = new Bomberman(1, 1);
		enemyl.add(new BombermanEnemigo(1, 13));
		enemyl.add(new BombermanEnemigo(10, 13));
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
				"llama.png", "gore.png", "humornegro.png", "pu.jpg", "bomba.png", "bomba.png", "bomba.png", "", "",
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
