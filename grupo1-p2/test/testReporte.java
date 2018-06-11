import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import uy.edu.um.prog2.Reporte;
import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class testReporte {

	@Ignore
	public void testReporte1() throws InvalidFile {
		Reporte reporte = new Reporte("tabla_datos.CSV");
		System.out.println("termine carga");
		try {
			reporte.reporte1();
		} catch (EmptyQueueException e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public void testResporte3() throws InvalidFile {
		Reporte reporte = new Reporte("tabla_datos.CSV");
		reporte.reporte3();
		assertTrue(true);
	}
	
	@Ignore
	public void testReporte4() throws InvalidFile {
		Reporte reporte = new Reporte("tabla_datos.CSV");
		reporte.reporte4();
		assertTrue(true);
		
	}

}
