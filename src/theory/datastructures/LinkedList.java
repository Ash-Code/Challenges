package theory.datastructures;

public class LinkedList<T> {
	protected Link<T> head;
	protected Link<T> tail;// there is no O(1) remove operation for LinkedLists.
							// Its
	// possible
	// only if the pointer to the link/node is provided, which
	// cannot be accessed since it is defined and produced by
	// the
	// linkedList itself. So for every node to delete, we
	// iterate
	// through the list till we find the required object, get
	// it's
	// node's pointer and unlink it (see Sun's java code)

	protected int size = 0;

	public LinkedList() {
		size = 0;
	}

	public void add(T elm) {
		Link<T> link = new Link<T>(elm);
		if (tail == null) {
			tail = link;
			head = link;
		} else {
			tail.next = link;
			tail = link;
		}
		size++;
	}

	public void removeFirst() {
		if (head == null)
			throw new ArrayIndexOutOfBoundsException();
		else
			head = head.next;
		size--;

	}

	// ------------Searching funcs
	protected Link<T> search(T elm) {
		Link<T> temp = head;
		while (temp != null) {
			if (temp.object == elm)
				return temp;

			temp = temp.next;

		}
		return null;
	}

	public int searchIndex(T elm) {
		int count = 0;
		Link<T> temp = head;
		while (temp != null) {
			count++;
			if (temp.object == elm)
				return count;

			temp = temp.next;

		}
		count--;
		return count;

	}

	public T searchObject(T elm) {
		Link<T> temp = search(elm);
		return temp.object;
	}

	// -----------------------------------------
	public void print() {
		Link<T> temp = head;
		System.out.println("LinkedList : size= " + getSize() + " head= "
				+ getHead() + " tail=" + getTail());
		while (temp != null) {
			System.out.println(temp.object.toString());
			temp = temp.next;
		}
	}

	// ----------------Deleting functions
	public void removeTail() {
		if (tail == null)
			return;

		Link<T> prev = head;
		if (tail == head) {
			tail = head = null;
			size = 0;
			return;
		}
		while (prev.next != tail)
			prev = prev.next;
		prev.next = null;
		tail = prev;
		size--;

	}

	protected void deleteLink(Link<T> del) {// O(1) deletion really nice trick
		if (del.next == null) {
			removeTail();
			return;
		}
		if (del == head) {
			removeFirst();
			return;
		}

		del.object = del.next.object;
		if (del.next == tail)
			tail = del;
		del.next = del.next.next;
		size--;

	}

	public boolean delete(T elm) {
		Link<T> x = search(elm);
		if (x == null)
			return false;
		deleteLink(x);
		return true;
	}

	// -----------------------------------Getters-------------

	public T getTail() {
		if(tail==null)
			return null;
		return tail.object;
	}

	public T getHead() {
		return head.object;
	}

	public int getSize() {
		return size;
	}

	
}
