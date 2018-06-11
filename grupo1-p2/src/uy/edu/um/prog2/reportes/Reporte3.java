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
	private Pais oPais;
	private int nProductosHAB;
	private int nProductosTOTALES;

	public Reporte3(Pais oPais) {
		this.oPais = oPais;
		nProductosHAB = 0;
		nProductosTOTALES = 0;
	}

	public Pais getoPais() {
		return oPais;
	}

	public int getnProductosHAB() {
		return nProductosHAB;
	}

	public int getnProductosTOTALES() {
		return nProductosTOTALES;
	}

	public void agregarProductoHAB() {
		nProductosHAB++;
	}

	public void agregarProductoTOTAL() {
		nProductosTOTALES++;
	}
}
