package uy.edu.um.prog2.adt.Heap;

public class NodoHeap<P extends Comparable<P>,T> {
	private P priority;
	private T data;
	
	public NodoHeap(P priority, T data) {
		this.priority = priority;
		this.data = data;
	}

	public P getPriority() {
		return priority;
	}

	public void setPriority(P priority) {
		this.priority = priority;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
