package uy.edu.um.prog2;

public class Marca {
	private String nombre;
	private int cantProductos;

	public Marca(String nombre) {
		this.nombre = nombre;
		cantProductos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void agregarProductoHabilitado() {
		cantProductos++;
	}

	public int getCantProductos() {
		return cantProductos;
	}
	
	

}
