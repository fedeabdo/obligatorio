package uy.edu.um.prog2.reportes;

import java.util.Iterator;

import uy.edu.um.prog2.Clase;
import uy.edu.um.prog2.FileToObjects;
import uy.edu.um.prog2.Pais;
import uy.edu.um.prog2.Producto;
import uy.edu.um.prog2.adt.Hash.HashAbierto;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Hash.HashTableAbierto;
import uy.edu.um.prog2.adt.Hash.NodoHash;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.MiListaEnlazada;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.MyPriorityQueue;
import uy.edu.um.prog2.adt.Queue.Queue;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class Reporte4 {
	private FileToObjects ofile;

	public Reporte4(FileToObjects ofile) {
		this.ofile = ofile;
	}

	public void reportar() {
		HashTable<String, Producto> productos = ofile.getProductos();
		Iterator<Producto> objProductos = productos.iterator();
		Producto oP;
		Pais pais = null;
		Clase clase = null;
		HashTableAbierto<Pais, Clase> hashProductoHAB = new HashAbierto<>(1000);
		while (objProductos.hasNext()) {
			oP = objProductos.next();
			pais = oP.getPais();
			clase = oP.getClase();
			if (oP.getEstado().equals("HABILITADO")) {
				try {
					hashProductoHAB.insertar(pais, clase);
				} catch (ElementoYaExistenteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		Iterator<MiListaEnlazada<NodoHash<Pais, Clase>>> iteratorHashHAB = hashProductoHAB.iterator();
		MyPriorityQueue<Clase> queueClasesPorPaises = new Queue<>();
		MiListaEnlazada<NodoHash<Pais, Clase>> lista = null;
		MyPriorityQueue<Pais> queuePaisDeClase = new Queue<>();
		Clase clasesPorPaises = null;
		Pais paisDeClase = null;
		while (iteratorHashHAB.hasNext()) {
			lista = iteratorHashHAB.next();
			try {
				clasesPorPaises = lista.obtener(0).getValor();		//ANDA MAL. NO TIENE SENTIDO. UN PAIS TIENE MUHCAS CLASES
				paisDeClase = lista.obtener(0).getClave();
				clasesPorPaises.setCantProdHab(lista.tamanio());
				queueClasesPorPaises.insert(clasesPorPaises, clasesPorPaises.getCantProdHab());
				queuePaisDeClase.insert(paisDeClase, clasesPorPaises.getCantProdHab());
			} catch (PosicionInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 20; i++) {
			try {
				clase = queueClasesPorPaises.dequeue();
				pais = queuePaisDeClase.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Clase:\t" + clase.getNombre() + ".\n   *Pais:	" + pais.getNombre()
					+ ".\n   *Cantidad de productos habilitados:	" + clase.getCantProdHab() + ".");
		}

	}
}
