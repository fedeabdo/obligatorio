package uy.edu.um.prog2.adt.Hash;

import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
//import uy.edu.um.prog2.adt.Hash.Iterator.MyIterator;
import uy.edu.um.prog2.adt.Hash.Iterator.MyIteratorHashAbierto;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.ListaEnlazadaSimple;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.MiListaEnlazada;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;

import static java.lang.Math.abs;

import java.util.Iterator;

import uy.edu.um.prog2.adt.Hash.Exceptions.ClaveInvalida;

public class HashAbierto<K, T> implements HashTableAbierto<K, T> {
	private MiListaEnlazada<NodoHash<K, T>>[] vector;
	private int size;
	private int cantElementos;

	@SuppressWarnings("unchecked")
	public HashAbierto(int sizeInicial) {
		vector = new ListaEnlazadaSimple[sizeInicial];
		size = sizeInicial;
		cantElementos = 0;
	}

	public void insertar(K clave, T valor) throws ElementoYaExistenteException {
		NodoHash<K, T> nuevoNodo = new NodoHash<>(clave, valor);
		if ((float) cantElementos / size > 0.8) {
			agrandarHash();
		}
		int posicion = abs(clave.hashCode() % size);
		if (vector[posicion] == null) {
			MiListaEnlazada<NodoHash<K, T>> listaT = new ListaEnlazadaSimple<>();
			listaT.agregar(nuevoNodo);
			vector[posicion] = listaT;
		} else {
			// else {
			// if (vector[posicion] != null) {
			// for(int i = 0; i<vector[posicion].tamanio(); i++) {
			// if(vector[posicion].obtener(i).equals(nuevoNodo)) {
			// throw new ElementoYaExistenteException("Este elemento ya existe.");
			// }
			//
			// }
			vector[posicion].agregar(nuevoNodo);
		}
		// }
		cantElementos++;
	}

	public boolean pertenece(K clave) {
		boolean pertenece = false;
		int posEsperada = abs(clave.hashCode() % size);
		if (vector[posEsperada] != null) {
			try {
				if (vector[posEsperada].obtener(0).getClave().equals(clave)
						&& vector[posEsperada].obtener(0).isEliminado() == false) {
					pertenece = true;
				}
			} catch (PosicionInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pertenece;
	}

	public void borrar(K clave) throws ClaveInvalida {
		if (pertenece(clave)) {
			try {
				int t = get(clave).tamanio();
				for (int i = 0; i < t; i++) {
					get(clave).obtener(i).setEliminado(true);
				}
			} catch (PosicionInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cantElementos--;
		} else {
			throw new ClaveInvalida("Clave invalida.");
		}
	}

	private void agrandarHash() {
		int nuevoSize = 2 * size;
		@SuppressWarnings("unchecked")
		MiListaEnlazada<NodoHash<K, T>>[] vectorNuevo = new ListaEnlazadaSimple[nuevoSize];
		for (int i = 0; i < size; i++) {
			if (vector[i] != null) {
				K claveAux = null;
				try {
					claveAux = vector[i].obtener(0).getClave();
				} catch (PosicionInvalida e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int posicion = abs(claveAux.hashCode() % nuevoSize);
				if (vectorNuevo[posicion] == null) {
					vectorNuevo[posicion] = vector[i];
				}
			}
		}
		size = nuevoSize;
		vector = vectorNuevo;
	}

	private MiListaEnlazada<NodoHash<K, T>> get(K clave) {
		MiListaEnlazada<NodoHash<K, T>> listaT = null;
		int posEsperada = abs(clave.hashCode() % size);
		try {
			if (vector[posEsperada].obtener(0).getClave().equals(clave)
					&& vector[posEsperada].obtener(0).isEliminado() == false) {
				listaT = vector[posEsperada];
			}
		} catch (PosicionInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaT;
	}

	// public T obtener(K clave) {
	// NodoHash<K, T> nodo = null;
	// T valor = null;
	// int posEsperada = clave.hashCode() % size;
	// if(vector[posEsperada]==null) {
	// valor = null;
	// }else
	// if (vector[posEsperada].getClave().equals(clave) &&
	// vector[posEsperada].isEliminado() == false) {
	// nodo = vector[posEsperada];
	// } else {
	// if (resolucionLineal) {
	// posEsperada++;
	// while (posEsperada < vector.length
	// && (vector[posEsperada] != null &&
	// !vector[posEsperada].getClave().equals(clave))) {
	// posEsperada++;
	// }
	// } else {
	// int cuadratica = 1;
	// while (posEsperada < vector.length
	// && (vector[posEsperada] != null &&
	// !vector[posEsperada].getClave().equals(clave))) {
	// posEsperada = posEsperada + cuadratica * cuadratica;
	// while (posEsperada >= size) {
	// posEsperada = posEsperada - size;
	// }
	// }
	// }
	// if (vector[posEsperada]!=null && vector[posEsperada].getClave().equals(clave)
	// && vector[posEsperada].isEliminado() == false) {
	// nodo = vector[posEsperada];
	// }
	// }
	// valor = nodo==null ? null : nodo.getValor();
	// return valor;
	// }
	public MiListaEnlazada<NodoHash<K, T>> obtener(K key) {
		MiListaEnlazada<NodoHash<K, T>> valor = null;
		int posEsperada = abs(key.hashCode() % size);
		if (vector[posEsperada] != null) {
			try {
				for (int i = 0; i < vector[posEsperada].tamanio(); i++) {
					if (vector[posEsperada].obtener(i).getClave().equals(key)
							&& vector[posEsperada].obtener(0).isEliminado() == false) {
						valor = vector[posEsperada];
					}
				}
			} catch (PosicionInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valor;
	}

	public Iterator<MiListaEnlazada<NodoHash<K, T>>> iterator() {
		return new MyIteratorHashAbierto<K, T>(vector);
	}

}
