package uy.edu.um.prog2.adt.Hash.Iterator;

import java.util.Iterator;

import uy.edu.um.prog2.adt.Hash.NodoHash;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.MiListaEnlazada;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;

public class MyIteratorHashAbierto<K, T> implements Iterator<MiListaEnlazada<NodoHash<K, T>>>  {
	private MiListaEnlazada<NodoHash<K, T>>[] vector;
	private int posicion = 0;

	public MyIteratorHashAbierto(MiListaEnlazada<NodoHash<K, T>>[] vector2) {
		this.vector = vector2;

		try {
			while (vector2[posicion] == null || vector2[posicion].obtener(0).isEliminado()) {
				posicion++;
			}
		} catch (PosicionInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e2) {
			e2.printStackTrace();
		}
	}

	public boolean hasNext() {
		boolean hasNext = false;
		int posAux = posicion;
		while (!hasNext && posAux < vector.length) {
			try {
				if (vector[posAux] != null && !vector[posAux].obtener(0).isEliminado()) {
					hasNext = true;
				}
			} catch (PosicionInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			posAux++;
		}
		return hasNext;
	}

	public MiListaEnlazada<NodoHash<K, T>> next() {
		MiListaEnlazada<NodoHash<K, T>> next=null;
		int posAux = posicion;
		while (next==null && posAux < vector.length) {
			if (vector[posAux] != null) {
				next=vector[posAux];
			}
			posAux++;
		}
		posicion=posAux;
		return next;
	}

}