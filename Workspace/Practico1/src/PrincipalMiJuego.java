import Exceptions.IllegalArgumentsException;
import uy.edu.um.prog2.tad.linkedlist.MiJuego;
import uy.edu.um.prog2.tad.linkedlist.MiListaDoblementeEncadenadaCircular;
import uy.edu.um.prog2.tad.linkedlist.MiListaEncadenada;

public class PrincipalMiJuego {

	public static void main(String[] args) throws IllegalArgumentsException {
		MiJuego juego = new MiJuego();
		int saltos = 5;
		MiListaDoblementeEncadenadaCircular colIntegrantes = new MiListaDoblementeEncadenadaCircular();
		for( int i = 0 ; i<5 ; i++ ) {
			colIntegrantes.agregar(i+1);
		}
//		System.out.println(colIntegrantes.tamanio());
		MiListaEncadenada eliminados = juego.juego(saltos, colIntegrantes);
		System.out.println("Eliminados en orden:");
		for(int i = 0; i<eliminados.tamanio() ; i++) {
			System.out.println(eliminados.obtener(i));
		}
		System.out.println("\nGanador: " + juego.getGanador().obtener(0));
	}

}
