package test;

import um.MyQueue.MyDoubleQueueImplements;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.EmptyQueueException;

public class testMyDoubleQueue {

	@Test
	public void test() throws EmptyQueueException {
		MyDoubleQueueImplements<Integer> coso = new MyDoubleQueueImplements<>();
		coso.enqueueLeft(2);
		assertEquals((Integer)2,coso.getPrimero());
		assertEquals((Integer)2,coso.getUltimo());
		coso.enqueueRight(3);
		assertEquals((Integer)3,coso.getUltimo());
		assertEquals((Integer)3,coso.dequeueRight());
		assertEquals((Integer)2,coso.getPrimero());
		assertEquals((Integer)2,coso.getUltimo());
		assertEquals((Integer)2,coso.dequeueRight());
		assertEquals(null,coso.getPrimero());
		assertEquals(null,coso.getUltimo());
		try {
			coso.dequeueLeft();
			fail();
		}catch(EmptyQueueException e) {
			assertTrue(true);
			System.out.println(e.getMessage());
		}
	}

}
