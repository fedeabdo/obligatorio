package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.FileToObjects.Empresa;

public class EmpresaAUX {
	private Empresa oEmpresa;
	private int cantProductosHab;
	
	public EmpresaAUX(Empresa oEmpresa) {
		super();
		this.oEmpresa = oEmpresa;
		this.cantProductosHab = 0;
	}

	public Empresa getoEmpresa() {
		return oEmpresa;
	}

	public void setoEmpresa(Empresa oEmpresa) {
		this.oEmpresa = oEmpresa;
	}

	public int getCantProductosHab() {
		return cantProductosHab;
	}

	public void agregarProductoHab() {
		cantProductosHab++;
	}
	
	

}
