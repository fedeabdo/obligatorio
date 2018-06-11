package uy.edu.um.prog2.FileToObjects;

public class Clase {
	private String nombre;
	private int idClase;

	public Clase(int idClase, String nombre) {
		this.nombre = nombre;
		this.idClase = idClase;
	}

	public String getNombre() {
		return nombre;
	}


	public int getIdClase() {
		return idClase;
	}

	@Override
	public int hashCode() {
		int result = (nombre + idClase).hashCode();
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
		Clase other = (Clase) obj;
		if (idClase != other.idClase)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}



	
	
}
