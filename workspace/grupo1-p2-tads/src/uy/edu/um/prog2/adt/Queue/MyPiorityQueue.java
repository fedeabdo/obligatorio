package uy.edu.um.prog2.adt.Queue;

public interface MyPiorityQueue<G> extends MyQueueConListaEnlazada<G> {
	public void insert(G element, int pioridad);
}
