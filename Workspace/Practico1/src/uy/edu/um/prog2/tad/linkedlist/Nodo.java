package uy.edu.um.prog2.tad.linkedlist;

public class Nodo {
	
	private Nodo proximo;
	private Nodo anterior;
	private int valor;
	
	public Nodo(int valor) {
		this.valor = valor;
	}

	public Nodo getProximo() {
		return proximo;
	}

	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	
	
	
}
