package um.StackListaEnlazada;

public class Nodo <G>{
	private Nodo<G> next;
	private Nodo<G> before;
	private G obj;
	
	public Nodo(G obj) {
		this.obj = obj;
	}
	
	public Nodo<G> getNext() {
		return next;
	}
	public void setNext(Nodo<G> next) {
		this.next = next;
	}
	public Nodo<G> getBefore() {
		return before;
	}
	public void setBefore(Nodo<G> before) {
		this.before = before;
	}
	public G getObj() {
		return obj;
	}
	
}

