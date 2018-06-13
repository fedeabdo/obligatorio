package uy.edu.um.prog2.reportes;

import uy.edu.um.prog2.FileToObjects.Clase;
import uy.edu.um.prog2.FileToObjects.Pais;
import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;

public class ClaseAUX {
	private Clase oClase;
	private HashTable<Pais, PaisAUX> hashPaises;
	
	public ClaseAUX(Clase oClase) {
		hashPaises = new HashCerrado<>(100, true);
		this.oClase=oClase;
	}

	public Clase getoClase() {
		return oClase;
	}

	public HashTable<Pais, PaisAUX> getHashPaises() {
		return hashPaises;
	}

	public void setHashPaises(Pais oPais) {
		try {
			PaisAUX rep3 = new PaisAUX(oPais);
			hashPaises.insertar(oPais, rep3);
			rep3.agregarProductoHab();
		} catch (ElementoYaExistenteException e) {
			hashPaises.obtener(oPais).agregarProductoHab();
		}
	}

}
