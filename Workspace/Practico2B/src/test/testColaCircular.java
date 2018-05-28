package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.EmptyQueueException;
import um.MyQueue.MyQueueConListaEnlazadaImplements;

public class testColaCircular {

	@Test(expected = EmptyQueueException.class)
	public void test() throws EmptyQueueException {
		MyQueueConListaEnlazadaImplements<Integer> miLista = new MyQueueConListaEnlazadaImplements<>();
		miLista.enqueue(0);
		assertEquals((Integer) 0, miLista.getFirst());
		assertEquals((Integer) 0, miLista.dequeue());
		assertTrue(miLista.isEmpty());
		miLista.getFirst();
	}


}
