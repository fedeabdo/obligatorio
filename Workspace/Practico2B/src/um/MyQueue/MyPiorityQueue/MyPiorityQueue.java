package um.MyQueue.MyPiorityQueue;

import um.MyQueue.MyQueueConListaEnlazada;

public interface MyPiorityQueue<G> extends MyQueueConListaEnlazada<G> {
	public void insert(G element, int pioridad);
}
