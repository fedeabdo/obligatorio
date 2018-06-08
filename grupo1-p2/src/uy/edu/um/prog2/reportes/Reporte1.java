package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.Empresa;

public class Reporte1 {
	private Empresa oEmpresa;
	private int cantidadProductosHabilitados;
	
	public Reporte1(Empresa oEmpresa, int cantidadProductosHabilitados) {
		super();
		this.oEmpresa = oEmpresa;
		this.cantidadProductosHabilitados = cantidadProductosHabilitados;
	}

	public Empresa getoEmpresa() {
		return oEmpresa;
	}

	public void setoEmpresa(Empresa oEmpresa) {
		this.oEmpresa = oEmpresa;
	}

	public int getCantidadProductosHabilitados() {
		return cantidadProductosHabilitados;
	}

	public void setCantidadProductosHabilitados(int cantidadProductosHabilitados) {
		this.cantidadProductosHabilitados = cantidadProductosHabilitados;
	}
	
	

}
