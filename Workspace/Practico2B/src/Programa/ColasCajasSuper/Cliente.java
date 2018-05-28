package Programa.ColasCajasSuper;

public class Cliente {
	private int nCantProductos;
	
	public Cliente(int nCantProductos) {
		this.nCantProductos = nCantProductos;
	}

	public int getnCantProductos() {
		return nCantProductos;
	}

	public void setnCantProductos(int nCantProductos) {
		this.nCantProductos = nCantProductos;
	}

}
