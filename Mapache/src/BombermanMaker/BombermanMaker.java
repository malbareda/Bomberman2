package BombermanMaker;

import Bomberman.Suelo;
import Bomberman.Pared;
import Bomberman.Caja;
import Bomberman.Coso;
import Bomberman.Enemigo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Bomberman.Bomberman;
import Bomberman.BombermanEnemigo;
import Bomberman.Taulell;
import Bomberman.Finestra;
import Bomberman.Mapa;



public class BombermanMaker {
	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	Coso[][] matriz;
	
	public static void main(String[] args) {
		

		
		initgfx();
		
		
		for(int i=0;i<13;i++) {
			for(int j=0;j<15;j++) {
				System.out.print(Mapa.toIntMatrix()[i][j]);
			}System.out.println();
		}
		t.dibuixa(Mapa.toIntMatrix());
		
		
		ArrayList<Enemigo> enemylist = new ArrayList<>();
		enemylist.add(new BombermanEnemigo(1, 5));
		enemylist.add(new BombermanEnemigo(11, 11));
		enemylist.add(new BombermanEnemigo(11, 3));
		
		Bomberman bm = new Bomberman(7,7);
		
		
		Mapa.overdraw(bm, enemylist);
		t.dibuixa(Mapa.toIntMatrix());
		t.overdibuixa(Mapa.overdraw(bm, enemylist));
		
		/*fichero tendra:
		
		1. Mapa
		2. ListaEnemigos
		3. Bomberman
		
		*/
		String path = "example1.map";
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			//oos.writeObject(mapa);
			oos.writeObject(Mapa.matriz);
			System.out.println(enemylist);
			oos.writeObject(enemylist);
			System.out.println(enemylist);
			oos.writeObject(bm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	private static void initgfx() {
		// TODO Auto-generated method stub
		t.setActimgbackground(false);
		//t.setImgbackground("mapab.jpg");
		t.setPAD(0);
		// imagenes
		t.setActimatges(true);
		String[] imatges = { "", "pared.png", "bomberman.png", "bombermannegro.png", "bomba.png", "caja.png", "bb.png",
				"llama.png", "gore.png", "humornegro.png", "", "suelo.png", "bomba.png", "bomba.png", "", "",
				"bbnegro.png","","","","","bomba.png","bomba.png","bomba.png" };
		t.setImatges(imatges);
		Mapa.get();
		
	}

}
