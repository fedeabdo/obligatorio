package um.test;
import um.Exceptions.EmptyStackException;
import um.Exceptions.NoEquilibrioDeSimbolos;
import um.equilibroDeSimbolos.EquilibrioDeSimbolos;

//import static org.junit.Assert.*;

import org.junit.Test;

public class testEquilibrioDeSimbolos {

	@Test
	public void test() throws EmptyStackException, NoEquilibrioDeSimbolos {
		EquilibrioDeSimbolos coso = new EquilibrioDeSimbolos();
		coso.aplicacion();
	}

}
