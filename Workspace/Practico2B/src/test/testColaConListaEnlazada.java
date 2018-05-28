package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import Exceptions.EmptyQueueException;
import um.MyQueue.MyQueueConListaEnlazadaImplements;


public class testColaConListaEnlazada {

	public testColaConListaEnlazada() {

	}

	@Test
	public void testFlujoNormal() throws EmptyQueueException {
		MyQueueConListaEnlazadaImplements<Integer> miLista = new MyQueueConListaEnlazadaImplements<>();
		miLista.enqueue(0);
		assertEquals((Integer) 0, miLista.getFirst());
		assertEquals((Integer) 0, miLista.dequeue());
		assertTrue(miLista.isEmpty());
		
		miLista.enqueue(3);
		miLista.enqueue(2);
		miLista.enqueue(4);
		miLista.enqueue(5);
		assertEquals((Integer) 3, miLista.dequeue());
		assertEquals((Integer) 2, miLista.dequeue());
		assertFalse(miLista.isEmpty());
	}

}
