package um.MyQueue;

import Exceptions.EmptyQueueException;

public interface  MyDoubleQueue<G>{
	void enqueueLeft(G oTemp);
	void enqueueRight(G oTemp);
	G dequeueLeft() throws EmptyQueueException;
	G dequeueRight() throws EmptyQueueException;
}
