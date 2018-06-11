package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.*;
import uy.edu.um.prog2.adt.Hash.*;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;

public class Reporte2 {
	private Marca oMarca;
	private HashTable<String, Reporte3> hashRep3;

	public Reporte2(Marca oMarca) {
		this.oMarca = oMarca;
		hashRep3 = new HashCerrado<String, Reporte3>(100, true);
	}

	public Pais getoPais(String pais) {
		return hashRep3.obtener(pais).getoPais();
	}

	public void agregarPaisYProductoHabilitado(Pais oPais) {
		String nombrePais = oPais.getNombre();
		try {
			Reporte3 rep3 = new Reporte3(oPais);
			hashRep3.insertar(nombrePais, rep3);
			rep3.agregarProductoHAB();
		} catch (ElementoYaExistenteException e) {
			hashRep3.obtener(nombrePais).agregarProductoHAB();
		}
	}

	public Marca getoMarca() {
		return oMarca;
	}

	public int getCantidadProductosHabilitados(Pais oPais) {
		return hashRep3.obtener(oPais.getNombre()).getnProductosHAB();
	}
	
	public HashTable<String, Reporte3> getHashPaises() {
		return hashRep3;
	}
}
