package uy.edu.um.prog2.tad.linkedlist;

import uy.ListaEncadenada;


public class MiListaDoblementeEncadenada implements ListaEncadenada {
	
	private Nodo primero;
	
	public void agregar(int i) {
		Nodo oNodo = new Nodo(i);
		if( primero == null ) {
			primero = oNodo;
		}else if(primero != null) {
			Nodo oTemp = primero;
			while(oTemp.getProximo() != null) {
				oTemp = oTemp.getProximo();
			}
			oTemp.setProximo(oNodo);
			oNodo.setAnterior(oTemp);
		}
	}

	public void eliminar(int i) {
		Nodo oTemp = primero;
		Nodo oTempA = primero;
		int n = 0;
		if( i == 0 ) {
			primero = primero.getProximo();
			primero.setAnterior(null);
		}
		while(n != i) {
			oTempA = oTemp;
			oTemp = oTemp.getProximo();
			n++;
		}
		oTempA.setProximo(oTemp.getProximo());
		oTemp.setAnterior(null);
		oTemp.getProximo().setAnterior(oTempA);
	}
	
	
	public int obtener(int i) {
		int nSalida;
		Nodo oTemp = primero;
		int n = 0;
		while(n != i) {
			oTemp = oTemp.getProximo();
			n++;
		}
		nSalida = oTemp.getValor();
		return nSalida;
	}

	public int tamanio() {
		Nodo oTemp = primero;
		int nTamanio = 1;
		while( oTemp.getProximo() != null ) {
			oTemp = oTemp.getProximo();
			nTamanio++;
		}
		return nTamanio;
	}
	
	public boolean esta (int n) {
		Nodo oNodo = new Nodo(n);
		boolean bSalida = false;
		Nodo oTemp = primero;
		while(oTemp != null && oTemp.getValor() != oNodo.getValor()) {
			oTemp = oTemp.getProximo();
		}
		if(oTemp.getValor() == oNodo.getValor()) {
			bSalida = true;
		}
		return bSalida;
	}
	
	public void addFirst( int value ) {
		Nodo oFirst = new Nodo( value );
		if( primero == null ) {
			primero = oFirst;
		}else {
			oFirst.setProximo( primero );
			primero.setAnterior(oFirst);
			primero = oFirst;
		}
	}
	public void addLast( int value ) {
		Nodo oLast = new Nodo (value);
		if( primero == null ) {
			primero = oLast;
		}else {
			Nodo oTemp = primero;
			while( oTemp.getProximo() != null ) {
				oTemp = oTemp.getProximo();
			}
			oTemp.setProximo(oLast);
			oLast.setAnterior(oTemp);
		}
	}
}