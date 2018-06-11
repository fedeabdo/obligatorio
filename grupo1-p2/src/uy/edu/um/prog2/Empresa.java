package uy.edu.um.prog2;

public class Empresa {
	private String nombre;
	private Long ruc;
	
	public Empresa(String nombre, Long ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public Long getRuc() {
		return ruc;
	}
	
	public boolean equals(Empresa e) {
		boolean equal=false;
		if(this.ruc.equals(e.getRuc())) {
			equal=true;
		}
		return equal;
	}
	 
}
