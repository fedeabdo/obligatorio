package um.MyQueue;

import Exceptions.EmptyQueueException;
import uy.edu.um.prog2.tad.linkedlist.ListaEnlazadaSimple;

public class MyQueueConListaEnlazadaImplements<G> implements MyQueueConListaEnlazada<G> {
	private ListaEnlazadaSimple<G> miLista;
	private G primerElemento;
	private G ultimoElemento;
	
	public MyQueueConListaEnlazadaImplements () {
		miLista = new ListaEnlazadaSimple<>();
	}
	

	public void enqueue(G element) {
		miLista.addLast(element);		
		primerElemento = miLista.obtener(0);
		ultimoElemento = miLista.obtener(miLista.tamanio()-1);
	}


	public G dequeue() throws EmptyQueueException {
		G oExit;
		if(miLista.tamanio() == 0) {
			EmptyQueueException e = new EmptyQueueException("La cola esta vacia.");
			throw e;
		}
		oExit = miLista.obtener(0);
		miLista.eliminar(0);
		if( miLista.tamanio() == 0) {
			primerElemento = null;
		}else {
			primerElemento = miLista.obtener(0);
		}
		if(miLista.tamanio() == 0) {
			ultimoElemento = null;
		}else {
			ultimoElemento = miLista.obtener(miLista.tamanio()-1);
		}
		return oExit;
	}

	
	public boolean isEmpty() {
		boolean bExit = false;
		if (primerElemento == null && ultimoElemento == null) {
			bExit = true;
		}
		return bExit;
	}

	public G getFirst() throws EmptyQueueException {
		G oExit;
		if(primerElemento == null) {
			EmptyQueueException e = new EmptyQueueException("La cola esta vacia.");
			throw e;
		}
		oExit = primerElemento;
		return oExit;
	}
	
	public int size() {
		return miLista.tamanio();
	}

}
