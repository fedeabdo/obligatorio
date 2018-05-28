package uy.edu.um.prog2.adt.Heap;


public class HeapImpl<P extends Comparable<P>, T> implements MyHeap<P, T> {
	private NodoHeap<P, T>[] elements;
	private int size = 0;
	private int tipoArbol;

	public NodoHeap<P, T>[] getElements() {
		return elements;
	}

	@SuppressWarnings("unchecked")
	public HeapImpl(int size, int tipoArbol) {
		elements = new NodoHeap[size];
		if (tipoArbol == -1 || tipoArbol == 1) {
			this.tipoArbol = tipoArbol;
		} else {
			System.out.println("Error: Ingrese un tipo de arbol valido");
		}
	}

	public boolean isEmpty() {
		boolean isEmpty = false;
		if (size == 0) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public void insert(P priority, T data) {
		int nPosActual = size;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		NodoHeap<P, T> nuevoNodo = new NodoHeap(priority, data);
		elements[size] = nuevoNodo;
		if (tipoArbol == 1) {
			while (getParent(nPosActual) != null
					&& getParent(nPosActual).getPriority().compareTo(nuevoNodo.getPriority()) < 0) {
				NodoHeap<P, T> padre = elements[getPosParent(nPosActual)];
				elements[getPosParent(nPosActual)] = nuevoNodo;
				elements[nPosActual] = padre;
				nPosActual = getPosParent(nPosActual);
			}
		} else {
			while (getParent(nPosActual) != null
					&& getParent(nPosActual).getPriority().compareTo(nuevoNodo.getPriority()) > 0) {
				NodoHeap<P, T> padre = elements[getPosParent(nPosActual)];
				elements[getPosParent(nPosActual)] = nuevoNodo;
				elements[nPosActual] = padre;
				nPosActual = getPosParent(nPosActual);
			}
		}
		size++;
	}

	public void delete() {
		elements[0] = elements[size - 1];
		elements[size - 1] = null;
		size--;
		int posActual = 0;
		NodoHeap<P, T> padre = elements[posActual];

		if (tipoArbol == 1) {
			while ((getLeftChild(posActual) != null
					&& padre.getPriority().compareTo(getLeftChild(posActual).getPriority()) < 0)
					|| (getRightChild(posActual) != null
							&& padre.getPriority().compareTo(getRightChild(posActual).getPriority()) < 0)) {
				if (getRightChild(posActual) != null && getLeftChild(posActual) != null) {
					if (getRightChild(posActual).getPriority().compareTo(getLeftChild(posActual).getPriority()) < 0) {
						elements[posActual] = getLeftChild(posActual);
						elements[getPosLeftChild(posActual)] = padre;
						posActual = getPosLeftChild(posActual);
						padre = elements[posActual];
					} else {
						elements[posActual] = getRightChild(posActual);
						elements[getPosRightChild(posActual)] = padre;
						posActual = getPosRightChild(posActual);
						padre = elements[posActual];
					}
				} else {
					elements[posActual] = getLeftChild(posActual);
					elements[getPosLeftChild(posActual)] = padre;
					posActual = getPosLeftChild(posActual);
					padre = elements[posActual];
				}

			}
		} else {
			while ((getLeftChild(posActual) != null
					&& padre.getPriority().compareTo(getLeftChild(posActual).getPriority()) > 0)
					|| (getRightChild(posActual) != null
							&& padre.getPriority().compareTo(getRightChild(posActual).getPriority()) > 0)) {
				if (getRightChild(posActual) != null && getLeftChild(posActual) != null) {
					if (getRightChild(posActual).getPriority().compareTo(getLeftChild(posActual).getPriority()) > 0) {
						elements[posActual] = getLeftChild(posActual);
						elements[getPosLeftChild(posActual)] = padre;
						posActual = getPosLeftChild(posActual);
						padre = elements[posActual];
					} else {
						elements[posActual] = getRightChild(posActual);
						elements[getPosRightChild(posActual)] = padre;
						posActual = getPosRightChild(posActual);
						padre = elements[posActual];
					}
				} else {
					elements[posActual] = getLeftChild(posActual);
					elements[getPosLeftChild(posActual)] = padre;
					posActual = getPosLeftChild(posActual);
					padre = elements[posActual];
				}

			}
		}
	}

	public T get() {
		T raiz = elements[0].getData();
		return raiz;
	}

	private NodoHeap<P, T> getParent(int nPos) {
		NodoHeap<P, T> oResult = null;
		if (nPos > 0) {
			oResult = elements[getPosParent(nPos)];
		}
		return oResult;
	}

	private int getPosParent(int nPos) {
		int nValue = 0;
		if (nPos > 0) {
			nValue = (nPos - 1) / 2;
		}
		return nValue;
	}

	private int getPosLeftChild(int pos) {
		int posChild = 2 * pos + 1;
		if (posChild > (size - 1)) {
			posChild = 0;
		}
		return posChild;
	}

	private int getPosRightChild(int pos) {
		int posChild = 2 * pos + 2;
		if (posChild > (size - 1)) {
			posChild = 0;
		}
		return posChild;
	}

	private NodoHeap<P, T> getLeftChild(int pos) {
		NodoHeap<P, T> child = null;
		if (getPosLeftChild(pos) != 0) {
			child = elements[getPosLeftChild(pos)];
		}
		return child;
	}

	private NodoHeap<P, T> getRightChild(int pos) {
		NodoHeap<P, T> child = null;
		if (getPosRightChild(pos) != 0) {
			child = elements[getPosRightChild(pos)];
		}
		return child;
	}

}
