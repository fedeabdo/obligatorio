package um.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import um.Exceptions.EmptyStackException;
import um.StackListaEnlazada.Stack;

public class testStackListaEnlazada {

	@Test(expected = EmptyStackException.class)
	public void testPopException() throws EmptyStackException{
		Stack<Object> miLista = new Stack<>();
			miLista.pop();
	}
	
	@Test(expected = EmptyStackException.class)
	public void testTopException() throws EmptyStackException{
		Stack<Object> miLista = new Stack<>();
		miLista.top();
	}
	
	@Test
	public void testSize() {
		Stack<Object> miLista = new Stack<>();
		assertEquals( miLista.size(),0);
	}
	@Test
	public void testPush() {
		Stack<Integer> miLista = new Stack<>();
//		miLista.push(2);
		miLista.push(1);
		miLista.push(1);
		assertEquals("Sabelo",2,miLista.size());
	}
	
	@Test
	public void testTop() throws EmptyStackException {
		Stack<Integer> miLista = new Stack<>();
		Integer n = 2;
		miLista.push(n);
		assertEquals(n,miLista.top());
	}
	
	@Test
	public void testIsEmpty() throws EmptyStackException {
		Stack<Integer> miLista = new Stack<>();
		miLista.push(2);
		miLista.push(2);
		miLista.push(2);
		miLista.makeEmpty();
		assertTrue(miLista.isEmpty());
	}
	
	@Test
	public void testMakeEmpty() throws EmptyStackException{
		Stack<Integer> miLista = new Stack<>();
		miLista.push(2);
		miLista.push(2);
		assertEquals(2,miLista.size());
		miLista.makeEmpty();
		assertTrue(miLista.isEmpty());
	}
	
	@Test
	public void testPop() throws EmptyStackException{
		Stack<Integer> miLista = new Stack<>();
		miLista.push(2);
		miLista.push(2);
		assertEquals(2,miLista.size());
		miLista.pop();
		assertEquals(1,miLista.size());
		miLista.pop();
	}
}
