package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;

public class Pais {
	private String nombre;
	private MiListaEnlazada<Marca> marcas;

	public Pais(String nombre) {
		this.nombre = nombre;
		marcas = new ListaEnlazadaSimple<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void agregarMarca(Marca oMarca) {
		if (marcas.esta(oMarca) == null) {
			marcas.agregar(oMarca);
		}
	}

	public int getCantProductosHabilitados() {
		int cantidad = 0;
		for (int i = 0; i < marcas.tamanio(); i++) {
			try {
				cantidad = cantidad + marcas.obtener(i).getCantProductos();
			} catch (PosicionInvalida e) {
				e.printStackTrace();
			}
		}
		return cantidad;
	}

	public int getPorcentajeProductos(int total) {
		return getCantProductosHabilitados() / total * 100;
	}

}
