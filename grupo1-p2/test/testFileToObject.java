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
		long startTime=System.currentTimeMillis();
		FileToObjects carga = new FileToObjects();
		carga.loadFiles("tabla_datos.CSV");
		assertTrue(true);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		HashTable<Long, Empresa> hashEmpresas = carga.getEmpresas();
		Iterator itEmpresas=hashEmpresas.iterator();
		int i=0;
		while(itEmpresas.hasNext()) {
			System.out.println(i + "   " + ((Empresa)itEmpresas.next()).getNombre());
			i++;
		}
		
		
//		Reporte reporte = new Reporte();
//		reporte.reporte1();
	}
//	
	
	
	public void testReporte1() throws InvalidFile {
		Reporte reporte=new Reporte("tabla_datos.CSV");
		System.out.println("termine carga");
		try {
			reporte.reporte1();
		} catch (EmptyQueueException e) {
			fail();
			e.printStackTrace();
		}
	}

}
