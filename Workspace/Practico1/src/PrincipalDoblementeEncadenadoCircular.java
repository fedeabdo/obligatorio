import uy.edu.um.prog2.tad.linkedlist.MiListaDoblementeEncadenadaCircular;

public class PrincipalDoblementeEncadenadoCircular {

	public static void main(String[] args) {
		MiListaDoblementeEncadenadaCircular miLista = new MiListaDoblementeEncadenadaCircular();
		miLista.addFirst(0);
		miLista.addFirst(-1);
		miLista.agregar(4);
		miLista.agregar(1);		
		miLista.agregar(4);
		miLista.agregar(1);
		miLista.agregar(4);
		miLista.agregar(1);
		System.out.println(miLista.tamanio());
		miLista.eliminar(1);
		System.out.println(miLista.tamanio());
		miLista.eliminar(1);
		System.out.println(miLista.tamanio());
		miLista.eliminar(1);
		System.out.println(miLista.tamanio());
//		System.out.println(miLista.obtener(0));
//		miLista.addFirst(C);
//		miLista.agregar(5);
//		System.out.println(miLista.obtener(0) + " " +miLista.obtener(1) + " " +miLista.obtener(2) + " " +miLista.obtener(0));
	}

}
