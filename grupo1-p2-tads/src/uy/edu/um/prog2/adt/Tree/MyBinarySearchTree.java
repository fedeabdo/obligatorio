package uy.edu.um.prog2.adt.Tree;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Tree.Exceptions.InvalidKey;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;


public interface MyBinarySearchTree<K extends Comparable<K>, T> {
	T find(K key);

	void insert(K key, T data);

	void delete(K key) throws InvalidKey;

	MiListaEnlazada
	<T> inOrder();
}