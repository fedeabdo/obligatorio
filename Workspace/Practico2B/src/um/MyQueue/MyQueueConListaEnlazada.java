package um.MyQueue;

import Exceptions.EmptyQueueException;

public interface MyQueueConListaEnlazada<G> {
	void enqueue (G element);
	G dequeue () throws EmptyQueueException;
	boolean isEmpty();
	G getFirst () throws EmptyQueueException;
}
