package um;
import static um.BubbleSort.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class testBubbleSort {

	@Test
	public void testOrder() {
		Integer[] array = new Integer[5];
		array[0] = 1;
		array[1] = 4;
		array[2] = 3;
		array[3] = 2;
		array[4] = 5;
		Integer [] test = order(array);
		
		assertEquals(array[0], test[0]);
		assertEquals(array[3], test[1]);
		assertEquals(array[2], test[2]);
		assertEquals(array[1], test[3]);
		assertEquals(array[4], test[4]);
	}
	
	@Test
	public void testOrderParInpar() {
		Integer[] array = new Integer[5];
		array[0] = 2;
		array[1] = 1;
		array[2] = 4;
		array[3] = 6;
		array[4] = 0;
		Integer [] test = orderParImpar(array);
		
		assertEquals(array[4], test[0]);
		assertEquals(array[1], test[1]);
		assertEquals(array[0], test[2]);
		assertEquals(array[2], test[3]);
		assertEquals(array[3], test[4]);
	}
	
}
