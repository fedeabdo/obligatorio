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
			file.loadFiles("nombre del archivo. DEBE SER PASADO POR MENU");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reporte1() {
		MiListaEnlazada<Empresa> listaEmpresas = file.getEmpresas();
		MyPiorityQueue<Empresa> EmpresaOrdenadaCantProductos = new Queue<>();
		Empresa oEmpresa=null;
		for (int i = 0; i < listaEmpresas.tamanio(); i++) {
			try {
				oEmpresa = listaEmpresas.obtener(i);
			} catch (PosicionInvalida e) {
				e.printStackTrace();
			}
			EmpresaOrdenadaCantProductos.insert(oEmpresa, oEmpresa.getCantProductos());
		}
		for (int i = 0; i < listaEmpresas.tamanio(); i++) {
			try {
				oEmpresa = EmpresaOrdenadaCantProductos.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			System.out.println(oEmpresa.getNombre() + "		" + oEmpresa.getCantProductos());
		}
	}

	public void reporte2() {

		// for(in)
	}

	public void reporte3() {
		MiListaEnlazada<Pais> listaPaises = file.getPaises();
		MyPiorityQueue<Pais> paisOrdenadoCantProductosH = new Queue<>();
		Pais oPais=null;
		for (int i = 0; i < listaPaises.tamanio(); i++) {
			try {
				oPais = listaPaises.obtener(i);
			} catch (PosicionInvalida e) {
				e.printStackTrace();
			}
			paisOrdenadoCantProductosH.insert(oPais, oPais.getCantProductosHabilitados());
		}
		for (int i = 0; i < listaPaises.tamanio(); i++) {
			try {
				oPais=paisOrdenadoCantProductosH.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			System.out.println(oPais.getNombre() + "   " + oPais.getCantProductosHabilitados() + "   " + oPais.getPorcentajeProductos(file.getCantProductos()));
		}
	}
	
	public void reporte4() {

	}
	

}
