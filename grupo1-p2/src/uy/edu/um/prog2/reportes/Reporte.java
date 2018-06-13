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
		EmpresaAUX oEmpresaAUX = null;
		while (itEmpresas.hasNext()) {
			oEmpresaAUX = itEmpresas.next();
			queue.insert(oEmpresaAUX, oEmpresaAUX.getCantProductosHab());
		}
		System.out.printf("%-5s%-2s%-50s%-2s%-20s\n", "", "|", "Empresa", "|", "Cantidad de productos habilitados");
		System.out.printf("%-5s%-2s%-50s%-2s%-20s\n", "----", "|", "-------------------------------------------------",
				"|", "-----------------------------------");
		int cantProd;
		Empresa oEmpresa;
		for (int i = 0; i < 20; i++) {
			try {
				oEmpresaAUX = queue.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			cantProd = oEmpresaAUX.getCantProductosHab();
			oEmpresa = oEmpresaAUX.getoEmpresa();
			System.out.printf("%-5s%-2s%-50s%-2s%-20s\n", i + 1, "|", oEmpresa.getNombre(), "|", cantProd);
		}
	}

	public void reporte2() {
		HashTable<String, MarcaAUX> hashMarcaAUX = recorrerHashReporte2();
		Iterator<MarcaAUX> itMarcaAUX = hashMarcaAUX.iterator();
		Iterator<PaisAUX> itPaisAUX;
		MyPriorityQueue<MarcaAUX> queueMarcaAUX = new Queue<>();
		MyPriorityQueue<Pais> queuePaises = new Queue<>();
		MarcaAUX oMarcaAUX = null;
		PaisAUX oPaisAUX = null;
		while (itMarcaAUX.hasNext()) {
			oMarcaAUX = (MarcaAUX) itMarcaAUX.next();
			itPaisAUX = oMarcaAUX.getHashPaises().iterator();
			while (itPaisAUX.hasNext()) {
				oPaisAUX = itPaisAUX.next();
				queueMarcaAUX.insert(oMarcaAUX, oPaisAUX.getCantProductosHab());
				queuePaises.insert(oPaisAUX.getoPais(), oPaisAUX.getCantProductosHab());
			}
		}
		System.out.printf("%-5s%-2s%-30s%-2s%-30s%-2s%-20s\n", "", "|", "Marca", "|", "Pais", "|",
				"Cantidad de productos habilitados");
		System.out.printf("%-5s%-2s%-30s%-2s%-30s%-2s%-20s\n", "----", "|", "-----------------------------", "|",
				"-----------------------------", "|", "-----------------------------------");
		int cantProd;
		Pais oPais = null;
		for (int i = 0; i < 10; i++) {
			try {
				oMarcaAUX = queueMarcaAUX.dequeue();
				oPais = queuePaises.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			cantProd = oMarcaAUX.getCantidadProductosHabilitados(oPais);
			System.out.printf("%-5s%-2s%-30s%-2s%-30s%-2s%-20s\n", i + 1, "|", oMarcaAUX.getoMarca().getNombre(), "|",
					oPais.getNombre(), "|", cantProd);
		}
	}

	public void reporte3() {
		HashTable<Pais, PaisAUX> hashPaisAUX = new HashCerrado<>(100, true);
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Pais> hashPaises = file.getPaises();
		Iterator<Pais> itPaises = hashPaises.iterator();
		Iterator<Producto> itProductos = hashProductos.iterator();
		Pais oPais = null;
		Producto oProducto = null;
		while (itPaises.hasNext()) {
			oPais = itPaises.next();
			try {
				hashPaisAUX.insertar(oPais, new PaisAUX(oPais));
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		}
		int nProductosHabTotales = 0;
		while (itProductos.hasNext()) {
			oProducto = itProductos.next();
			if (oProducto.getEstado().equals("HABILITADO")) {
				hashPaisAUX.obtener(oProducto.getPais()).agregarProductoHab();
				nProductosHabTotales++;
			}
		}
		MyPriorityQueue<PaisAUX> queuePaisAUX = new Queue<>();
		Iterator<PaisAUX> itPaisAUX = hashPaisAUX.iterator();
		PaisAUX oPaisAUX = null;
		while (itPaisAUX.hasNext()) {
			oPaisAUX = itPaisAUX.next();
			queuePaisAUX.insert(oPaisAUX, oPaisAUX.getCantProductosHab());
		}
		System.out.printf("%-5s%-2s%-40s%-2s%-35s%-2s%-30s\n", "", "|", "Pais", "|", "Cantidad productos habilitados",
				"|", "% del total");
		System.out.printf("%-5s%-2s%-40s%-2s%-35s%-2s%-30s\n", "----", "|", "---------------------------------------",
				"|", "----------------------------------", "|", "-----------------------------");
		for (int i = 0; i < 10; i++) {
			try {
				oPaisAUX = queuePaisAUX.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			System.out.printf("%-5s%-2s%-40s%-2s%-35s%-2s%-30s\n", i + 1, "|", oPaisAUX.getoPais().getNombre(), "|",
					oPaisAUX.getCantProductosHab(), "|", oPaisAUX.getCantProductosHab() * 100 / nProductosHabTotales + "%");
		}
	}

	public void reporte4() {
		HashTable<Clase, ClaseAUX> hashClaseAUX = recorrerHashReporte4();
		Iterator<ClaseAUX> itClaseAUX = hashClaseAUX.iterator();
		Iterator<PaisAUX> itPaisesPClase = null;
		MyPriorityQueue<Clase> queue = new Queue<>();
		MyPriorityQueue<PaisAUX> queuePaises = new Queue<>();
		PaisAUX oPaisAUX = null;
		ClaseAUX oClaseAUX;
		while (itClaseAUX.hasNext()) {
			oClaseAUX = itClaseAUX.next();
			itPaisesPClase = oClaseAUX.getHashPaises().iterator();
			while (itPaisesPClase.hasNext()) {
				oPaisAUX = itPaisesPClase.next();
				queue.insert(oClaseAUX.getoClase(), oPaisAUX.getCantProductosHab());
				queuePaises.insert(oPaisAUX, oPaisAUX.getCantProductosHab());

			}
		}
		System.out.printf("%-5s%-2s%-108s%-2s%-40s%-2s%-20s\n", "", "|", "Clase", "|", "Pais", "|",
				"Cantidad de productos habilitados");
		System.out.printf("%-5s%-2s%-108s%-2s%-40s%-2s%-20s\n", "----", "|",
				"----------------------------------------------------------------------------------------------------------",
				"|", "---------------------------------------", "|", "-----------------------------------");
		Clase oClase = null;
		for (int i = 0; i < 20; i++) {
			try {
				oClase = queue.dequeue();
				oPaisAUX = queuePaises.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			int cantProd = oPaisAUX.getCantProductosHab();
			System.out.printf("%-5s%-2s%-108s%-2s%-40s%-2s%-20s\n", i + 1, "|", oClase.getNombre(), "|",
					oPaisAUX.getoPais().getNombre(), "|", cantProd);
		}
	}

	private HashTable<Long, EmpresaAUX> recorrerHashReporte1() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Empresa> hashEmpresas = file.getEmpresas();
		HashTable<Long, EmpresaAUX> hashEmpresaAUX = new HashCerrado<>(1400, true);

		Iterator<Empresa> itEmpresas = hashEmpresas.iterator();
		Empresa oEmpresa;
		EmpresaAUX oEAUX;
		while (itEmpresas.hasNext()) {
			oEmpresa = itEmpresas.next();
			oEAUX = new EmpresaAUX(oEmpresa);
			try {
				hashEmpresaAUX.insertar(oEmpresa.getRuc(), oEAUX);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		Producto prod;
		while (itProductos.hasNext()) {
			prod = itProductos.next();
			if (prod.getEstado().equals("HABILITADO")) {
				hashEmpresaAUX.obtener(prod.getEmpresa().getRuc()).agregarProductoHab();
			}
		}

		return hashEmpresaAUX;
	}

	private HashTable<String, MarcaAUX> recorrerHashReporte2() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Marca> hashMarcas = file.getMarcas();
		HashTable<String, MarcaAUX> hashMarcasReporte2 = new HashCerrado<>(6500, true);
		Iterator<Marca> itMarcas = hashMarcas.iterator();
		Marca oMarca = null;
		MarcaAUX oMarcaAUX;
		while (itMarcas.hasNext()) {
			oMarca = itMarcas.next();
			if (oMarca.getNombre() != null) {
				oMarcaAUX = new MarcaAUX(oMarca);
				try {
					hashMarcasReporte2.insertar(oMarca.getNombre(), oMarcaAUX);
				} catch (ElementoYaExistenteException e) {
					e.printStackTrace();
				}
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		Producto oProducto;
		while (itProductos.hasNext()) {
			oProducto = itProductos.next();
			oMarca = oProducto.getMarca();
			if (oProducto.getEstado().equals("HABILITADO") && oMarca.getNombre() != null) {
				oMarcaAUX = hashMarcasReporte2.obtener(oMarca.getNombre());
				oMarcaAUX.agregarPaisYProductoHabilitado(oProducto.getPais());
			}
		}
		return hashMarcasReporte2;

	}

	private HashTable<Clase, ClaseAUX> recorrerHashReporte4() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Clase> hashClases = file.getClases();
		HashTable<Clase, ClaseAUX> hashClaseAUX = new HashCerrado<>(800, true);

		Iterator<Clase> itClases = hashClases.iterator();
		Clase oClase;
		ClaseAUX oClaseAUX;
		while (itClases.hasNext()) {
			oClase = itClases.next();
			oClaseAUX = new ClaseAUX(oClase);
			try {
				hashClaseAUX.insertar(oClase, oClaseAUX);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		Producto oProducto;
		while (itProductos.hasNext()) {
			oProducto = itProductos.next();
			oClase = (Clase) oProducto.getClase();
			if (oProducto.getEstado().equals("HABILITADO")) {
				hashClaseAUX.obtener(oClase).setHashPaises(oProducto.getPais());
			}
		}
		return hashClaseAUX;
	}

}
