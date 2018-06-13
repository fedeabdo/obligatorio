package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.FileToObjects.Pais;

public class PaisAUX {
	private Pais oPais;
	private int cantProductosHab;

	public PaisAUX(Pais oPais) {
		this.oPais = oPais;
		cantProductosHab = 0;
	}

	public Pais getoPais() {
		return oPais;
	}

	public int getCantProductosHab() {
		return cantProductosHab;
	}

	public void agregarProductoHab() {
		cantProductosHab++;
	}

}
