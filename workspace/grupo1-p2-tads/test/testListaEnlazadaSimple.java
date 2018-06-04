import static org.junit.Assert.*;


import org.junit.Test;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.ListaEnlazadaSimple;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;

public class testListaEnlazadaSimple {

	@Test
	public void testFlujoNormal() throws PosicionInvalida {
		ListaEnlazadaSimple<Integer> miLista = new ListaEnlazadaSimple<>();
		miLista.agregar(0);
		miLista.agregar(1);
		miLista.agregar(5);
		
		assertEquals(Integer.valueOf(0),miLista.obtener(0));
		assertEquals(Integer.valueOf(1),miLista.obtener(1));
		assertEquals(Integer.valueOf(5),miLista.obtener(2));
		
		assertEquals(3,miLista.tamanio());
		
		miLista.eliminar(1);
		assertEquals(2,miLista.tamanio());
		assertEquals(Integer.valueOf(0),miLista.obtener(0));
		assertEquals(Integer.valueOf(5),miLista.obtener(1));
		
		miLista.addFirst(10);
		miLista.addLast(20);
		assertEquals(4,miLista.tamanio());
		assertEquals(Integer.valueOf(10),miLista.obtener(0));
		assertEquals(Integer.valueOf(0),miLista.obtener(1));
		assertEquals(Integer.valueOf(5),miLista.obtener(2));
		assertEquals(Integer.valueOf(20),miLista.obtener(3));
		
		miLista.agregarEnLugar(50, 1);
		assertEquals(5,miLista.tamanio());
		assertEquals(Integer.valueOf(10),miLista.obtener(0));
		assertEquals(Integer.valueOf(50),miLista.obtener(1));
		assertEquals(Integer.valueOf(0),miLista.obtener(2));
		assertEquals(Integer.valueOf(5),miLista.obtener(3));
		assertEquals(Integer.valueOf(20),miLista.obtener(4));
		
		miLista.agregarEnLugar(150, 3);
		assertEquals(Integer.valueOf(10),miLista.obtener(0));
		assertEquals(Integer.valueOf(50),miLista.obtener(1));
		assertEquals(Integer.valueOf(0),miLista.obtener(2));
		assertEquals(Integer.valueOf(150),miLista.obtener(3));
		assertEquals(Integer.valueOf(5),miLista.obtener(4));
		assertEquals(Integer.valueOf(20),miLista.obtener(5));
		
		assertTrue(miLista.esta(150)!=null);
		assertFalse(miLista.esta(34)!=null);
	}
	

}
