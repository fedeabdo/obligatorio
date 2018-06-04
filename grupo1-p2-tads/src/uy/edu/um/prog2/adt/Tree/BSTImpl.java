package uy.edu.um.prog2.adt.Tree;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.Exceptions.PosicionInvalida;
import uy.edu.um.prog2.adt.Tree.Exceptions.InvalidKey;

public class BSTImpl<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {
	private NodeBST<K, T> root;

	public T find(K key) {
		T elementData = null;
		if (root != null) {
			NodeBST<K, T> aux = root;
			while (aux != null) {
				if (key.compareTo(aux.getKey()) < 0) {
					aux = aux.getLeftChild();
				} else if (key.compareTo(aux.getKey()) > 0) {
					aux = aux.getRightChild();
				} else {
					elementData = aux.getData();
					aux = null;
				}
			}
		}
		return elementData;
	}

	public void insert(K key, T data) {
		NodeBST<K, T> element = new NodeBST<K, T>(key, data);
		if (root == null) {
			root = element;
		} else {
			NodeBST<K, T> aux = root;
			int trigger = 0;
			while (trigger == 0) {
				if (element.getKey().compareTo(aux.getKey()) < 0) {
					if (aux.getLeftChild() != null) {
						aux = aux.getLeftChild();
					} else {
						trigger = -1;
					}
				} else {
					if (aux.getRightChild() != null) {
						aux = aux.getRightChild();
					} else {
						trigger = 1;
					}
				}
			}
			if (trigger == -1) {
				aux.setLeftChild(element);
			} else {
				aux.setRightChild(element);
			}
		}
	}

	public void delete(K key) throws InvalidKey{
		NodeBST<K, T> aEliminar = findNodeInAll(key);
		if(aEliminar==null) {
			throw new InvalidKey();
		}
		NodeBST<K, T> replacement = null;
		K keyAux = null;
		T dataAux = null;
		if (aEliminar.getLeftChild() != null) {
			replacement = findReplacement(aEliminar, 'l');
			keyAux = replacement.getKey();
			dataAux = replacement.getData();
			replacement.setKey(aEliminar.getKey());
			replacement.setData(aEliminar.getData());
			aEliminar.setKey(keyAux);
			aEliminar.setData(dataAux);
			delete(key);
		} else if (aEliminar.getRightChild() != null) {
			replacement = findReplacement(aEliminar, 'r');
			keyAux = replacement.getKey();
			dataAux = replacement.getData();
			replacement.setKey(aEliminar.getKey());
			replacement.setData(aEliminar.getData());
			aEliminar.setKey(keyAux);
			aEliminar.setData(dataAux);
			delete(key);
		} else {
			if (root.findParent(key) != null) {
				if (root.findParent(key).getLeftChild() == aEliminar) {
					root.findParent(key).setLeftChild(null);
				} else {
					root.findParent(key).setRightChild(null);
				}
			}else {
				root=null;
			}
		}
	}

	private NodeBST<K, T> findNodeInAll(K key) {
		NodeBST<K, T> element = null;
		if (root != null) {
			element = root.find(key);
		}
		return element;
	}

	private NodeBST<K, T> findReplacement(NodeBST<K, T> nodo, char tipo) {
		NodeBST<K, T> replacement = null;
		boolean condDeParada;
		switch (tipo) {
		case 'l':
			replacement = nodo.getLeftChild();
			condDeParada = true;
			while (condDeParada == true) {
				if (replacement.getRightChild() != null) {
					replacement = replacement.getRightChild();
				} else {
					condDeParada = false;
				}
			}
			break;
		case 'r':
			replacement = nodo.getRightChild();
			condDeParada = true;
			while (condDeParada == true) {
				if (replacement.getLeftChild() != null) {
					replacement = replacement.getLeftChild();
				} else {
					condDeParada = false;
				}
			}
			break;
		}
		return replacement;
	}

	public MiListaEnlazada<T> inOrder() {
		MiListaEnlazada<T> lista = new ListaEnlazadaSimple<T>();
		for (int i = 0; i < root.listaInOrder().tamanio(); i++) {
			try {
				lista.agregar((T) root.listaInOrder().obtener(i));
			} catch (PosicionInvalida e) {
				System.out.println("error");
			}
		}
		return lista;
	}
}
