package um.test;

import static org.junit.Assert.*;
import org.junit.Test;

import um.Exceptions.EmptyStackException;
import um.evaluarPostFija.evaluarPostFija;

public class testEvaluarPostFija {

	@Test
	public void test() throws EmptyStackException {
		evaluarPostFija evaluar = new evaluarPostFija();
		String sEvaluar = "2 1 -";
		int evaluacion = evaluar.evaluar(sEvaluar);
		assertEquals("Its oka y",1, evaluacion);
	}

}
