
import static org.junit.Assert.*;
import org.junit.Test;

import uy.edu.um.prog2.adt.Hash.Exceptions.*;
import uy.edu.um.prog2.adt.Hash.*;

public class TestHashCerrado {

	@Test
	public void testInsertar() {
		HashTable<Integer, Integer> hash = new HashCerrado<>(5, true);
		try {
			hash.insertar(1, 1);
			hash.insertar(2, 2);
			hash.insertar(3, 3);
			hash.insertar(4, 4);
			hash.insertar(5, 5);

		} catch (ElementoYaExistenteException e) {
			fail();
		}

		assertTrue(hash.pertenece(1));
		assertTrue(hash.pertenece(2));
		assertTrue(hash.pertenece(3));
		assertTrue(hash.pertenece(4));
		assertTrue(hash.pertenece(5));

		assertFalse(hash.pertenece(6));

		try {
			hash.insertar(6, 6);
		} catch (ElementoYaExistenteException e) {
			fail();
		}
		assertTrue(hash.pertenece(6));
		assertFalse(hash.pertenece(7));
		
		try {
			hash.insertar(40,40);
		} catch (ElementoYaExistenteException e) {
			fail();
		}
		assertTrue(hash.pertenece(40));
	}

	@Test
	public void testEliminar() {
		HashTable<Integer, Integer> hash = new HashCerrado<>(5, true);
		try {
			hash.insertar(1, 1);
			hash.insertar(2, 2);
		} catch (ElementoYaExistenteException e) {
			fail();
		}
		assertTrue(hash.pertenece(1));
		try {
			hash.borrar(1);
		} catch (ClaveInvalida e) {
			fail();
		}
		assertFalse(hash.pertenece(1));
		try {
			hash.borrar(3);
			fail();
		} catch (ClaveInvalida e) {
		}

		try {
			hash.borrar(2);
		} catch (ClaveInvalida e) {
			fail();
		}
		assertFalse(hash.pertenece(2));
	}
	
	@Test
	public void testInsertarCuadratico() {
		HashTable<Integer, Integer> hash = new HashCerrado<>(5, false);
		try {
			hash.insertar(0, 0);
			hash.insertar(10, 10);
			hash.insertar(20, 20);
		} catch (ElementoYaExistenteException e) {
			fail();
		}
		assertTrue(hash.pertenece(0));
	}	
	
	@Test
	public void testBorrarCuadratico() {
		HashTable<Integer, Integer> hash = new HashCerrado<>(5, false);
		try {
			hash.insertar(0, 0);
			hash.insertar(10, 10);
			hash.insertar(20, 20);
		} catch (ElementoYaExistenteException e) {
			fail();
		}
	}
	@Test
	public void testObtener() {
		HashCerrado<String, Integer> hash = new HashCerrado<>(5, true);
		try {
			hash.insertar("uno", 1);
			hash.insertar("dos", 2);
			hash.insertar("tres",3);
			hash.insertar("cuatro", 4);
			hash.insertar("cinco", 5);

		} catch (ElementoYaExistenteException e) {
			fail();
		}
		
		assertNull(hash.obtener("u"));
		assertEquals((Integer) 2, hash.obtener("dos"));
		assertEquals((Integer) 1, hash.obtener("uno"));
		assertEquals((Integer) 4, hash.obtener("cuatro"));
		assertEquals((Integer) 5, hash.obtener("cinco"));
		assertNull(hash.obtener("uasd"));
		assertEquals((Integer) 3, hash.obtener("tres"));
		assertEquals((Integer) 1, hash.obtener("uno"));
		assertNull(hash.obtener("uasdf"));	
	}

	

}
