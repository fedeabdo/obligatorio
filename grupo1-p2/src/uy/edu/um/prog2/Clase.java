package uy.edu.um.prog2;

public class Clase {
	private String nombre;
	private int idClase;
	private int cantProdHab;

	public Clase(int idClase, String nombre) {
		this.nombre = nombre;
		this.idClase = idClase;
		cantProdHab = 0;
	}
	

	public int getCantProdHab() {
		return cantProdHab;
	}


	public void setCantProdHab(int cantProdHab) {
		this.cantProdHab = cantProdHab;
	}


	public String getNombre() {
		return nombre;
	}


	public int getIdClase() {
		return idClase;
	}

	
	
}
