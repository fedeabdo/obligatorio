package um;

public class Seleccion {
	
	public static <T extends Comparable<T>> T[] order(T[] array) {
		T[] arrayObjetos = array.clone();
		int nMin = 0;
		for (int j = 0; j < arrayObjetos.length; j++) {
			nMin = j;
			for (int i = j; i < arrayObjetos.length; i++) {
				if (arrayObjetos[nMin].compareTo(arrayObjetos[i]) > 0) {
					nMin = i;
				}
			}
			swap(arrayObjetos, j, nMin);
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
