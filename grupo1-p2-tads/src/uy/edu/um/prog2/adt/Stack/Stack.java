package uy.edu.um.prog2.adt.Stack;
import uy.edu.um.prog2.adt.Stack.Exceptions.EmptyStackException;

public class Stack<G> implements MyStack<G>{
	private Nodo<G> ultimo;
	
	public void pop() throws EmptyStackException {
		if(ultimo==null) {
			EmptyStackException e = new EmptyStackException("El stack esta vacio.");
			throw e;
		}
		Nodo<G> oTemp  = ultimo;
		ultimo=ultimo.getBefore();
		oTemp.setBefore(null);
		if (ultimo != null)
			ultimo.setNext(null);
	}

	public G top() throws EmptyStackException {
		if (ultimo == null) {
			EmptyStackException e = new EmptyStackException("El stack esta vacio.");
			throw e;
		}
		G oExit = ultimo.getObj();
		return oExit;
	}

	public void push(G element) {
		Nodo<G> oNodo = new Nodo<>(element);
		if(ultimo == null) {
			ultimo = oNodo;
		}else {
			Nodo<G> oTemp = ultimo;
			oTemp.setNext(oNodo);
			oNodo.setBefore(oTemp);
			ultimo = oNodo;
		}
	}

	public boolean isEmpty() {
		boolean bExit = false;
		if(ultimo == null) {
			bExit = true;
		}
		return bExit;
	}
	
	@Override
	public void makeEmpty() {
		Nodo<G> oTemp0 = ultimo;
		while(oTemp0 != null) {
			oTemp0=ultimo.getBefore();
			ultimo.setBefore(null);
			ultimo.setNext(null);
			ultimo = oTemp0;
		}
	}
	
	public int size(){
		int nExit = 0;
		if(ultimo!=null) {
			Nodo<G> oTemp = ultimo;
			if(ultimo.getBefore() == null) {
				nExit = 1;
			}else {
				nExit=1;
				while( oTemp.getBefore() != null ) {
					oTemp = oTemp.getBefore();
					nExit++;
				}
			}
		}
		return nExit;
	}
	

}
