

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Tree.*;
import uy.edu.um.prog2.adt.Tree.Exceptions.InvalidKey;
//import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;

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
//		oT.insert(10, "tercerElemento");
//		oT.insert(7, "cuartoElemento");
//		oT.insert(6, "quintoElemento");
	
		try {
			oT.delete(5);
			oT.delete(2);
		} catch (InvalidKey e) {
			fail();
		}
		
		try {
			oT.delete(11);
			fail();
		} catch (InvalidKey e) {}
		
		
		/*try {
			assertEquals(oT.inOrder().get(0), "segundoElemento");
			assertEquals(oT.inOrder().get(1), "quintoElemento");
			assertEquals(oT.inOrder().get(2), "cuartoElemento");
			assertEquals(oT.inOrder().get(3), "tercerElemento");
		}catch(posicionInvalida e) {
			System.out.println("error");
		}*/
		
	}
	
}
