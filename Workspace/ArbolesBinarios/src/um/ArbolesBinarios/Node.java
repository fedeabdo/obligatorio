package um.ArbolesBinarios;


public class Node <K, T>{
	private K key;
	private T data;
	private Node<K, T> leftChild;
	private Node<K, T> rightChild;
	
	public Node( K key, T data) {
		this.key = key;
		this.data = data;
	}
	
	public Node<K,T> find(K key){
		Node<K,T> NodeExit = null;
		if(this.key.equals(key)) {
			//Encontramos el nodo que buscamos.
			NodeExit = this;
		}else {
			if( this.leftChild !=null ) {
				NodeExit = this.leftChild.find(key);
			}
			if(NodeExit == null && this.rightChild != null){
				NodeExit = this.rightChild.find(key);
			}
		}
		return NodeExit;
	}
	
	public Node<K,T> findParent(K key){
		Node<K,T> parentNode = null;
		if(this.leftChild.getKey().equals(key) || this.rightChild.getKey().equals(key)) {
			if (this.leftChild.getKey().equals(key))
				parentNode = leftChild;
			else if(this.rightChild.getKey().equals(key))
				parentNode = rightChild;
		}else {
			if (this.getLeftChild()!=null) {
				parentNode = getLeftChild().findParent(key);
			}else if (parentNode == null && this.getRightChild() != null) {
				parentNode = getRightChild().findParent(key);
			}
		}
		return parentNode;
	}
//	public void insert(K key, T data, K parentKey) {
//		if(this.key == parentKey) {
//			if (this.getLeftChild() !=null) {
//				this.setLeftChild(new Node<>(key,data));
//			}else if (this.getRightChild()!=null) {
//				this.setRightChild(new Node<>(key,data));
//			}
//		}else {
//			if (this.getLeftChild() !=null) {
//				this.getLeftChild().insert(key, data, parentKey);
//			}else if (this.getRightChild()!=null) {
//				this.getRightChild().insert(key,data,parentKey);
//			}
//		}
//		Node<K,T> parentNode = find(parentKey);
//		Node<K,T> Node = new Node<>(key,data);
//		if(parentNode.getLeftChild()==null) {
//			parentNode.setLeftChild(Node);
//		}else if(parentNode.getRightChild()==null) {
//			parentNode.setRightChild(Node);
//		}
//	}
	
	public Node<K, T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node<K, T> rightChild) {
		this.rightChild = rightChild;
	}
	public Node<K, T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node<K, T> leftChild) {
		this.leftChild = leftChild;
	}
	public K getKey() {
		return key;
	}
	public T getData() {
		return data;
	}
	

	
	
}
