package um;

public class QuickSort {
	public static <T extends Comparable<T>> T[] order(T[] array) {
		T[] arrayOrdenado = array.clone();
		quickSort(arrayOrdenado, 0, arrayOrdenado.length);
		return arrayOrdenado;
	}

	private static <T extends Comparable<T>> void quickSort(T[] array, int indInicio, int indFinal) {
		int indMedio = indInicio + (indFinal - indInicio) / 2;
		if (indMedio - indInicio != 0) {
			indMedio = quick(array, indInicio, indFinal);
			quickSort(array, indMedio, indFinal);
			quickSort(array, indInicio, indMedio);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> int quick(T[] array, int indInicio, int indFinal) {
		int indPivot = indInicio + (indFinal - indInicio) / 2;
		T oPivot = array[indPivot];
		T[] array0 = (T[]) new Comparable[indPivot - indInicio];
		T[] array1 = (T[]) new Comparable[(indFinal - 1) - indPivot];
		int x = indInicio;
		int y = 0;
		for (int i = 0; i < array0.length; i++) {
			array0[i] = array[x++];
		}
		x = indPivot + 1;
		for (int j = 0; j < array1.length; j++) {
			array1[j] = array[x++];
		}
		boolean bStop0 = true;
		boolean bStop1 = true;
		while (bStop0 || bStop1) {
			bStop0 = false;
			for (int i = 0; !bStop0 && i < array0.length; i++) {
				if (array0[i].compareTo(oPivot) > 0) {
					x = i;
					bStop0 = true;
				}
			}
			bStop1 = false;
			for (int i = 0; !bStop1 && i < array1.length; i++) {
				if (array1[i].compareTo(oPivot) < 0) {
					y = i;
					bStop1 = true;
				}
			}
			if (bStop0 && bStop1) {
				swap(array0, array1, x, y);
			}
			if (bStop0 == true && bStop1 == false) {
				T[] arrayTemp = array0.clone();
				array0 = (T[]) new Comparable[array0.length - 1];
				indPivot--;
				int i = 0;
				int j = 0;
				while (i != arrayTemp.length) {
					if (i != x)
						array0[j++] = arrayTemp[i];
					i++;
				}
				T[] arrayTemp1 = array1.clone();
				array1 = (T[]) new Comparable[array1.length + 1];
				i = 0;
				j = 0;
				while (j != array1.length) {
					if (j == 0)
						array1[j++] = arrayTemp[x];
					else {
						array1[j++] = arrayTemp1[i++];
					}
				}

			} else if (bStop0 == false && bStop1 == true) {
				T[] arrayTemp = array1.clone();
				array1 = (T[]) new Comparable[array1.length - 1];
				indPivot++;
				int i = 0;
				int j = 0;
				while (i != arrayTemp.length) {
					if (i != y)
						array1[j++] = arrayTemp[i];
					i++;
				}
				T[] arrayTemp1 = array0.clone();
				array0 = (T[]) new Comparable[array0.length + 1];
				i = 0;
				j = 0;
				while (i != array0.length) {
					if (j == array0.length - 1)
						array0[j++] = arrayTemp[y];
					else
						array0[j++] = arrayTemp1[i];
					i++;
				}
			}
		}
		int i = 0;
		for(i = 0; i<array0.length;i++) {
			array[indInicio + i] = array0[i];
		}
		array[indPivot] = oPivot;
		for(int j = 0; j<array1.length;j++) {
			array[indPivot + 1 + j] = array1[j];
		}
		return indPivot;
		// T[] newArray0 = null;
		// T[] newArray1 = null;
		// if(bStop0==true && bStop1==false) {
		// for(int i = 0; i<array0.length;i++) {
		//
		// }
		// }
		// VERSION SIN USAR ARRAY. NO ANDA!
		// int pivot = indInicio == 0 ? indFinal/2-1/2:(indFinal)/2 + (indFinal - 1 -
		// indInicio) / 2;
		// boolean bPrimeraMitad = true;
		// boolean bSegundaMitad = true;
		// int i = indInicio;
		// int j = pivot + 1;
		// while (i != pivot && j != indFinal ) {
		// bPrimeraMitad = bSegundaMitad = true;
		// for (i = indInicio; bPrimeraMitad && i <= pivot; i++) {
		// if (array[i].compareTo(array[pivot]) > 0)
		// bPrimeraMitad = false;
		// }
		// for (j = pivot + 1; bSegundaMitad && j < indFinal; j++) {
		// if (array[j].compareTo(array[pivot]) < 0)
		// bSegundaMitad = false;
		// }
		// if ((bPrimeraMitad == bSegundaMitad) && (bPrimeraMitad == false)) {
		// swap(array, i-1, j-1);
		// } else if (bPrimeraMitad == true && bSegundaMitad == false) {
		// move(array, j-1, pivot++);
		// } else if (bPrimeraMitad == false && bSegundaMitad == true) {
		// move(array, i-1, pivot--);
		// }
		// }
		// if(i==pivot && j<indFinal-1) {
		// for(int k=j;k<indFinal;k++) {
		// if (array[k].compareTo(array[pivot]) < 0)
		// move(array, j, pivot--);
		// }
		// }else if(i!=pivot && j==indFinal-1) {
		// if (array[i].compareTo(array[pivot]) > 0)
		// move(array, i, pivot++);
		// }

	}

	// private static <T extends Comparable<T>> void move(T[] array, int
	// indElemento, int indDestino) {
	// T oTemp = array[indElemento];
	// while (indElemento != indDestino) {
	// array[indElemento] = indElemento < indDestino ? array[++indElemento] :
	// array[--indElemento];
	// }
	// array[indDestino] = oTemp;
	// }
	//
	// private static <T extends Comparable<T>> T[] swap(T[] arrayObjetos, int
	// posicion0, int posicion1) {
	// T otemp = arrayObjetos[posicion0];
	// arrayObjetos[posicion0] = arrayObjetos[posicion1];
	// arrayObjetos[posicion1] = otemp;
	// return arrayObjetos;
	// }

	private static <T extends Comparable<T>> void swap(T[] array0, T[] array1, int posicion0, int posicion1) {
		T otemp = array0[posicion0];
		array0[posicion0] = array1[posicion1];
		array1[posicion1] = otemp;
	}
}
