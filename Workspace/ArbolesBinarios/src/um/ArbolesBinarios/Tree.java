package um.ArbolesBinarios;

import um.ArbolesBinarios.Exception.TreeException;

public class Tree<K, T> implements MyTree<K, T> {
	private Node<K, T> root;

	@Override
	public T find(K key) throws TreeException {
		T dataExit = null;
		if(root == null) {
			TreeException e = new TreeException("El arbol esta vacio.");
			throw e;
		}else {
			dataExit = root.find(key) == null ? null : root.find(key).getData();
		//Es lo mismo que este if...
//		if( root.find(key) == null) {
//			dataExit = root.find(key).getData();
//		}
		}
		return dataExit;
	}
	
	@Override
	public void insert(K key, T data, K parentKey) throws TreeException {
		// TODO Auto-generated method stub
		if(parentKey == null) {
			//raiz
			Node<K,T> oldRoot = root;
			if(root == null) {
				root = new Node<>(key,data);
			}else {
				Node<K,T> oRoot = new Node<>(key,data);
				oRoot.setLeftChild(oldRoot);
				this.root = oRoot;
			}
		}else {
			Node<K,T> parentNode = root.find(parentKey);
			boolean b = false;
			if(parentNode.getLeftChild()!=null) {
				parentNode.setLeftChild(new Node<>(key,data));
				b=true;
			}else if(!b && parentNode.getRightChild()!=null) {
				parentNode.setRightChild(new Node<>(key,data));
			}else if(!b) {
				TreeException e = new TreeException("El padre que quiere agregarle un hijo ya tiene dos hijos.");
				throw e;
			}
			
		}

	}

	@Override
	public void delete(K key) throws TreeException{
		// TODO Auto-generated method stub
		Node<K,T> dNode = null;
		if(root == null) {
			TreeException e = new TreeException("El arbol esta vacio.");
			throw e;
		}else {
			dNode = root.find(key);
			if(dNode == null) {
				TreeException e = new TreeException("El elemento con la key " + key + " a borrar no existe.");
				throw e;
			}else {
				
			}
		}

	}

}
