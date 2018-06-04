package uy.edu.um.prog2;

public class Empresa {
	private String nombre;
	private Long ruc;
	private int cantProductos;
	
	public Empresa(String nombre, Long ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
		cantProductos = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public Long getRuc() {
		return ruc;
	}
	public void agregarProducto() {
		cantProductos++;
	}
	
	public int getCantProductos() {
		return cantProductos;
	}
	public boolean equals(Empresa e) {
		boolean equal=false;
		if(this.ruc.equals(e.getRuc())) {
			equal=true;
		}
		return equal;
	}
	 
}
