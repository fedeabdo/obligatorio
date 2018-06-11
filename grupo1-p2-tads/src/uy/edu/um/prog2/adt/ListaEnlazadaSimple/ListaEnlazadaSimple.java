package uy.edu.um.prog2.adt.ListaEnlazadaSimple;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;

public class ListaEnlazadaSimple<T> implements MiListaEnlazada<T> {
	
	private NodoObjects<T> primero;
	private int tamanio;
	
	public ListaEnlazadaSimple(){
		tamanio = 0;
	}
	
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
		tamanio++;
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
			tamanio++;
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
		tamanio--;
		oTempA.setProximo(oTemp.getProximo());
	}
	
	
	public T obtener(int i) throws PosicionInvalida{ 
		T oSalida;
		NodoObjects<T> oTemp = primero;
		int n = 0;
		if(i>= this.tamanio()) {
			throw new PosicionInvalida("Posicion invalida.");
		}
		while(n != i) {
			oTemp = oTemp.getProximo();
			n++;
		}
		oSalida = oTemp.getObjeto();
		return oSalida;
	}

	public int tamanio() {
		return tamanio;
	}
	
	public T esta (T n) {
		NodoObjects<T> oNodoObjetos = new NodoObjects<T>(n);
		T bSalida = null;
		NodoObjects<T> oTemp = primero;
		while(oTemp!= null && !oTemp.getObjeto().equals( oNodoObjetos.getObjeto())) {
				oTemp = oTemp.getProximo();
		}
		if(oTemp != null && oTemp.getObjeto().equals(oNodoObjetos.getObjeto() )) {
			bSalida = oTemp.getObjeto();
		}
		return bSalida;
	}
	
	public void addFirst( T value ) {
		tamanio ++;
		NodoObjects<T> oFirst = new NodoObjects<T>( value );
		oFirst.setProximo( primero );
		primero = oFirst;
	}
	public void addLast( T value ) {
		tamanio++;
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