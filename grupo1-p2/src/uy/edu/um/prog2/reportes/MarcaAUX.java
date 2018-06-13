package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.FileToObjects.Marca;
import uy.edu.um.prog2.FileToObjects.Pais;
import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;

public class MarcaAUX {
	private Marca oMarca;
	private HashTable<String, PaisAUX> hashPaises;

	public MarcaAUX(Marca oMarca) {
		this.oMarca = oMarca;
		hashPaises = new HashCerrado<String, PaisAUX>(100, true);
	}

	public Pais getoPais(String pais) {
		return hashPaises.obtener(pais).getoPais();
	}

	public void agregarPaisYProductoHabilitado(Pais oPais) {
		String nombrePais = oPais.getNombre();
		try {
			PaisAUX oPaisAUX = new PaisAUX(oPais);
			hashPaises.insertar(nombrePais, oPaisAUX);
			oPaisAUX.agregarProductoHab();
		} catch (ElementoYaExistenteException e) {
			hashPaises.obtener(nombrePais).agregarProductoHab();
		}
	}

	public Marca getoMarca() {
		return oMarca;
	}

	public int getCantidadProductosHabilitados(Pais oPais) {
		return hashPaises.obtener(oPais.getNombre()).getCantProductosHab();
	}
	
	public HashTable<String, PaisAUX> getHashPaises() {
		return hashPaises;
	}
}
