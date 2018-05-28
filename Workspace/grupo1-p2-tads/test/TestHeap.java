

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import uy.edu.um.prog2.adt.Heap.*;
import org.junit.Test;

public class TestHeap {
	
	@Test
	public void testInsert() {
		MyHeap<Integer, String> heap=new HeapImpl<>(4, 1);
		heap.insert(50, "50");
		heap.insert(18, "18");
		heap.insert(20, "20");
				
		assertEquals(heap.get(), "50");
		
		heap.insert(55, "55");

		assertEquals(heap.get(), "55");
		
		try {
			heap.insert(5,"5");
			fail();
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void testDelete() {
		MyHeap<Integer, String> heap=new HeapImpl<>(10, 1);
		heap.insert(50, "50");
		heap.insert(18, "18");
		heap.insert(20, "20");
		heap.insert(55, "55");
		
		assertEquals(heap.get(), "55");
		
		heap.delete();
		
		assertEquals(heap.get(), "50");
		
		heap.delete();
		heap.delete();
		heap.delete();
		
	}
}
