package uy.edu.um.prog2.adt.Queue;

import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public interface MyQueueConListaEnlazada<G> {
	void enqueue (G element);
	G dequeue () throws EmptyQueueException;
	boolean isEmpty();
	G getFirst () throws EmptyQueueException;
}
