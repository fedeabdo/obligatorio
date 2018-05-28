package um;

public class Insercion {
	public static <T extends Comparable<T>> T[] order(T[] array) {
		T[] arrayObjetos = array.clone();
		int j = 0;
		for(int i = 1; i<arrayObjetos.length; i++) {
			j=i;
			while(j!=0 && arrayObjetos[j].compareTo(arrayObjetos[j-1])<0) {
				swap(arrayObjetos,j,j-1);
				j--;
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
