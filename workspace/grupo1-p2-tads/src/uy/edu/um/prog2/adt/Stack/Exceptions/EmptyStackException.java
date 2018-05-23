package uy.edu.um.prog2.adt.Stack.Exceptions;

@SuppressWarnings("serial")
public class EmptyStackException extends Exception {
	public EmptyStackException(String msg) {
		super(msg);
	}
}
