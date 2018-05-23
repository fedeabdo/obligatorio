package uy.edu.um.prog2.adt.Heap;

public interface MyHeap<P extends Comparable<P>, T> {
	public void insert(P priority, T data);

	public void delete();

	public T get();
	
	public boolean isEmpty();

}
