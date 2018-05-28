package uy.edu.um.prog2.tad.linkedlist;

import uy.MiListaEnlazada;


public class ListaEnlazadaSimple<T> implements MiListaEnlazada<T> {
	
	private NodoObjects<T> primero;
	
	public void agregar(T i) {
		NodoObjects<T> oNodoObjetos = new NodoObjects<T>(i);
		if( primero == null ) {
			primero = oNodoObjetos;
		}else if(!(primero.equals(null))) {
			NodoObjects<T> oTemp = primero;
			while(oTemp.getProximo() != null) {
				oTemp = oTemp.getProximo();
			}
			oTemp.setProximo(oNodoObjetos);
		}
	}
	
	public void agregarEnLugar(T o, int i) { //	NOSE SI ANDA!!!
		if(i==0) {
			addFirst(o);
		}else if(i==tamanio()-1) {
			addLast(o);
		}else {
			NodoObjects<T> oTemp = primero;
			int n = 0;
			while(n!=(i-1)) {
				oTemp = oTemp.getProximo();
				n++;
			}
			NodoObjects<T> oNuevo = new NodoObjects<T>( o );
			NodoObjects<T> oTempMAS1 = oTemp.getProximo();
			oTemp.setProximo(oNuevo);
			oNuevo.setProximo(oTempMAS1);
 ////			oNuevo.setAnterior(oTemp.getAnterior());
//			oNuevo.setProximo(oTemp);
//			oTemp.getAnterior().setProximo(oNuevo);
//			oTemp.setAnterior(oNuevo);
			
		}
	}

	public void eliminar(int i) {
		NodoObjects<T> oTemp = primero;
		NodoObjects<T> oTempA = primero;
		int n = 0;
		if(i == 0) {
			primero = primero.getProximo();
		}
		while(n != i) {
			oTempA = oTemp;
			oTemp = oTemp.getProximo();
			n++;
		}
		oTempA.setProximo(oTemp.getProximo());
	}
	
	
	public T obtener(int i) {
		T oSalida;
		NodoObjects<T> oTemp = primero;
		int n = 0;
		while(n != i) {
			oTemp = oTemp.getProximo();
			n++;
		}
		oSalida = oTemp.getObjeto();
		return oSalida;
	}

	public int tamanio() {
		NodoObjects<T> oTemp = primero;
		int nTamanio = 1;
		if (primero == null) {
			nTamanio = 0;
		} else {
			while (oTemp.getProximo() != null) {
				oTemp = oTemp.getProximo();
				nTamanio++;
			}
		}
		return nTamanio;
	}
	
	public boolean esta (T n) {
		NodoObjects<T> oNodoObjetos = new NodoObjects<T>(n);
		boolean bSalida = false;
		NodoObjects<T> oTemp = primero;
		while(oTemp!= null && !oTemp.getObjeto().equals( oNodoObjetos.getObjeto())) {
				oTemp = oTemp.getProximo();
		}
		if(oTemp != null && oTemp.getObjeto().equals(oNodoObjetos.getObjeto() )) {
			bSalida = true;
		}
		return bSalida;
	}
	
	public void addFirst( T value ) {
		NodoObjects<T> oFirst = new NodoObjects<T>( value );
		oFirst.setProximo( primero );
		primero = oFirst;
	}
	public void addLast( T value ) {
		NodoObjects<T> oLast = new NodoObjects<T> (value);
		if( primero == null ) {
			primero = oLast;
		}else {
			NodoObjects<T> oTemp = primero;
			while( oTemp.getProximo() != null ) {
				oTemp = oTemp.getProximo();
			}
			oTemp.setProximo(oLast);
		}
	}
}