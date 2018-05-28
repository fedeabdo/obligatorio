package um;

import static org.junit.Assert.*;
import static um.MergeSort.order;

import org.junit.Test;

public class testMergeSort {

	@Test
	public void test() {
		Integer[] array = new Integer[5];
		array[0] = 5;
		array[2] = 4;
		array[1] = 3;
		array[4] = 2;
		array[3] = 1;
		Integer [] test = order(array);
		
		assertEquals(array[3], test[0]);
		assertEquals(array[4], test[1]);
		assertEquals(array[1], test[2]);
		assertEquals(array[2], test[3]);
		assertEquals(array[0], test[4]);
	}

}
