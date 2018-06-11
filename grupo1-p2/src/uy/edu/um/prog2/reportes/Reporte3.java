package uy.edu.um.prog2.reportes;

import java.util.Iterator;

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

public class Reporte3 {
	private FileToObjects ofile;

	public Reporte3(FileToObjects ofile) {
		this.ofile = ofile;
	}

	public void reportar() {
		HashTable<String, Producto> productos = ofile.getProductos();
		Iterator<Producto> objProductos = productos.iterator();
		Producto oP;
		Pais pais;
		HashTableAbierto<Pais, Producto> hashProductoDePaisesHAB = new HashAbierto<>(1000);
		HashTableAbierto<Pais, Producto> hashProductoDePaises = new HashAbierto<>(1000);
		while (objProductos.hasNext()) {
			oP = objProductos.next();
			pais = oP.getPais();
			if (oP.getEstado().equals("HABILITADO")) {
				try {
					hashProductoDePaisesHAB.insertar(pais, oP);
				} catch (ElementoYaExistenteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				hashProductoDePaises.insertar(pais, oP);
			} catch (ElementoYaExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Iterator<MiListaEnlazada<NodoHash<Pais, Producto>>> iteratorHashHAB = hashProductoDePaisesHAB.iterator();
		Iterator<MiListaEnlazada<NodoHash<Pais, Producto>>> iteratorHash = hashProductoDePaises.iterator();
		MyPriorityQueue<Pais> queuePaises = new Queue<>();
		MiListaEnlazada<NodoHash<Pais, Producto>> lista = null;
		Pais oPaisProdHab = null;
		Pais oPais = null;
		while (iteratorHash.hasNext()) {
			lista = iteratorHash.next();
			try {
				oPais = lista.obtener(0).getClave();
				oPais.setCantProd(lista.tamanio());
			} catch (PosicionInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (iteratorHashHAB.hasNext()) {
			lista = iteratorHashHAB.next();
			try {
				oPaisProdHab = lista.obtener(0).getClave();
				oPaisProdHab.setCantProdHabilitados(lista.tamanio());
				queuePaises.insert(oPaisProdHab, oPaisProdHab.getCantProdHabilitados());
			} catch (PosicionInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			try {
				oPais = queuePaises.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Pais:\t" + oPais.getNombre() + ".\n   *Cantidad productos habilitados:	"
					+ oPais.getCantProdHabilitados() + ".\n   *% del total:	"
					+ oPais.getCantProdHabilitados() * 100 / oPais.getCantProd() + " %.");
		}

	}
}
