package uy.edu.um.prog2;

import java.io.IOException;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.*;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class Reporte {
	private FileToObjects file;

	public Reporte() {
		file = new FileToObjects();
		try {
			file.loadFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reporte1() throws PosicionInvalida, EmptyQueueException {
		MiListaEnlazada<Empresa> listaEmpresas = file.getEmpresas();
		MyPiorityQueue<Empresa> EmpresaOrdenadaCantProductos = new Queue<>();
		Empresa oEmpresa;
		for (int i = 0; i < listaEmpresas.tamanio(); i++) {
			oEmpresa = listaEmpresas.obtener(i);
			EmpresaOrdenadaCantProductos.insert(oEmpresa, oEmpresa.getCantProductos());
		}
		for (int i = 0; i < listaEmpresas.tamanio(); i++) {
			oEmpresa = EmpresaOrdenadaCantProductos.dequeue();
			System.out.println(oEmpresa.getNombre() + "		" + oEmpresa.getCantProductos());
		}
	}

	public void reporte2() {

		// for(in)
	}

	public void reporte3() throws PosicionInvalida, EmptyQueueException {
		MiListaEnlazada<Pais> listaPaises = file.getPaises();
		MyPiorityQueue<Pais> paisOrdenadoCantProductosH = new Queue<>();
		Pais oPais;
		for (int i = 0; i < listaPaises.tamanio(); i++) {
			oPais = listaPaises.obtener(i);
			paisOrdenadoCantProductosH.insert(oPais, oPais.getCantProductosHabilitados());
		}
		for (int i = 0; i < listaPaises.tamanio(); i++) {
			oPais=paisOrdenadoCantProductosH.dequeue();
			System.out.println(oPais.getNombre() + "   " + oPais.getCantProductosHabilitados() + "   " + oPais.getPorcentajeProductos(file.getCantProductos()));
		}
	}
	
	

}
