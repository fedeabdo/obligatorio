import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

import uy.edu.um.prog2.*;
import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;
import uy.edu.um.prog2.reportes.Reporte1;

public class testFileToObject {

	@Test
	public void testLoadFiles() throws IOException, PosicionInvalida, EmptyQueueException, InvalidFile {
		long startTime = System.currentTimeMillis();
		FileToObjects carga = new FileToObjects();
		carga.loadFiles("tabla_datos.CSV");
		assertTrue(true);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + "  milisegundos");

		// HashTable<String, Producto> hashProductos = carga.getProductos();
		// Iterator itProductos=hashProductos.iterator();
		// int i=1;
		// while(itProductos.hasNext()) {
		// System.out.println(i + " " + ((Producto)itProductos.next()).getNombre());
		// i++;
		// }

		// Reporte reporte = new Reporte();
		// reporte.reporte1();
	}
	//

	// @Test

}
