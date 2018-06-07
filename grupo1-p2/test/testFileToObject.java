import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uy.edu.um.prog2.*;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class testFileToObject {

	@Test
	public void testLoadFiles() throws IOException, PosicionInvalida, EmptyQueueException {
		FileToObjects carga = new FileToObjects();
		carga.loadFiles("tabla_datos.CSV");
		assertTrue(true);
		
//		Reporte reporte = new Reporte();
//		reporte.reporte1();
	}

}
