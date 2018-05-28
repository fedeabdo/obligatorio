package Programa.ColasCajasSuper;
import Exceptions.EmptyQueueException;
import um.MyQueue.MyQueueConListaEnlazadaImplements;

public class Caja {
	private MyQueueConListaEnlazadaImplements<Cliente> ColaDeClientes;
	
	public Caja() {
		ColaDeClientes = new MyQueueConListaEnlazadaImplements<>();
	}
	
	public void enqueueClient(Cliente oCliente) {
		ColaDeClientes.enqueue(oCliente);
	}
	

	public int tiempoOcupada() {
		int nTime = 0;
		MyQueueConListaEnlazadaImplements<Cliente> queueTemp = ColaDeClientes;
		for(int i = 0; i<queueTemp.size(); i++) {
			try {
				nTime = nTime + (queueTemp.dequeue()).getnCantProductos() *5;
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nTime;
	}

}