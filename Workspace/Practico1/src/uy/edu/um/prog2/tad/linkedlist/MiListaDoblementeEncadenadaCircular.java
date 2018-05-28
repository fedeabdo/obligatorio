package uy.edu.um.prog2.tad.linkedlist;

import uy.ListaEncadenada;


public class MiListaDoblementeEncadenadaCircular implements ListaEncadenada {
	
	private Nodo primero;
	
	public void agregar(int i) {
		Nodo oNodo = new Nodo(i);
		if( primero == null ) {
			primero = oNodo;
			primero.setProximo(primero);
			primero.setAnterior(primero);
		}else if(primero != null) {
			Nodo oTemp = primero;
			while(oTemp.getProximo() != primero) {
				oTemp = oTemp.getProximo();
			}
			oTemp.setProximo(oNodo);
			oNodo.setAnterior(oTemp);
			oNodo.setProximo(primero);
			primero.setAnterior(oNodo);
		}
	}

	public void eliminar(int i) {
		Nodo oTemp = primero;
//		Nodo oTempA = primero.getAnterior();
		int n = 0;
		if( i == 0 ) {
			primero=oTemp.getProximo();
			oTemp.getProximo().setAnterior(oTemp.getAnterior());
			oTemp.getAnterior().setProximo(oTemp.getProximo());
		}else {
			while(n != i) {
//				System.out.println(n);
				oTemp = oTemp.getProximo();
				n++;
//				System.out.println(n);
			}
			oTemp.getAnterior().setProximo(oTemp.getProximo());
			oTemp.getProximo().setAnterior(oTemp.getAnterior());
		}	
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
		while( oTemp.getProximo() != primero) {
			oTemp = oTemp.getProximo();
			nTamanio++;
		}
		return nTamanio;
	}
	
	public boolean esta (int n) {
		Nodo oNodo = new Nodo(n);
		boolean bSalida = false;
		Nodo oTemp = primero;
		if( n == primero.getValor() ) {
			bSalida = true;
		}else {
			while(oTemp != primero && oTemp.getValor() != oNodo.getValor()) {
				oTemp = oTemp.getProximo();
			}
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
			oFirst.setProximo(primero);
			oFirst.setAnterior(primero);
		}else if(primero.getProximo() == primero){
			oFirst.setProximo( primero );
			oFirst.setAnterior( primero.getAnterior() );
			primero.setAnterior(oFirst);
			primero.setProximo(oFirst);
			primero = oFirst;
		}else {
			oFirst.setProximo(primero);
			oFirst.setAnterior(primero.getAnterior());
			primero.setAnterior(oFirst);
			primero = oFirst;
		}
	}
	public void addLast( int value ) {
		Nodo oLast = new Nodo (value);
		Nodo oTemp = primero;
		if( primero == null) {
			primero = oLast;
			oLast.setAnterior(oLast);
			oLast.setProximo(oLast);
		}else if( primero.getProximo() == primero) {
			oLast.setAnterior(primero);
			oLast.setProximo(primero);
			primero.setProximo(oLast);
			primero.setAnterior(oLast);
		}else {
		while( oTemp.getProximo() != primero ) {
			oTemp = oTemp.getProximo();
		}
		oTemp.setProximo(oLast);
		oLast.setProximo(primero);
		oLast.setAnterior(oTemp);
		primero.setAnterior(oLast);
		}
	}

	public Nodo getPrimero() {
		return primero;
	}

	public void setPrimero(int i) {
		int n =0;
		Nodo oTemp = primero;
		while(n!=i) {
			oTemp = oTemp.getProximo();
			n++;
		}
		primero = oTemp;
	}
	
}