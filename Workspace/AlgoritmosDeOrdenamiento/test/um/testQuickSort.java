package um;

import static org.junit.Assert.*;
import static um.QuickSort.order;

import org.junit.Test;

public class testQuickSort {

	@Test
	public void test() {
		Integer[] array = new Integer[6];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[4] = 4;
		array[3] = 5;
		array[5] = 6;
		// 1 6 5 4 3 2
		Integer [] test = order(array);
		
		assertEquals(array[0], test[0]);
		assertEquals(array[1], test[1]);
		assertEquals(array[2], test[2]);
		assertEquals(array[4], test[3]);
		assertEquals(array[3], test[4]);
		assertEquals(array[5], test[5]);
	}

}
