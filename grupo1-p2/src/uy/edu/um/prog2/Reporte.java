package uy.edu.um.prog2;

import java.io.FileNotFoundException;
import java.io.IOException;

import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.*;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;
import uy.edu.um.prog2.reportes.Reporte1;

public class Reporte {
	private FileToObjects file;

	public Reporte(String nombreDelArchivo) throws InvalidFile {
		file = new FileToObjects();
		try {
			file.loadFiles(nombreDelArchivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public void reporte1() {
//		HashTable<Long, Empresa> listaEmpresas = file.getEmpresas();
//		MyPiorityQueue<Empresa> EmpresaOrdenadaCantProductos = new Queue<>();
//		Empresa oEmpresa = null;
//		for (int i = 0; i < listaEmpresas.tamanio(); i++) {
//			try {
//				oEmpresa = listaEmpresas.obtener(i);
//			} catch (PosicionInvalida e) {
//				e.printStackTrace();
//			}
//			EmpresaOrdenadaCantProductos.insert(oEmpresa, oEmpresa.getCantProductos());
//		}
//		for (int i = 0; i < listaEmpresas.tamanio(); i++) {
//			try {
//				oEmpresa = EmpresaOrdenadaCantProductos.dequeue();
//			} catch (EmptyQueueException e) {
//				e.printStackTrace();
//			}
//			System.out.println(oEmpresa.getNombre() + " " + oEmpresa.getCantProductos());
//		}
//	}

	public void reporte1() {
		HashTable<Long, Reporte1> hashEmpresas = recorrerHashReporte1();
		/*
		 * Recorrer Hash de empresas y poner cada empresa en una queue ordenada por prioridad segun la cantidad de elementos.
		 * Con un for recorrer los primeros 20 elementos de la queue e imprimir.
		 */
	}

	public void reporte2() {

		// for(in)
	}

	// public void reporte3() {
	// MiListaEnlazada<Pais> listaPaises = file.getPaises();
	// MyPiorityQueue<Pais> paisOrdenadoCantProductosH = new Queue<>();
	// Pais oPais=null;
	// for (int i = 0; i < listaPaises.tamanio(); i++) {
	// try {
	// oPais = listaPaises.obtener(i);
	// } catch (PosicionInvalida e) {
	// e.printStackTrace();
	// }
	// paisOrdenadoCantProductosH.insert(oPais,
	// oPais.getCantProductosHabilitados());
	// }
	// for (int i = 0; i < listaPaises.tamanio(); i++) {
	// try {
	// oPais=paisOrdenadoCantProductosH.dequeue();
	// } catch (EmptyQueueException e) {
	// e.printStackTrace();
	// }
	// System.out.println(oPais.getNombre() + " " +
	// oPais.getCantProductosHabilitados() + " " +
	// oPais.getPorcentajeProductos(file.getCantProductos()));
	// }
	// }

	public void reporte4() {

	}

	private HashTable<Long, Reporte1> recorrerHashReporte1() {
		/*
		 * Poner todas las empresas en un hash de Reportes1. Recorrer hash de productos,
		 * ver si el producto es != null y si esta habiltado y si si, obtener su empresa
		 * y sumarle uno a la cantidad de prod de esa empresa.
		 */
		return null;
	}

}
