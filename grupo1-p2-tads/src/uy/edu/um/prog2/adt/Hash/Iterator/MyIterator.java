package uy.edu.um.prog2.adt.Hash.Iterator;

import java.util.Iterator;

import uy.edu.um.prog2.adt.Hash.NodoHash;

public class MyIterator<K, T> implements Iterator<T> {
	private NodoHash<K, T>[] vector;
	private int posicion = 0;

	public MyIterator(NodoHash[] vector) {
		this.vector = vector;

		while (vector[posicion] == null || vector[posicion].isEliminado()) {
			posicion++;
		}
	}

	public boolean hasNext() {
		boolean hasNext = false;
		int posAux = posicion;
		while (!hasNext && posAux < vector.length) {
			if (vector[posAux] != null && !vector[posAux].isEliminado()) {
				hasNext = true;
			}
			posAux++;
		}
		return hasNext;
	}

	public T next() {
		T next=null;
		int posAux = posicion;
		while (next==null && posAux < vector.length) {
			if (vector[posAux] != null && !vector[posAux].isEliminado()) {
				next=vector[posAux].getValor();
			}
			posAux++;
		}
		posicion=posAux;
		return next;
	}

}
