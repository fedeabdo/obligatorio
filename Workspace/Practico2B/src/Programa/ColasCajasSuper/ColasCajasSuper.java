package Programa.ColasCajasSuper;
import uy.edu.um.prog2.tad.linkedlist.ListaEnlazadaSimple;

public class ColasCajasSuper {
	private ListaEnlazadaSimple<Caja> Cajas;
	
	public ColasCajasSuper (int nCantCajas) {
		Cajas = new ListaEnlazadaSimple<>();
		for(int i= 0; i<nCantCajas; i++) {
			Cajas.agregar( new Caja() );
		}
	}
	
	public void agregarCliente(Cliente oCliente) {
		int nCaja = getPrimeraCajaEnQuedarLibre();
		Cajas.obtener(nCaja).enqueueClient(oCliente);
	}
	
	private int getPrimeraCajaEnQuedarLibre() {
		int nCaja = 0;
		int nCajaTiempoMenorTemporal = Cajas.obtener(0).tiempoOcupada();
		for(int i = 0; i<Cajas.tamanio(); i++) {
			if(Cajas.obtener(i).tiempoOcupada() < nCajaTiempoMenorTemporal) {
				nCajaTiempoMenorTemporal = Cajas.obtener(i).tiempoOcupada();
				nCaja = i;
			}
		}
		return nCaja;
	}
	public void verificarYMostrar() {
		for(int i = 0; i<Cajas.tamanio(); i++) {
			System.out.println("Caja numero: " + i + ". Tiempo para liberarse: " + Cajas.obtener(i).tiempoOcupada());
		}
	}
	
}