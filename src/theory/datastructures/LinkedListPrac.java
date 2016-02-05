package theory.datastructures;

public class LinkedListPrac<T> extends LinkedList<T> {
	// -----------CheckPalindrome
	public class WrapPal {

		boolean isPal;
		Link<Integer> next;

		public WrapPal(boolean isPal, Link<Integer> link) {
			this.isPal = isPal;
			next = link;
		}

	}

	public WrapPal isPalin(Link<Integer> slow, Link<Integer> fast) {
		Link<Integer> curr = slow;
		if (fast.next == null) {
			return new WrapPal(true, slow.next);
		}
		if (fast.next.next == null) {
			return new WrapPal(slow.object == slow.next.object, slow.next.next);
		}

		WrapPal ret = isPalin(curr.next, fast.next.next);
		if (ret.isPal) {
			return new WrapPal(curr.object == ret.next.object, ret.next.next);
		} else {
			return new WrapPal(false, null);
		}

	}

	// ----------------------Alternate split
	public class Wrapper {
		Link<Integer> odd;
		Link<Integer> even;

		public Wrapper(Link<Integer> odd, Link<Integer> even) {
			this.odd = odd;
			this.even = even;
		}

	}

	public Wrapper split(Link<Integer> start) {
		if (start == null) {
			return new Wrapper(null, null);
		}
		if (start.next == null)
			return new Wrapper(start, null);

		Link<Integer> next = start.next.next;
		Link<Integer> odd = start;
		Link<Integer> even = start.next;
		Wrapper ret = split(next);
		odd.next = ret.odd;
		even.next = ret.even;
		return new Wrapper(odd, even);

	}

	// ----------------------------------------------------

	public Link<T> reverseK(Link<T> start, int K) {
		if (start == null)
			return null;
		Link<T> curr = start;
		Link<T> next = curr.next;
		Link<T> prev = null;
		int count = 1;
		while (next != null && count < K) {
			// System.out.println(curr.object);
			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr.next;
			count++;
		}
		if (prev != null)
			curr.next = prev;

		start.next = reverseK(next, K);
		return curr;

	}

	// ------------Reverse a linked List

	public Link<T> reverse() {

		if (head == null)
			return null;
		if (head.next == null)
			return head;
		Link<T> curr = head.next;
		Link<T> prev = head;
		Link<T> next = curr.next;
		head.next = null;
		tail = head;
		while (next != null) {

			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr.next;
		}

		curr.next = prev;
		head = curr;
		return head;
	}

	// ------------------Segregate odd even
	public Link<Integer> segregateOE(Link<Integer> node) {
		Link<Integer> odd = null;
		Link<Integer> oddHead = null;
		Link<Integer> evenHead = null;
		Link<Integer> even = null;

		if (node == null)
			return null;
		while (node != null) {
			if (node.object % 2 == 0) {
				if (even == null) {
					even = node;
					evenHead = even;
				} else {
					even.next = node;
					even = even.next;
				}
				node = node.next;
				even.next = null;
			} else {
				if (odd == null) {
					odd = node;
					oddHead = odd;
				} else {
					odd.next = node;
					odd = odd.next;
				}
				node = node.next;
				odd.next = null;

			}

		}
		if (odd == null)
			tail = (Link<T>) even;
		else
			tail = (Link<T>) odd;
		if (even != null)
			even.next = oddHead;
		if (even != null)
			return evenHead;
		else
			return oddHead;

	}

	// -------------------------------Swapping alternative nodes
	public void swapAlt() {
		Link<T> o;
		Link<T> e;
		Link<T> on;// tracks next odd
		Link<T> en;// tracks next even

		if (head == null || head.next == null)
			return;
		o = head;
		e = head.next;
		while (o != null && e != null) {
			if (e.next == null) {
				en = null;
				on = null;
			} else if (e.next.next == null) {
				en = e.next;
				on = null;
			} else {
				en = e.next.next;
				on = o.next.next;
			}

			e.next = o;
			o.next = en;
			if (o == head)
				head = e;
			if (e == tail)
				tail = o;
			o = on;
			e = en;// this is where the error occurs when list length is odd. In
					// odd length, en points to the next odd member not the next
					// even member according to the ifs
		}

	}

	// --------------------------Reverse alternate nodes and append at the end
	public Link<T> rec(Link<T> curr, Link<T> prev) {
		System.out.println("       at " + curr.object);
		if (curr.next == null) {
			return curr;
		}
		if (curr.next.next == null) {
			T temp = curr.object;
			deleteLink(curr);
			add(temp);
			return tail;
		}
		Link<T> ret = rec(curr.next.next, curr.next);
		// System.out.println("   ret "+ret.object+" curr: "+curr.object+" "+prev.object);
		prev.next = curr.next;
		ret.next = curr;
		curr.next = null;
		tail = curr;
		return tail;

	}

	public void reverseAlt() {
		Link<T> curr = head;
		if (size < 3)
			return;
		curr = curr.next;
		rec(curr, head);

	}

	public static void main(String args[]) {
		LinkedListPrac<Integer> list = new LinkedListPrac<>();
		for (int i = 0; i <= 10; i++)
			list.add(i);
		for (int i = 10; i >= 1; i--) {
			list.add(i);
		}
		
		LinkedListPrac<Integer>.WrapPal wrap=list.isPalin(list.head, list.head);
		System.out.println(wrap.isPal);

	}
}
