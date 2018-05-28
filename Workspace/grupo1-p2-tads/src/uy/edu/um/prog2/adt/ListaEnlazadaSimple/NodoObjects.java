package uy.edu.um.prog2.adt.ListaEnlazadaSimple;

public class NodoObjects<G> {
	
	private NodoObjects<G> proximo;
	private NodoObjects<G> anterior;
	private G obj;
	
	public NodoObjects(G obj) {
		this.obj = obj;
	}

	public NodoObjects<G> getProximo() {
		return proximo;
	}

	public void setProximo(NodoObjects<G> proximo) {
		this.proximo = proximo;
	}

	public G getObjeto() {
		return obj;
	}

	public void setValor(G obj) {
		this.obj = obj;
	}

	public NodoObjects<G> getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoObjects<G> anterior) {
		this.anterior = anterior;
	}	
}
