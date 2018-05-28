package uy;

public interface MiListaEnlazada<G> {
	void agregar(G i);
	void eliminar(int i);
	G obtener(int i);
	int tamanio();
}
