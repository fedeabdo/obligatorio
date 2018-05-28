package um.MyQueue;
import Exceptions.EmptyQueueException;
import uy.edu.um.prog2.tad.linkedlist.ListaEnlazadaSimple;


public class MyDoubleQueueImplements<G> implements MyDoubleQueue<G>{
	private ListaEnlazadaSimple<G> miQueue;
	private G primero;
	private G ultimo;
	
	public MyDoubleQueueImplements() {
		miQueue = new ListaEnlazadaSimple<>();
	}
	
	@Override
	public void enqueueLeft(G oTemp) {
		miQueue.addFirst(oTemp);
		setPrimero(oTemp);
		if(miQueue.tamanio()==1)
			setUltimo(oTemp);
	}

	@Override
	public void enqueueRight(G oTemp) {
		miQueue.addLast(oTemp);
		setUltimo(oTemp);	
		if(miQueue.tamanio()==1)
			setPrimero(oTemp);
	}

	@Override
	public G dequeueLeft() throws EmptyQueueException{
		if(miQueue.tamanio() == 0) {
			EmptyQueueException e = new EmptyQueueException("La cola esta vacia.");
			throw e;
		}
		G oExit = miQueue.obtener(0);
		miQueue.eliminar(0);
		if(miQueue.tamanio()!=0) 
			setPrimero(miQueue.obtener(0));
		if(miQueue.tamanio()==0) {
			setPrimero(null);
			setUltimo(null);
		}
		return oExit;
	}

	@Override
	public G dequeueRight() throws EmptyQueueException {
		if(miQueue.tamanio() == 0) {
			EmptyQueueException e = new EmptyQueueException("La cola esta vacia.");
			throw e;
		}
		G oExit = miQueue.obtener(miQueue.tamanio()-1);
		miQueue.eliminar(miQueue.tamanio() -1);
		if(miQueue.tamanio()!=0)
			setUltimo(miQueue.obtener(miQueue.tamanio() -1));
		if(miQueue.tamanio() == 0) {
			setUltimo(null);
			setPrimero(null);
		}
		return oExit;
	}

	public G getPrimero() {
		return primero;
	}

	private void setPrimero(G primero) {
		this.primero = primero;
	}

	public G getUltimo() {
		return ultimo;
	}

	private void setUltimo(G ultimo) {
		this.ultimo = ultimo;
	}
	
}
