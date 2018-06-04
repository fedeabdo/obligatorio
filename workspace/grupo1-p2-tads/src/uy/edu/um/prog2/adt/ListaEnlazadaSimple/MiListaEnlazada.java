package uy.edu.um.prog2.adt.ListaEnlazadaSimple;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;

public interface MiListaEnlazada<G> {
	void agregar(G i);
	void eliminar(int i);
	G obtener(int i) throws PosicionInvalida;
	int tamanio();
	G esta(G obj);
}
