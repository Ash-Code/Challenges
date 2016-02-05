package theory.datastructures;

import java.util.Stack;

public class BST<T extends Comparable<? super T>> {
	public Node<T> root;

	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(Node<T> x) {
		if (x == null)
			return;
		inOrder(x.left);
		System.out.print(x.data + "("
				+ (x.parent == null ? x.parent : x.parent.data) + ") ");// the
																		// one
																		// with
																		// the
																		// null
																		// parent
																		// would
																		// represent
																		// the
																		// root
																		// node
		inOrder(x.right);
	}

	public void inOrderNoRec() {
		Node<T> curr = root;
		Stack<Node<T>> stack = new Stack<Node<T>>();

		boolean done = true;
		while (done) {

			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if (stack.isEmpty())
					break;
				curr = stack.pop();
				System.out.print(curr.data + " ");
				curr = curr.right;

			}

		}
	}

	public void preOrderNoRec() {
		Node<T> curr = root;
		Stack<Node<T>> stack = new Stack<Node<T>>();

		boolean done = true;
		while (done) {

			if (curr != null) {
				System.out.print(curr.data + " ");
				stack.push(curr);
				curr = curr.left;
			} else {
				if (stack.isEmpty())
					break;
				curr = stack.pop();
				curr = curr.right;

			}

		}
	}

	public Node<T> insert(T elm) {
		Node<T> z = new Node<T>(elm, null, null, null);
		if (root == null) {
			root = z;
		} else {
			Node<T> temp = root;
			Node<T> y = null;
			while (temp != null) {
				y = temp;
				if (temp.data.compareTo(elm) > 0)
					temp = temp.left;
				else
					temp = temp.right;
			}

			z.parent = y;
			if (y.data.compareTo(z.data) >= 0) {
				y.left = z;
			} else {
				y.right = z;
			}

		}
		return z;
	}

	public boolean search(T elm) {
		Node<T> temp = searchNode(elm);
		return temp != null;
	}

	public Node<T> searchNode(T elm) {// the problem was that if I'm using
										// Generic, I can't take nodes as
										// arguments, so I take T element as
										// argument, search for a node with that
										// Element everytime I need to perform a
										// delete, successor, etc process, since
										// that element might not be there in
										// the tree. Simple search returns true
										// if found a non null node
		Node<T> temp = root;
		while (temp != null) {
			if (temp.data.compareTo(elm) == 0)
				return temp;
			if (temp.data.compareTo(elm) > 0) {
				temp = temp.left;
			} else
				temp = temp.right;
		}

		return temp;
	}

	public void transplant(Node<T> u, Node<T> v) {
		if (u.parent == null)
			root = v;
		else if (u == u.parent.right)
			u.parent.right = v;// disband u, enter v
		else
			u.parent.left = v;
		if (v != null)
			v.parent = u.parent;// join the parent child relationship. Thats
								// all.
	}

	public T minimum() {
		return minimumNode(root).data;
	}

	public Node<T> minimumNode(Node<T> x) {// the reference is copied, all
											// modifications are on the copied
											// reference not on the original
											// pointer.
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}

	public Node<T> successor(Node<T> z) {
		if (z.right != null) {
			return minimumNode(z.right);
		} else {
			Node<T> y = z.parent;
			while (y != null && y.right == z) {
				z = y;
				y = y.parent;
			}
			return y;// if no successor is found, we'll reach the root, and
						// since y=y.p, y will become null and we'll return null

		}
	}

	public boolean delete(T elm) {
		Node<T> temp = searchNode(elm);
		if (temp == null)
			return false;
		if (temp.left == null) {// takes care of the case where both left and
								// right are null
			transplant(temp, temp.right);
		} else if (temp.right == null) {
			transplant(temp, temp.left);
		} else {
			Node<T> y = minimumNode(temp.right);
			if (y.parent != temp) {
				transplant(y, y.right);
				y.right = temp.right;
				y.right.parent = y;// its a 2 way connection
			}
			transplant(temp, y);
			y.left = temp.left;
			y.left.parent = y;

		}

		return true;
	}

}
