package theory.datastructures;

public class MergeSortLL<T> extends LinkedList<T> {

	// nice clean algo.
	public Link<Integer> mergeSort(Link<Integer> start) {
		if (start == null)
			return null;

		if (start.next == null)
			return start;

		Link<Integer> slow = start;
		Link<Integer> fast = start;
		// the fast is advanced and then slow. So that fast may not end at null
		// and slow at mid+1 position in case of even length lists
		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}

		Link<Integer> right = slow.next;
		Link<Integer> left = start;
		slow.next = null;
		left = mergeSort(left);// sort and reassign
		right = mergeSort(right);// sort and reassign
		return sortedMerge(left, right);

	}

	// the Sorted merger
	public Link<Integer> sortedMerge(Link<Integer> a, Link<Integer> b) {
		Link<Integer> head = null;
		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.object <= b.object) {
			head = a;
			a = a.next;
		} else {
			head = b;
			b = b.next;
		}
		Link<Integer> trail = head;
		trail.next = null;
		while (true) {
			if (a == null) {
				trail.next = b;
				break;
			}
			if (b == null) {
				trail.next = a;
				break;
			}
			if (a.object <= b.object) {
				trail.next = a;
				a = a.next;
			} else {
				trail.next = b;
				b = b.next;
			}
			trail = trail.next;
			trail.next = null;

		}

		return head;

	}

	// ---------------------------------------------
	public void rotate(int k) {
		int count = 0;
		while (count < k) {
			Link temp = head;
			head = head.next;
			tail.next = temp;
			tail = tail.next;
			tail.next = null;
			count++;
		}
	}

	// ------------------------------------------------

	public Node<Integer> createBST(Link<Integer> start) {
		if (start == null)
			return null;
		if (start.next == null)
			return new Node<Integer>(start.object, null, null, null);

		Link<Integer> slow = start;
		Link<Integer> fast = start;
		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}

		}

		Link<Integer> left = start;
		Link<Integer> piv = slow.next;
		slow.next=null;
		Node<Integer> node = new Node(piv.object, null, null, null);
		Link<Integer> right = piv.next;
		piv.next=null;
		node.left = createBST(left);
		if(node.left!=null)
			node.left.parent=node;
		node.right = createBST(right);
		if(node.right!=null)
			node.right.parent=node;
		return node;
	}

	
	
	// ------------------------------------------------
	public static void main(String args[]) {
		System.out.println("dsadsd");
		MergeSortLL<Integer> list = new MergeSortLL<Integer>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		list.print();

		Node<Integer> node=list.createBST(list.head);
		System.out.println(node.data+" "+node.left.right.data+" "+node.right.data);
	BST<Integer> tree=new BST<Integer>();
	tree.root=node;
	tree.inOrder();
		
		// list.mergeSort(list.head);
		list.print();
	}

}
