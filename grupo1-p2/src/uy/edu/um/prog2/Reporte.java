package uy.edu.um.prog2;

import java.io.IOException;
import java.util.Iterator;

import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.adt.Hash.*;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Queue.*;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;
import uy.edu.um.prog2.reportes.Reporte1;
import uy.edu.um.prog2.reportes.Reporte2;
import uy.edu.um.prog2.reportes.Reporte3;
import uy.edu.um.prog2.reportes.Reporte4;

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
		HashTable<Long, Reporte1> hashEmpresas = recorrerHashReporte1();
		Iterator<Reporte1> itEmpresas = hashEmpresas.iterator();
		MyPriorityQueue<Reporte1> queue = new Queue<>();
		while (itEmpresas.hasNext()) {
			Reporte1 reporte = itEmpresas.next();
			queue.insert(reporte, reporte.getCantidadProductosHabilitados());
		}
		Reporte1 rep1 = null;
		System.out.printf("%-5s%-50s%-20s\n", "", "Empresa", "Cantidad de productos habilitados");
		for (int i = 0; i < 20; i++) {
			try {
				rep1 = queue.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			int cantProd = rep1.getCantidadProductosHabilitados();
			Empresa oEmpresa = rep1.getoEmpresa();
			System.out.printf("%-5s%-50s%-20s\n", i+1, oEmpresa.getNombre(), cantProd);
		}
	}

	public void reporte2() {
		HashTable<String, Reporte2> hashReporte2 = recorrerHashReporte2();
		Iterator<Reporte2> itRep2 = hashReporte2.iterator();
		MyPriorityQueue<Reporte2> queue = new Queue<>();
		Reporte2 rep2 = null;
		while (itRep2.hasNext()) {
			rep2 = (Reporte2) itRep2.next();
			queue.insert(rep2, rep2.getCantidadProductosHabilitados());
		}
		int cantProd;
		for (int i = 0; i < 10; i++) {
			try {
				rep2 = queue.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			cantProd = rep2.getCantidadProductosHabilitados();
			System.out.println();
			System.out.println("Marca:\t" + rep2.getoMarca().getNombre() + ".\n *Pais: " + rep2.getoPais().getNombre()
					+ ".\n *Cantidad productos habilitados: " + cantProd + " .");
		}
	}

	public void reporte3() {
		HashTable<Pais, Reporte3> hashRep3 = new HashCerrado<>(100, true);
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Pais> hashPaises = file.getPaises();
		Iterator<Pais> itPaises = hashPaises.iterator();
		Iterator<Producto> itProductos = hashProductos.iterator();
		Pais oPais = null;
		Producto oP = null;
		while (itPaises.hasNext()) {
			oPais = itPaises.next();
			try {
				hashRep3.insertar(oPais, new Reporte3(oPais));
			} catch (ElementoYaExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (itProductos.hasNext()) {
			oP = itProductos.next();
			hashRep3.obtener(oP.getPais()).agregarProductoTOTAL();
			if (oP.getEstado().equals("HABILITADO")) {
				hashRep3.obtener(oP.getPais()).agregarProductoHAB();
			}
		}
		MyPriorityQueue<Reporte3> queueRep3 = new Queue<>();
		Iterator<Reporte3> itRep3 = hashRep3.iterator();
		Reporte3 rep3 = null;
		while (itRep3.hasNext()) {
			rep3 = itRep3.next();
			queueRep3.insert(rep3, rep3.getnProductosHAB());
		}

		for (int i = 0; i < 10; i++) {
			try {
				rep3 = queueRep3.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("Pais:\t" + rep3.getoPais().getNombre() + ".\n *Cantidad productos habilitados: "
					+ rep3.getnProductosHAB() + " .\n *% del total: "
					+ rep3.getnProductosHAB() * 100 / rep3.getnProductosTOTALES() + " %.");
		}
	}

	public void reporte4() {
		HashTable<Clase, Reporte4> hashReporte4 = recorrerHashReporte4();
		Iterator<Reporte4> itClases = hashReporte4.iterator();
		MyPriorityQueue<Reporte4> queue = new Queue<>();
		while (itClases.hasNext()) {
			Reporte4 rep4 = itClases.next();
			queue.insert(rep4, rep4.getCantProductosHAB());
		}
		Reporte4 rep4 = null;
		for (int i = 0; i < 20; i++) {
			try {
				rep4 = queue.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			int cantProd = rep4.getCantProductosHAB();
			Clase oClase = rep4.getoClase();
			System.out.println(oClase.getNombre() + "  " + rep4.getoPais().getNombre() + "  " + cantProd);
			System.out.println("Clase:\t" + rep4.getoClase().getNombre() + ".\n *Pais: " + rep4.getoPais().getNombre()
					+ ".\n *Cantidad productos habilitados: " + cantProd + " .");
		}
	}

	private HashTable<Long, Reporte1> recorrerHashReporte1() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<Long, Empresa> hashEmpresas = file.getEmpresas();
		HashTable<Long, Reporte1> hashEmpresasReporte1 = new HashCerrado(1400, true);

		Iterator itEmpresas = hashEmpresas.iterator();
		while (itEmpresas.hasNext()) {
			Empresa oEmpresa = (Empresa) itEmpresas.next();
			Reporte1 rep = new Reporte1(oEmpresa);
			try {
				hashEmpresasReporte1.insertar(oEmpresa.getRuc(), rep);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		}

		Iterator itProductos = hashProductos.iterator();
		while (itProductos.hasNext()) {
			Producto prod = (Producto) itProductos.next();
			if (prod.getEstado().equals("HABILITADO")) {
				hashEmpresasReporte1.obtener(prod.getEmpresa().getRuc()).agregarProducto();
			}
		}

		return hashEmpresasReporte1;
	}

	private HashTable<String, Reporte2> recorrerHashReporte2() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Marca> hashMarcas = file.getMarcas();
		HashTable<String, Reporte2> hashMarcasReporte2 = new HashCerrado(6500, true);

		Iterator itMarcas = hashMarcas.iterator();
		Marca oMarca = null;
		Reporte2 rep;
		while (itMarcas.hasNext()) {
			oMarca = (Marca) itMarcas.next();
			if (oMarca.getNombre() != null) {
				rep = new Reporte2(oMarca);
				try {
					hashMarcasReporte2.insertar(oMarca.getNombre(), rep);
				} catch (ElementoYaExistenteException e) {
					e.printStackTrace();
				}
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		Producto prod;
		while (itProductos.hasNext()) {
			prod = itProductos.next();
			oMarca = prod.getMarca();
			if (prod.getEstado().equals("HABILITADO") && oMarca.getNombre() != null) {
				hashMarcasReporte2.obtener(prod.getMarca().getNombre()).addProductoHabilitado();
				hashMarcasReporte2.obtener(prod.getMarca().getNombre()).setoPais(prod.getPais());
			}
		}
		return hashMarcasReporte2;
	}

	private HashTable<Clase, Reporte4> recorrerHashReporte4() {
		HashTable<String, Producto> hashProductos = file.getProductos();
		HashTable<String, Clase> hashClases = file.getClases();
		HashTable<Clase, Reporte4> hashReporte4 = new HashCerrado<>(800, true);

		Iterator<Clase> itClases = hashClases.iterator();
		while (itClases.hasNext()) {
			Clase oClase = itClases.next();
			if (oClase.getNombre() != null) {
				Reporte4 rep4 = new Reporte4(oClase);
				try {
					hashReporte4.insertar(oClase, rep4);
				} catch (ElementoYaExistenteException e) {
					e.printStackTrace();
				}
			}
		}

		Iterator<Producto> itProductos = hashProductos.iterator();
		Producto prod;
		Clase oClase;
		while (itProductos.hasNext()) {
			prod = itProductos.next();
			oClase = (Clase) prod.getClase();
			if (prod.getEstado().equals("HABILITADO")) {
				hashReporte4.obtener(oClase).agregarProductoHAB();
				hashReporte4.obtener(oClase).setoPais(prod.getPais());
			}
		}
		return hashReporte4;
	}

}
