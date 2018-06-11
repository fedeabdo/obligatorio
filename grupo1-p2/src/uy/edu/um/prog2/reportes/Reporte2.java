package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.*;

public class Reporte2 {
	private Marca oMarca;
	private Pais oPais;
	private int cantidadProductosHabilitados;
	
	public Pais getoPais() {
		return oPais;
	}

	public void setoPais(Pais oPais) {
		this.oPais = oPais;
	}


	public Reporte2(Marca oMarca) {
		this.oMarca = oMarca;
	}

	public Marca getoMarca() {
		return oMarca;
	}

	public int getCantidadProductosHabilitados() {
		return cantidadProductosHabilitados;
	}
	
	public void addProductoHabilitado() {
		cantidadProductosHabilitados++;
	}
}
