import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
	static String nom = "player";
	static int punts = 0;
	static Mapa map;
	static ArrayList<EntradaRanking> ranking = new ArrayList<>();

	public static void main(String[] args) {

		initgfx();
		jugar();

	}

	private static void jugar() {
		initpartida();
		leeRanking();
		view();

	}

	private static void leeRanking() {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("ranking")));
			while(in.ready()) {
				String entrada = in.readLine();
				String aen[] = entrada.split(" ");
				int entradapunts = Integer.parseInt(aen[1]);
				EntradaRanking entrank = new EntradaRanking(aen[0],entradapunts);
				ranking.add(entrank);
			}
			Collections.sort(ranking);
			in.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

		String[] etiquetes = { nom, punts + "" };
		f.setEtiquetes(etiquetes);
		view();
		if (enemyl.isEmpty()) {
			win();
		}
		/*
		 * bombas personajes
		 * 
		 * mover(); moverenemigo(); limpieza(); contabombas();
		 */

	}

	private static void limpieza() {
		for (int i = 1; i < Mapa.FILAS - 1; i++) {
			for (int j = 1; j < Mapa.COLUMNAS - 1; j++) {
				if (Mapa.matriz[i][j] instanceof Deflagracion) {
					Mapa.matriz[i][j].limpiar();
				}

			}
		}

	}

	static void win() {
		// TODO Auto-generated method stub

		System.out.println("iu are e winer");
		timer.cancel();

		guardarRanking();

	}

	private static void guardarRanking() {
		// TODO Auto-generated method stub
		EntradaRanking rank = new EntradaRanking(nom, punts);
		ranking.add(rank);
		Collections.sort(ranking);
		File f = new File("ranking");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			for (EntradaRanking er : ranking) {
				out.write(er.nom + " " + er.punts);
				out.newLine();

			}
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void initpartida() {
		System.out.println("Introdueix el teu nom");
		Scanner sc = new Scanner(System.in);
		nom = sc.nextLine();
		punts = 0;
		sc.close();
		map = Mapa.get();
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

		f.setActetiquetes(true);
		String[] etiquetes = { nom, punts + "" };
		f.setEtiquetes(etiquetes);

	}

	private static void view() {
		t.dibuixa(Mapa.toIntMatrix());
		t.overdibuixa(Mapa.overdraw(bm, enemyl));
	}

	public static void gameOver() {
		// TODO Auto-generated method stub
		System.out.println("puto manco");
		guardarRanking();
		timer.cancel();

	}
}
