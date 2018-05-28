package um;

public class MergeSort {
	public static <T extends Comparable<T>> T[] order(T[] array) {
		T[] arrayOrdenado = array.clone();
		mergeSort(arrayOrdenado, 0, arrayOrdenado.length-1);
		return arrayOrdenado;
	}

	private static <T extends Comparable<T>> void mergeSort(T[] array, int indInicio, int indFinal) {
		if (indInicio < indFinal) {
			int midle = (indInicio + indFinal) / 2;
			mergeSort(array, indInicio, midle);
			mergeSort(array, midle + 1, indFinal);
			merge(array, indInicio, midle, indFinal);
		}
	}

	private static <T extends Comparable<T>> void merge(T[] array, int indInicio, int midle, int indFinal) {
		@SuppressWarnings("unchecked")
		T[] arrayOrdenado = (T[]) new Comparable[indFinal - indInicio + 1];
		int tempMidleM1 = midle+1;
		int tempIndInicio = indInicio;
		int n = 0;

		if (arrayOrdenado.length == 2) {
			if (array[indInicio].compareTo(array[indFinal]) > 0) {
				arrayOrdenado[0] = array[indFinal];
				arrayOrdenado[1] = array[indInicio];
			}else {
				arrayOrdenado[0] = array[indInicio];
				arrayOrdenado[1] = array[indFinal];
			}
		} else {
			while (indInicio <= midle && (tempMidleM1) <= indFinal) {
				if (array[indInicio].compareTo(array[tempMidleM1]) <= 0) {
					arrayOrdenado[n++] = array[indInicio++];
				} else if (array[tempMidleM1].compareTo(array[indInicio]) < 0) {
					arrayOrdenado[n++] = array[tempMidleM1++];
				}
			}
			if(!(indInicio<=midle)) {
				for(int i = tempMidleM1; i<=indFinal; i++) {
					arrayOrdenado[n++] = array[i];
				}
			}else if(!(tempMidleM1<=indFinal)) {
				for(int i = indInicio; i<=midle ;i++) {
					arrayOrdenado[n++] = array[i];
				}
			}
			// if (i == fTemp) {
			// while (n < arrayOrdenado.length) {
			// arrayOrdenado[n++] = array[i++];
			// }
			// if (indFinal == tempIndFinal) {
			// while (n < arrayOrdenado.length) {
			// arrayOrdenado[n++] = array[i++];
			// }
			// }
		}
		
		n = 0;
		for (int i = tempIndInicio; i <= indFinal; i++) {
			array[i] = arrayOrdenado[n++];

		}

	}
}
