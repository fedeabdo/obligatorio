package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.FileToObjects.Marca;
import uy.edu.um.prog2.FileToObjects.Pais;
import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;

public class MarcaAUX {
	private Marca oMarca;
	private HashTable<String, PaisAUX> hashRep3;

	public MarcaAUX(Marca oMarca) {
		this.oMarca = oMarca;
		hashRep3 = new HashCerrado<String, PaisAUX>(100, true);
	}

	public Pais getoPais(String pais) {
		return hashRep3.obtener(pais).getoPais();
	}

	public void agregarPaisYProductoHabilitado(Pais oPais) {
		String nombrePais = oPais.getNombre();
		try {
			PaisAUX rep3 = new PaisAUX(oPais);
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
	
	public HashTable<String, PaisAUX> getHashPaises() {
		return hashRep3;
	}
}
