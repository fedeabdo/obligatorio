package uy.edu.um.prog2;

import uy.edu.um.prog2.Exceptions.EspecificacionesException;
import uy.edu.um.prog2.adt.Hash.HashCerrado;

public class Especificaciones {
	private static int[] indicesEspecificaciones;
	
	public static int[] especificar(String[] nombresEspecificaciones, HashCerrado<String, Integer> fields) throws EspecificacionesException {
		indicesEspecificaciones = new int[nombresEspecificaciones.length];
		for(int i = 0; i<nombresEspecificaciones.length; i++) {
			if(fields.pertenece(nombresEspecificaciones[i])) {
				indicesEspecificaciones[i] = fields.obtener(nombresEspecificaciones[i]);
			}else {
				throw new EspecificacionesException("No existe la columna llamada, " + nombresEspecificaciones[i] + ", en los datos.");
			}
		}
		return indicesEspecificaciones;
	}



	public static int[] getIndicesEspecificaciones() {
		return indicesEspecificaciones;
	}
	
	
}
