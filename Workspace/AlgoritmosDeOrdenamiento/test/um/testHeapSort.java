package um;

import static org.junit.Assert.*;
import static um.HeapSort.order;
import org.junit.Test;

public class testHeapSort {

	@Test
	public void testOrder() {
		Integer[] array = new Integer[5];
		array[4] = 5;
		array[3] = 4;
		array[2] = 3;
		array[1] = 2;
		array[0] = 1;
		Integer [] test = order(array);
		
		assertEquals(array[0], test[0]);
		assertEquals(array[1], test[1]);
		assertEquals(array[2], test[2]);
		assertEquals(array[3], test[3]);
		assertEquals(array[4], test[4]);
	}
	

}
