package um;

import static um.Insercion.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class testInsercion {

	@Test
	public void testOrder() {
		Integer[] array = new Integer[5];
		array[3] = 5;
		array[4] = 4;
		array[1] = 3;
		array[2] = 2;
		array[0] = 1;
		Integer [] test = order(array);
		
		assertEquals(array[0], test[0]);
		assertEquals(array[2], test[1]);
		assertEquals(array[1], test[2]);
		assertEquals(array[4], test[3]);
		assertEquals(array[3], test[4]);
	}

}
