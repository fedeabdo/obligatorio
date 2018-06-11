package uy.edu.um.prog2.reportes;

import java.io.IOException;
import java.util.Iterator;

import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.FileToObjects.Clase;
import uy.edu.um.prog2.FileToObjects.Empresa;
import uy.edu.um.prog2.FileToObjects.FileToObjects;
import uy.edu.um.prog2.FileToObjects.Marca;
import uy.edu.um.prog2.FileToObjects.Pais;
import uy.edu.um.prog2.FileToObjects.Producto;
import uy.edu.um.prog2.adt.Hash.*;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Queue.*;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

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

	public void reporte1() {
		HashTable<Long, EmpresaAUX> hashEmpresas = recorrerHashReporte1();
		Iterator<EmpresaAUX> itEmpresas = hashEmpresas.iterator();
		MyPriorityQueue<EmpresaAUX> queue = new Queue<>();
		while (itEmpresas.hasNext()) {
			EmpresaAUX reporte = itEmpresas.next();
			queue.insert(reporte, reporte.getCantidadProductosHabilitados());
		}
		EmpresaAUX rep1 = null;
		System.out.printf("%-5s%-2s%-50s%-2s%-20s\n", "", "|", "Empresa", "|", "Cantidad de productos habilitados");
		System.out.printf("%-5s%-2s%-50s%-2s%-20s\n", "----", "|", "-------------------------------------------------",
				"|", "-----------------------------------");
		for (int i = 0; i < 20; i++) {
			try {
				rep1 = queue.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			int cantProd = rep1.getCantidadProductosHabilitados();
			Empresa oEmpresa = rep1.getoEmpresa();
			System.out.printf("%-5s%-2s%-50s%-2s%-20s\n", i + 1, "|", oEmpresa.getNombre(), "|", cantProd);
		}
	}

	public void reporte2() {
		HashTable<String, MarcaAUX> hashReporte2 = recorrerHashReporte2();
		Iterator<MarcaAUX> itRep2 = hashReporte2.iterator();
		MyPriorityQueue<MarcaAUX> queueRep2 = new Queue<>();
		MyPriorityQueue<Pais> queuePaises = new Queue<>();
		MarcaAUX rep2 = null;
		Iterator<PaisAUX> itRep3;
		PaisAUX rep3;
		while (itRep2.hasNext()) {
			rep2 = (MarcaAUX) itRep2.next();
			itRep3 = rep2.getHashPaises().iterator();
			while (itRep3.hasNext()) {
				rep3 = itRep3.next();
				queueRep2.insert(rep2, rep3.getnProductosHAB());
				queuePaises.insert(rep3.getoPais(), rep3.getnProductosHAB());
			}
		}
		int cantProd;
		System.out.printf("%-5s%-2s%-30s%-2s%-30s%-2s%-20s\n", "", "|", "Marca", "|", "Pais", "|",
				"Cantidad de productos habilitados");
		System.out.printf("%-5s%-2s%-30s%-2s%-30s%-2s%-20s\n", "----", "|", "-----------------------------", "|",
				"-----------------------------", "|", "-----------------------------------");
		Pais oPais = null;
		for (int i = 0; i < 10; i++) {
			try {
				rep2 = queueRep2.dequeue();
				oPais = queuePaises.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			cantProd = rep2.getCantidadProductosHabilitados(oPais);
			System.out.printf("%-5s%-2s%-30s%-2s%-30s%-2s%-20s\n", i + 1, "|", rep2.getoMarca().getNombre(), "|",
					oPais.getNombre(), "|", cantProd);
		}
	}

	public void reporte3() {
		int nProductosHabTotales = 0;
		HashTable<Pais, PaisAUX> hashRep3 = new HashCerrado<>(100, true);
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Pais> hashPaises = file.getPaises();
		Iterator<Pais> itPaises = hashPaises.iterator();
		Iterator<Producto> itProductos = hashProductos.iterator();
		Pais oPais = null;
		Producto oP = null;
		while (itPaises.hasNext()) {
			oPais = itPaises.next();
			try {
				hashRep3.insertar(oPais, new PaisAUX(oPais));
			} catch (ElementoYaExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (itProductos.hasNext()) {
			oP = itProductos.next();
			if (oP.getEstado().equals("HABILITADO")) {
				hashRep3.obtener(oP.getPais()).agregarProductoHAB();
				nProductosHabTotales++;
			}
		}
		MyPriorityQueue<PaisAUX> queueRep3 = new Queue<>();
		Iterator<PaisAUX> itRep3 = hashRep3.iterator();
		PaisAUX rep3 = null;
		while (itRep3.hasNext()) {
			rep3 = itRep3.next();
			queueRep3.insert(rep3, rep3.getnProductosHAB());
		}
		System.out.printf("%-5s%-2s%-40s%-2s%-35s%-2s%-30s\n", "", "|", "Pais", "|", "Cantidad productos habilitados",
				"|", "% del total");
		System.out.printf("%-5s%-2s%-40s%-2s%-35s%-2s%-30s\n", "----", "|", "---------------------------------------",
				"|", "----------------------------------", "|", "-----------------------------");
		for (int i = 0; i < 10; i++) {
			try {
				rep3 = queueRep3.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			System.out.printf("%-5s%-2s%-40s%-2s%-35s%-2s%-30s\n", i + 1, "|", rep3.getoPais().getNombre(), "|",
					rep3.getnProductosHAB(), "|", rep3.getnProductosHAB() * 100 / nProductosHabTotales + "%");
		}
	}

	public void reporte4() {
		HashTable<Clase, ClaseAUX> hashReporte4 = recorrerHashReporte4();
		Iterator<ClaseAUX> itClases = hashReporte4.iterator();
		Iterator<PaisAUX> itPaisesPClase = null;
		PaisAUX rep3 = null;
		MyPriorityQueue<Clase> queue = new Queue<>();
		MyPriorityQueue<PaisAUX>	queuePaises = new Queue<>();
		while (itClases.hasNext()) {
			ClaseAUX rep4 = itClases.next();
			itPaisesPClase = rep4.getHashPaises().iterator();
			while(itPaisesPClase.hasNext()) {
				rep3 = itPaisesPClase.next();
				queue.insert(rep4.getoClase(), rep3.getnProductosHAB());
				queuePaises.insert(rep3, rep3.getnProductosHAB());
				
			}
		}
		System.out.printf("%-5s%-2s%-108s%-2s%-40s%-2s%-20s\n", "", "|", "Clase", "|", "Pais", "|",
				"Cantidad de productos habilitados");
		System.out.printf("%-5s%-2s%-108s%-2s%-40s%-2s%-20s\n", "----", "|",
				"----------------------------------------------------------------------------------------------------------", "|", "---------------------------------------",
				"|", "-----------------------------------");
		Clase oClase = null;
		for (int i = 0; i < 20; i++) {
			try {
				oClase = queue.dequeue();
				rep3 = queuePaises.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			int cantProd = rep3.getnProductosHAB();
			System.out.printf("%-5s%-2s%-108s%-2s%-40s%-2s%-20s\n", i + 1, "|", oClase.getNombre(), "|",
					rep3.getoPais().getNombre(), "|", cantProd);
		}
	}

	private HashTable<Long, EmpresaAUX> recorrerHashReporte1() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<Long, Empresa> hashEmpresas = file.getEmpresas();
		HashTable<Long, EmpresaAUX> hashEmpresasReporte1 = new HashCerrado<>(1400, true);

		Iterator<Empresa> itEmpresas = hashEmpresas.iterator();
		while (itEmpresas.hasNext()) {
			Empresa oEmpresa = itEmpresas.next();
			EmpresaAUX rep = new EmpresaAUX(oEmpresa);
			try {
				hashEmpresasReporte1.insertar(oEmpresa.getRuc(), rep);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		while (itProductos.hasNext()) {
			Producto prod = itProductos.next();
			if (prod.getEstado().equals("HABILITADO")) {
				hashEmpresasReporte1.obtener(prod.getEmpresa().getRuc()).agregarProducto();
			}
		}

		return hashEmpresasReporte1;
	}

	private HashTable<String, MarcaAUX> recorrerHashReporte2() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Marca> hashMarcas = file.getMarcas();
		HashTable<String, MarcaAUX> hashMarcasReporte2 = new HashCerrado<>(6500, true);

		Iterator<Marca> itMarcas = hashMarcas.iterator();
		Marca oMarca = null;
		MarcaAUX rep;
		while (itMarcas.hasNext()) {
			oMarca = itMarcas.next();
			if (oMarca.getNombre() != null) {
				rep = new MarcaAUX(oMarca);
				try {
					hashMarcasReporte2.insertar(oMarca.getNombre(), rep);
				} catch (ElementoYaExistenteException e) {
					e.printStackTrace();
				}
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		Producto prod;
		MarcaAUX rep2;
		while (itProductos.hasNext()) {
			prod = itProductos.next();
			oMarca = prod.getMarca();
			if (prod.getEstado().equals("HABILITADO") && oMarca.getNombre() != null) {
				rep2 = hashMarcasReporte2.obtener(oMarca.getNombre());
				rep2.agregarPaisYProductoHabilitado(prod.getPais());
			}
		}
		return hashMarcasReporte2;

	}

	private HashTable<Clase, ClaseAUX> recorrerHashReporte4() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Clase> hashClases = file.getClases();
		HashTable<Clase, ClaseAUX> hashReporte4 = new HashCerrado<>(800, true);

		Iterator<Clase> itClases = hashClases.iterator();
		while (itClases.hasNext()) {
			Clase oClase = itClases.next();
			ClaseAUX rep4 = new ClaseAUX(oClase);
			try {
				hashReporte4.insertar(oClase, rep4);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		Producto prod;
		Clase oClase;
		while (itProductos.hasNext()) {
			prod = itProductos.next();
			oClase = (Clase) prod.getClase();
			if (prod.getEstado().equals("HABILITADO")) {
				hashReporte4.obtener(oClase).setHashPaises(prod.getPais());
			}
		}
		return hashReporte4;
	}

}
