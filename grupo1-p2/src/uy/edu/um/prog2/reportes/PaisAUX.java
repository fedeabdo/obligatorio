package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.FileToObjects.Pais;

public class PaisAUX {
	private Pais oPais;
	private int nProductosHAB;

	public PaisAUX(Pais oPais) {
		this.oPais = oPais;
		nProductosHAB = 0;
	}

	public Pais getoPais() {
		return oPais;
	}

	public int getnProductosHAB() {
		return nProductosHAB;
	}

	public void agregarProductoHAB() {
		nProductosHAB++;
	}

}
