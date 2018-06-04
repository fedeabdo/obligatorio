package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.*;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class Reporte {
	public void reporte1() throws PosicionInvalida, EmptyQueueException{
		MiListaEnlazada<Empresa> listaEmpresas = listaEmpresas();
		MyPiorityQueue<Empresa> EmpresaOrdenadaCantProductos = new Queue<>();
		for( int i = 0; i<listaEmpresas.tamanio(); i++) {
			EmpresaOrdenadaCantProductos.insert(listaEmpresas.obtener(i), listaEmpresas.obtener(i).getCantProductos());
		}
		Empresa oEmpresa = null;
		for(int i = 0; i<listaEmpresas.tamanio(); i++) {
			oEmpresa = EmpresaOrdenadaCantProductos.dequeue();
			System.out.println(oEmpresa.getNombre() + "		" + oEmpresa.getCantProductos());
		}
		
	}
	
	private MiListaEnlazada<Empresa> listaEmpresas(){
		return new FileToObjects().getEmpresas();
	}
}
