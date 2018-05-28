package uy.edu.um.prog2.adt.Queue.Exceptions;

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
	
	public EmptyQueueException(String msg){
		super(msg);
	}
}
