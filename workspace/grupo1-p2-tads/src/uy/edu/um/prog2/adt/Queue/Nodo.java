package uy.edu.um.prog2.adt.Queue;

public class Nodo<G> {
	private G value;
	private int piority;
	private Nodo<G> next;
	private Nodo<G> before;
	
	public Nodo(G value) {
		this.value = value;
		piority = 1;
	}
	public Nodo(G value, int piority) {
		this.value = value;
		this.piority = piority;
	}
	public int getPiority() {
		return piority;
	}
	public void setPiority(int piority) {
		this.piority = piority;
	}
	public G getValue() {
		return value;
	}
	public Nodo<G> getBefore() {
		return before;
	}
	public void setBefore(Nodo<G> before) {
		this.before = before;
	}
	public Nodo<G> getNext() {
		return next;
	}
	public void setNext(Nodo<G> next) {
		this.next = next;
	}
	
}
