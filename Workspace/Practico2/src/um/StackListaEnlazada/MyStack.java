package um.StackListaEnlazada;
import um.Exceptions.EmptyStackException;

public interface MyStack<G>  {
	
	public void pop () throws EmptyStackException;
	public G top() throws EmptyStackException;
	public void push(G element);
	public boolean isEmpty ();
	public void makeEmpty();
}