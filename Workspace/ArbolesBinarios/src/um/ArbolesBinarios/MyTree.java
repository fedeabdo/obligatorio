package um.ArbolesBinarios;

import um.ArbolesBinarios.Exception.TreeException;

public interface MyTree<K, T> {
	T find (K key) throws TreeException;
	void insert (K key, T data, K parentKey) throws TreeException;
	void delete (K key) throws TreeException;
}
