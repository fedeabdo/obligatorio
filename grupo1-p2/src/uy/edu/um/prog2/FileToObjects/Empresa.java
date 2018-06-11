package uy.edu.um.prog2.FileToObjects;

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
	
	@Override
	public int hashCode() {
		int result = nombre.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	

	
}
