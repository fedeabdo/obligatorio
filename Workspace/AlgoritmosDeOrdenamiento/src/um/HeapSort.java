package um;

public class HeapSort {
	public static <T extends Comparable<T>> T[] order(T[] array) {
		T[] arrayOrdenado = array.clone();
		orderHeap(arrayOrdenado, arrayOrdenado.length,0);
		deleteAllHeap(arrayOrdenado);
		return arrayOrdenado;
	}
	
	private static <T extends Comparable<T>> void orderHeap(T[] array, int length, int i) {		
		boolean swap=true;
		do {
			swap = false;
			if (2 * i + 1 < length) {
				if (array[i].compareTo(array[2 * i + 1]) < 0) {
					swap(array, i, 2 * i + 1);
					swap = true;
				}
				orderHeap(array, length, 2 * i + 1);
			}
			if (2 * i + 2 < length) {
				if (array[i].compareTo(array[2 * i + 2]) < 0) {
					swap(array, i, 2 * i + 2);
					swap = true;
				}
				orderHeap(array, length, 2 * i + 2);
			}
		} while (swap);
	}

//		for(int i=length-1; i>=0; i--) {
//			if(2*i+2<length) {
//				if(array[2*i+1].compareTo(array[i])>0) {
//					swap(array,i,2*i+1);
//				}
//				if(array[2*i+2].compareTo(array[i])>0) {
//					swap(array,2*i+2,i);
//				}
//			}else if(2*i+1<length) {
//				if(array[2*i+1].compareTo(array[i])>0) {
//					swap(array,2*i+1,i);
//				}
//			}
//		}
//	}
	private static <T extends Comparable<T>> void deleteAllHeap(T[] array) {
		//Mueve el elemento padre a la derecha del todo y pone el ultimo elemento agregado a la raiz y luego ordena. Reitera hasta que no sea mas un arbol.
		int m=1;
		int n=array.length-m;
		while(n!=0) {
		n=array.length-m;
		swap(array,0,n);
		m++;
		orderHeap(array,n,0);
		}	
	}
	private static <T extends Comparable<T>> void swap(T[] arrayObjetos, int posicion0, int posicion1) {
		T otemp = arrayObjetos[posicion0];
		arrayObjetos[posicion0] = arrayObjetos[posicion1];
		arrayObjetos[posicion1] = otemp;		
	}
}
