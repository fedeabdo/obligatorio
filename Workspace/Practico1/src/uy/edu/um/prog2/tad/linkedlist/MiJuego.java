package uy.edu.um.prog2.tad.linkedlist;

import Exceptions.IllegalArgumentsException;

public class MiJuego {

	private MiListaEncadenada ganador;

	public MiJuego() { 	//ANDA MAL LPM
		ganador = new MiListaEncadenada();
	}

	public MiListaEncadenada juego(int m, MiListaDoblementeEncadenadaCircular colIntegrantes)
			throws IllegalArgumentsException {
		if (Math.abs(m) > colIntegrantes.tamanio()) {
			IllegalArgumentsException error = new IllegalArgumentsException("La cantidad de saltos no puede ser mayor que la cantidad de participantes.");
			throw error;
		}
		MiListaEncadenada oSalida = new MiListaEncadenada();
		while (colIntegrantes.tamanio() != 1) {
			oSalida.agregar(colIntegrantes.obtener(m));
//			System.out.println(colIntegrantes.getPrimero().getValor());
			colIntegrantes.eliminar(m);
			colIntegrantes.setPrimero(m);
		}
		ganador.agregar(colIntegrantes.obtener(0));
		return oSalida;
	}

	public MiListaEncadenada getGanador() {
		return ganador;
	}

}
