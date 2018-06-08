import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uy.edu.um.prog2.*;
import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class testFileToObject {

	@Test
	public void testLoadFiles() throws IOException, PosicionInvalida, EmptyQueueException, InvalidFile {
		long startTime=System.currentTimeMillis();
		FileToObjects carga = new FileToObjects();
		carga.loadFiles("tabla_datos.CSV");
		assertTrue(true);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
//		Reporte reporte = new Reporte();
//		reporte.reporte1();
	}

}
