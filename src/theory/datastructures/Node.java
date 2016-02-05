package theory.datastructures;

public class Node<T extends Comparable<? super T>> {
	T data;
	Node<T> left;
	Node<T> right;
	Node<T> parent;

	public Node(T data, Node<T> left, Node<T> right, Node<T> parent) {
		this.data = data;
		this.parent = parent;
		this.right = right;
		this.left = left;

	}
}
