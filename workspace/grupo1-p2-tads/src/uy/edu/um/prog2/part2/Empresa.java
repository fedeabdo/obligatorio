package uy.edu.um.prog2.part2;

public class Empresa {
	private String nombre;
	private String ruc;
	public Empresa(String nombre, String ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public String getRuc() {
		return ruc;
	}
	 
}
