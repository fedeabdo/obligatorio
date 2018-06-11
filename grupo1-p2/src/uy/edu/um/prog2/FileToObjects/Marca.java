package uy.edu.um.prog2.FileToObjects;

public class Marca {
	private String nombre;			

	public Marca(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
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
		Marca other = (Marca) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
