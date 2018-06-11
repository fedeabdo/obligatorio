package uy.edu.um.prog2.adt.Hash;

import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.MiListaEnlazada;

import java.util.Iterator;

import uy.edu.um.prog2.adt.Hash.Exceptions.ClaveInvalida;

public interface HashTableAbierto<K, T> {
	public void insertar(K clave, T valor) throws ElementoYaExistenteException;

	public boolean pertenece(K clave);

	public void borrar(K clave) throws ClaveInvalida;

	public MiListaEnlazada<NodoHash<K,T>> obtener(K key);
	
	public Iterator<MiListaEnlazada<NodoHash<K, T>>> iterator();
}
