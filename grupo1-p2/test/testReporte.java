import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;
import uy.edu.um.prog2.reportes.Reporte;

public class testReporte {
	
	@Test
	public void testReporte1() throws InvalidFile, EmptyQueueException {
		long startTime = System.currentTimeMillis();
		Reporte reporte = new Reporte("tabla_datos.CSV");
		long finishTime = System.currentTimeMillis();
		System.out.println("Carga : " + (finishTime-startTime) + "  milisegundos");
		startTime = System.currentTimeMillis();
		reporte.reporte1();
		finishTime = System.currentTimeMillis();
		System.out.println("Reporte1 : " + (finishTime-startTime) + "  milisegundos");
		
	}
	
	@Test
	public void testReporte2() throws InvalidFile, EmptyQueueException {
		long startTime = System.currentTimeMillis();
		Reporte reporte = new Reporte("tabla_datos.CSV");
		long finishTime = System.currentTimeMillis();
		System.out.println("Carga : " + (finishTime-startTime) + "  milisegundos");
		startTime = System.currentTimeMillis();
		reporte.reporte2();
		finishTime = System.currentTimeMillis();
		System.out.println("Reporte2 : " + (finishTime-startTime) + "  milisegundos");
		
	}

	@Test
	public void testResporte3() throws InvalidFile {
		long startTime = System.currentTimeMillis();
		Reporte reporte = new Reporte("tabla_datos.CSV");
		long finishTime = System.currentTimeMillis();
		System.out.println("Carga : " + (finishTime-startTime) + "  milisegundos");
		startTime = System.currentTimeMillis();
		reporte.reporte3();
		finishTime = System.currentTimeMillis();
		System.out.println("Reporte3 : " + (finishTime-startTime) + "  milisegundos");
	}
	
	@Test
	public void testReporte4() throws InvalidFile {
		long startTime = System.currentTimeMillis();
		Reporte reporte = new Reporte("tabla_datos.CSV");
		long finishTime = System.currentTimeMillis();
		System.out.println("Carga : " + (finishTime-startTime) + "  milisegundos");
		startTime = System.currentTimeMillis();
		reporte.reporte4();
		finishTime = System.currentTimeMillis();
		System.out.println("Reporte4 : " + (finishTime-startTime) + "  milisegundos");
	}

}
