package um.MyQueue;

import Exceptions.EmptyQueueException;

public class ColaCircularArray<G> implements MyQueueConListaEnlazada<G>{
	private Object[] cola;
	@SuppressWarnings({ "unused", "unchecked" })
	private G frente = (G) cola[0]; //debi implementar todo con respecto a esto
	@SuppressWarnings("unchecked")
	public ColaCircularArray () {
		cola = (G[])new Object[1];
	}
	
	private boolean arrayCompleto() {
		boolean completo = true;
		for(int i = 0; i < cola.length ; i++ ) {
			if(cola[i] == null) {
				completo = false;
			}
		}
		return completo;
	}

	@SuppressWarnings("unchecked")
	private void redimencionArray() {
		Object[] oExit = cola;
		oExit = (G[]) new Object[cola.length * 2];
		for (int i = 0; i < cola.length; i++) {
			oExit[i] = cola[i];
		}
		this.cola = oExit;
	}
	
	private void ifArrayCompletoRedimencionar() {
		if(arrayCompleto()) {
			redimencionArray();
		}
	}
	
	public void enqueue(G element) {
		boolean coso = true;
		int i = 0;
		while(coso && i<cola.length) {
			if(cola[i] == null) {
				coso = false;
				cola[i]=element;
			}
		}
		ifArrayCompletoRedimencionar();
	}

	
	@SuppressWarnings("unchecked")
	public G dequeue() throws EmptyQueueException {
		G oExit= null;
		if(cola[0] == null) {
			EmptyQueueException e = new EmptyQueueException("La cola esta vacia.");
			throw e;
		}
		oExit = (G) cola[0];
		for (int i = 0; i < cola.length; i++) {
			if (i == cola.length - 1)
				cola[i] = null;
			cola[i] = cola[i + 1];
		}
		return oExit;
	}
		
	
	public boolean isEmpty() {
		boolean oExit = true;
		for(int i = 0 ; i<cola.length ; i++) {
			if(cola[i] != null) {
				oExit = false;
			}
		}
		return oExit;
	}

	
	@SuppressWarnings("unchecked")
	public G getFirst() throws EmptyQueueException {
		G oExit = null;
		if(cola[0]==null) {
			EmptyQueueException e = new EmptyQueueException("La cola esta vacia.");
			throw e;
		}
		oExit = (G) cola[0];
		return oExit;
	}
	
}
