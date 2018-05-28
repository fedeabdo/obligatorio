package uy.edu.um.prog2.adt.Tree;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;

public class NodeBST<K extends Comparable<K>, T> {
	K key;
	T data;
	NodeBST<K, T> leftChild;
	NodeBST<K, T> rightChild;

	public NodeBST(K key, T data) {
		super();
		this.key = key;
		this.data = data;
		leftChild = null;
		rightChild = null;
	}

	public MiListaEnlazada<T> listaInOrder() {
		MiListaEnlazada<T> lista = new ListaEnlazadaSimple<T>();
		try {
			if (leftChild != null) {
				for (int i = 0; i < leftChild.listaInOrder().tamanio(); i++) {
					lista.agregar((T) leftChild.listaInOrder().obtener(i));
				}
			}
			lista.agregar(data);
			if (rightChild != null) {
				for (int i = 0; i < rightChild.listaInOrder().tamanio(); i++) {
					lista.agregar((T) rightChild.listaInOrder().obtener(i));
				}
			}
		} catch (PosicionInvalida e) {
			System.out.println("Ha ocurrido un error");
		}
		return lista;
	}

	public NodeBST<K, T> find(K key) {
		NodeBST<K, T> oExit = null;
		if (this.key == key) {
			oExit = this;
		} else if (this.leftChild == null && this.rightChild == null) {
			oExit = null;
		} else {
			if (this.leftChild != null) {
				oExit = leftChild.find(key);
			}
			if (oExit == null && this.rightChild != null) {
				oExit = this.rightChild.find(key);
			}
		}
		return oExit;
	}

	public NodeBST<K, T> findParent(K key) {
		NodeBST<K, T> parent = this;
		// NodeBST<K,T> oExit = null;
		if ((parent.getLeftChild() != null && parent.getLeftChild().getKey() == key)
				|| (parent.getRightChild() != null && parent.getRightChild().getKey() == key)) {
			parent = this;
		} else {
			if (parent.getLeftChild() != null && parent.getLeftChild().findParent(key) != null) {
				parent = parent.getLeftChild().findParent(key);
			} else if (parent.getRightChild() != null && parent.getRightChild().findParent(key) != null) {
				parent = parent.getRightChild().findParent(key);
			} else {
				parent = null;
			}
		}
		return parent;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeBST<K, T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeBST<K, T> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeBST<K, T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeBST<K, T> rightChild) {
		this.rightChild = rightChild;
	}

}
