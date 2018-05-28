package um.Recursividad.Test;
import um.Recursividad.Recursividad;
import um.Recursividad.Exceptions.ExceptionNumeroNoCorrespondiente;

import static org.junit.Assert.*;

import org.junit.Test;

public class testRecursividad {

	@Test
	public void testFactorial() throws ExceptionNumeroNoCorrespondiente {
		Recursividad miRec = new Recursividad();
		assertEquals(24,miRec.factorial(4));
		try{
			miRec.factorial(-1);
		}catch(ExceptionNumeroNoCorrespondiente e) {
			System.out.println(e.getMessage());
		}
	}


	
	@Test
	public void testPow() {
		Recursividad miRec = new Recursividad();
		assertEquals((double)8,miRec.pow(2, 3),0.1);
	}

	@Test
	public void testSumaN() throws ExceptionNumeroNoCorrespondiente{
		Recursividad miRec = new Recursividad();
		assertEquals(10, miRec.sumN(4));
		try {
			miRec.sumN(-1);
		}catch(ExceptionNumeroNoCorrespondiente e) {
			System.out.println(e.getMessage());
		}
	}
}
