package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.FileToObjects.Empresa;

public class EmpresaAUX {
	private Empresa oEmpresa;
	private int cantidadProductosHabilitados;
	
	public EmpresaAUX(Empresa oEmpresa) {
		super();
		this.oEmpresa = oEmpresa;
		this.cantidadProductosHabilitados = 0;
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

	public void agregarProducto() {
		cantidadProductosHabilitados++;
	}
	
	

}
