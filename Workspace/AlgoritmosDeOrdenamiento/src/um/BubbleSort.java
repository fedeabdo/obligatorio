package um;

public class BubbleSort {

	public static <T extends Comparable<T>> T[] order(T[] inArray) {
		T[] arrayObjetos = inArray.clone();
		boolean swap = true;
		for (int j = 1; swap && j <= arrayObjetos.length; j++) {
			swap = false;
			for (int i = 0; i < arrayObjetos.length - j; i++) {
				if (arrayObjetos[i].compareTo(arrayObjetos[i + 1]) > 0) {
					swap(arrayObjetos, i, i + 1);
					swap = true;
				}
			}
		}
		return arrayObjetos;
	}

	public static <T extends Comparable<T>> T[] orderParImpar(T[] inArray) {
		T[] arrayObjetos = inArray.clone();
		boolean swap = true;
		for (int j = 1; swap && j <= arrayObjetos.length; j++) {
			swap = false;
			for (int i = 0; i < arrayObjetos.length - j; i=i+2) {
				if (arrayObjetos[i].compareTo(arrayObjetos[i + 1]) > 0) {
					swap(arrayObjetos, i, i + 1);
					swap = true;
				}
			}
			for (int i = 1; i < arrayObjetos.length - j; i=i+2) {
				if (arrayObjetos[i].compareTo(arrayObjetos[i + 1]) > 0) {
					swap(arrayObjetos, i, i + 1);
					swap = true;
				}
			}
		}
		return arrayObjetos;
	}

	private static <T extends Comparable<T>> T[] swap(T[] arrayObjetos, int posicion0, int posicion1) {
		T otemp = arrayObjetos[posicion0];
		arrayObjetos[posicion0] = arrayObjetos[posicion1];
		arrayObjetos[posicion1] = otemp;		
		return arrayObjetos;
	}
}

// 1) (SIN EL BOOLEAN SWAP) Este metodo hace (arrayObjetos.lenght - 1) pasadas y
// comparaciones. Da igual si esta
// en el mejor de los casos o en el peor de los casos, va a recorrer y comparar
// esa cantidad.
