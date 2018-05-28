package test;

import static org.junit.Assert.*;
import um.MyQueue.MyPiorityQueue.Queue;

import org.junit.Test;

import Exceptions.EmptyQueueException;

public class testMyPiorityQueue {

	@Test
	public void test() throws EmptyQueueException {
		Queue<Integer> miQueue = new Queue<>();
		miQueue.enqueue(1);
		assertEquals ((Integer)1,miQueue.dequeue());
		miQueue.enqueue(2);
		miQueue.enqueue(3);
		miQueue.enqueue(4);
		assertEquals ((Integer)2,miQueue.dequeue());
		assertEquals ((Integer)3,miQueue.getFirst());
		assertEquals ((Integer)3,miQueue.dequeue());
		assertEquals ((Integer)4,miQueue.dequeue());
		assertTrue (miQueue.isEmpty());
		try {
			miQueue.dequeue();
			fail();
		}catch(EmptyQueueException e) {
			System.out.println(e.getMessage());
		}
		miQueue.enqueue(1);
		miQueue.enqueue(2);
		miQueue.enqueue(3);
		miQueue.insert(0, 2);
		assertEquals ((Integer)0 , miQueue.dequeue());
		assertEquals ((Integer)1 , miQueue.dequeue());
		assertEquals ((Integer)2 , miQueue.dequeue());
		assertEquals ((Integer)3 , miQueue.dequeue());
		assertTrue (miQueue.isEmpty());
		miQueue.insert(0,2);
		miQueue.insert(1,1);
		miQueue.insert(-1,5);
		assertEquals ((Integer)(-1) , miQueue.dequeue());
		assertEquals ((Integer)0 , miQueue.dequeue());
		assertEquals ((Integer)1 , miQueue.dequeue());
		
		assertTrue(miQueue.isEmpty());
		miQueue.enqueue((Integer) 3);
		miQueue.enqueue((Integer) 4);
		miQueue.insert(1, 3);
		miQueue.insert(0, 2);
		assertEquals((Integer) 1,miQueue.dequeue());
		assertEquals((Integer) 0,miQueue.dequeue());
	}

}
