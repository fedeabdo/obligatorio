

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Tree.*;
//import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TestBST {
		
	@Test
	public void testInsert() {
		MyBinarySearchTree<Integer, String> oT=new BSTImpl<Integer, String>();
		oT.insert(5, "Raiz");
		oT.insert(2, "segundoElemento");
		oT.insert(7, "tercerElemento");
		oT.insert(9, "cuartoElemento");
		
		try {
			assertEquals(oT.inOrder().obtener(0), "segundoElemento");
			assertEquals(oT.inOrder().obtener(1), "Raiz");
			assertEquals(oT.inOrder().obtener(2), "tercerElemento");
			assertEquals(oT.inOrder().obtener(3), "cuartoElemento");
		}catch(PosicionInvalida e) {}
		
		assertEquals(oT.find(5), "Raiz");
		assertEquals(oT.find(2), "segundoElemento");
		assertEquals(oT.find(9), "cuartoElemento");
		
	}
	
	@Test
	public void testDelete() {
		MyBinarySearchTree<Integer, String> oT = new BSTImpl<Integer, String>();
		oT.insert(5, "Raiz");
		oT.insert(2, "segundoElemento");
		oT.insert(10, "tercerElemento");
		oT.insert(7, "cuartoElemento");
		oT.insert(6, "quintoElemento");
	
		oT.delete(5);
//		oT.delete(10);
		
		try {
			assertEquals(oT.inOrder().obtener(0), "segundoElemento");
			assertEquals(oT.inOrder().obtener(1), "quintoElemento");
			assertEquals(oT.inOrder().obtener(2), "cuartoElemento");
			assertEquals(oT.inOrder().obtener(3), "tercerElemento");
		}catch(PosicionInvalida e) {
			fail();
		}
		
	}
	
}
