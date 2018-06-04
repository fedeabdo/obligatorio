package uy.edu.um.prog2.adt.Hash;

import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Hash.Exceptions.ClaveInvalida;

public interface HashTable<K, T> {
	public void insertar(K clave, T valor) throws ElementoYaExistenteException;

	public boolean pertenece(K clave);

	public void borrar(K clave) throws ClaveInvalida;
}
