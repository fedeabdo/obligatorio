Implementacion con array de ARBOLES BINARIOS COMPLETOS.
|---------|			|---------|
|HeapImpl |	 0..n	|NodoHeap |
|---------| _____\	|---------|
|		  |		 /	|k        |
|		  |			|v		  |
|---------|			|---------|


public class HeapImpl <k,v> implements Heap<k,v>{
	private NodoHeap<k,v>[] elements;
	private int size = 0;
	
	public HeadImpl(int size){
		elements = new NodoHeap[size]
		// un elemento mas de como se debe comportar este heap
	}
	
	
	public void insert(k key, v value){
		NodoHeap<k,v> otemp = new NodoHeap<>(key, value);
		int nPosActual;
		elements[size] = otemp;
		nPosActual = size;
		while( getParent(nPosActual) != null && getParent(nPosActual).getKey().compareto(otemp.getKey())<0 ){
			NodoHeap<k,v> otempP = elemento[getPosParent(nPosActual)];
			element[getParent(nPosActual)];
			element[nPosActual] = otempP;
			nPosActual = getPosParent( nPosActual );
		}
		size++;
	}
		
	private NodoHeap getParent( int nPos ){
		NodoHeap oResult = null;
		if( nPos>0 ){
			int nPosParent = (nPos -1)/2;
			oResult = elements[nPosParent];
		}
		return oResult;
	}
	
	private int getPosParent( int nPos ){
		int nValue = 0;
		if(nPos>0){
			nValue = (nPos-1)/2;
		}
		return nValue;
	}
}