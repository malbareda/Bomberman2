package Bomberman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class BombermanOO {

	static Timer timer = new Timer();
	static Taulell t = new Taulell();
	static RubenMenu rm = new RubenMenu();
	static Finestra f = new Finestra(t);
	static ArrayList<Bomba> bombl = new ArrayList<>();
	static ArrayList<Enemigo> enemyl = new ArrayList<>();
	static Bomberman bm;
	static String nom = "player";
	static int punts = 0;
	static Mapa map;
	static ArrayList<EntradaRanking> ranking = new ArrayList<>();
	static boolean empezar = false;

	public static void main(String[] args) {

		RubenMenu.main(null);
		

	}

	static void jugar() {
		initgfx();
		initpartida();
		leeRanking();
		view();

	}

	private static void leeRanking() {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("ranking")));
			while (in.ready()) {
				String entrada = in.readLine();
				String aen[] = entrada.split(" ");
				int entradapunts = Integer.parseInt(aen[1]);
				EntradaRanking entrank = new EntradaRanking(aen[0], entradapunts);
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
		//Scanner sc = new Scanner(System.in);
		//nom = sc.nextLine();
		//sc.close();
		punts = 0;
		
		
		if (false) {
			cargarMapa("example1.map");
		} else {
			map = Mapa.get(true);
			bm = new Bomberman(1, 1);
			enemyl.add(new BombermanEnemigo(1, 13));
			enemyl.add(new BombermanEnemigo(10, 13));
		}
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				bucle();
			}

		}, 0, 600);
	}
	
	static void loadState() {
		// TODO Auto-generated method stub
		FileInputStream fis;
		try {
			fis = new FileInputStream("save.sav");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				Object o = ois.readObject();
				if (o instanceof Coso[][]) Mapa.matriz = (Coso[][]) o;
				else if(o instanceof Bomberman) bm = (Bomberman) o;
				else if(o instanceof ArrayList<?>) {
					ArrayList<?> ao = (ArrayList<?>) o;
					Object so = ao.get(0);
					if(so instanceof Bomba) bombl = (ArrayList<Bomba>) o;
					else if (so instanceof Enemigo) enemyl = (ArrayList<Enemigo>) o;
				}
			}
			
			/*Metodo cutre
			 * Mapa.matriz = (Coso[][]) o;
			 * Object o2 = ois.readObject();
			bm = (Bomberman) o2;
			Object o3 = ois.readObject();
			bombl = (ArrayList<Bomba>) o3;
			Object o4 = ois.readObject();
			enemyl = (ArrayList<Enemigo>) o4;
			 */
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cargado");
		}
	}

	static void saveState() {
		// TODO Auto-generated method stub
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("save.sav");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Mapa.matriz);
			oos.writeObject(bm);
			oos.writeObject(bombl);
			oos.writeObject(enemyl);
			System.out.println("Guardado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	private static void cargarMapa(String path) {
		// TODO Auto-generated method stub

		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(path));

			Object cas;
			while (true) {
				cas = ois.readObject();
				if (cas instanceof ArrayList) {
					System.out.println(cas);
					enemyl = (ArrayList<Enemigo>) cas;
					System.out.println(enemyl);
				} else if (cas instanceof Bomberman) {
					System.out.println(cas);
					bm = (Bomberman) cas;
				} else if (cas instanceof Coso[][]) {
					System.out.println(cas);
					Mapa.get(false);
					Mapa.matriz=(Coso[][]) cas;
				}
			}

		} catch (EOFException e) {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	private static void initgfx() {
		
		
		// background
		t.setActimgbackground(false);
		t.setImgbackground("mapab.jpg");
		t.setPAD(0);
		// imagenes
		t.setActimatges(true);
		String[] imatges = { "", "pared.png", "bomberman.png", "bombermannegro.png", "bomba.png", "caja.png", "bb.png",
				"llama.png", "gore.png", "humornegro.png", "pu.jpg", "suelo.png", "bomba.png", "bomba.png", "", "",
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
