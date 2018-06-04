import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uy.edu.um.prog2.*;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Queue.Exceptions.EmptyQueueException;

public class testV0 {

	@Test
	public void test() throws IOException, PosicionInvalida, EmptyQueueException {
		FileToObjects carga = new FileToObjects();
		carga.loadFiles();
		Reporte reporte = new Reporte();
		reporte.reporte1();
	}

}
