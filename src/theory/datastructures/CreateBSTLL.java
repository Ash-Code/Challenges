package theory.datastructures;

public class CreateBSTLL<T> extends LinkedList<T> {

	public Node<Integer> createBST(Link<Integer> start) {
		if (start == null)
			return null;
		if (start.next == null)
			return new Node<Integer>(start.object, null, null, null);

		Link<Integer> slow = start;
		Link<Integer> fast = start;
		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null&&fast.next.next!=null) {
				slow = slow.next;
				fast = fast.next;
			}

		}
		if(fast.next!=null)
			fast=fast.next;

		Link<Integer> left = start;
		Link<Integer> piv = slow.next;
		slow.next = null;
		Node<Integer> node = new Node<Integer>(piv.object, null, null, null);
		Link<Integer> right = piv.next;
		piv.next = null;
		node.left = createBST(left);
		if (node.left != null)
			node.left.parent = node;
		node.right = createBST(right);
		if (node.right != null)
			node.right.parent = node;
		return node;
	}

	public static void main(String args[]) {
		CreateBSTLL<Integer> list = new CreateBSTLL<Integer>();
		for (int i = 1; i < 13; i++)
			list.add(i);
		BST<Integer> tree = new BST<Integer>();
		Node<Integer> node = list.createBST(list.head);
		tree.root = node;
		tree.inOrder();
		list.print();
	}

}
