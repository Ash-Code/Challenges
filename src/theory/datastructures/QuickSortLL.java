package theory.datastructures;

public class QuickSortLL<T> extends LinkedList<T> {

	public class Wrapper {
		Link<Integer> pivot;
		Link<Integer> prevtoPivot;
		Link<Integer> ntail;
		Link<Integer> nhead;

		public Wrapper() {
			pivot = null;
			prevtoPivot = null;
			ntail = null;
			nhead = null;
		}
	}

	public Wrapper partition(Link<Integer> chead, Link<Integer> ctail,
			Link<Integer> prevHead) {

		Link<Integer> piv = ctail;
		Link<Integer> curr = chead;
		Link<Integer> thead = piv;
		Link<Integer> ttail = piv;
		Link<Integer> prevtoPivot = null;
		Link<Integer> tailNext = ctail.next;
		// The tail and head are always at the front and back, reassign if the
		// current list has them

		boolean assignHead = false;
		boolean assignTail = false;
		if (head == chead)
			assignHead = true;
		if (tail == ctail)
			assignTail = true;
		System.out.println((chead.object) + " " + (ctail.object) + " "
				+ (prevHead == null));

		// Numbers are added with backward and forward attatchment-->The MEAT

		while (curr != piv) {
			System.out.println("        " + curr.object + " " + thead.object
					+ " " + ttail.object);
			Link<Integer> temp = curr.next;
			if (curr.object <= piv.object) {
				if (thead == piv) {
					curr.next = piv;
					prevtoPivot = curr;
				} else
					curr.next = thead;

				thead = curr;
				curr = temp;
			} else {
				curr.next = ttail.next;
				ttail.next = curr;
				ttail = curr;
				curr = temp;
			}
		}
		// Assign the link previous to this list to point to the new head, same
		// for the tail
		if (prevHead != null)
			prevHead.next = thead;
		ttail.next = tailNext;
		// Assign wrapper and the head and tail
		Wrapper ret = new Wrapper();
		ret.pivot = piv;
		ret.prevtoPivot = prevtoPivot;
		ret.ntail = ttail;
		ret.nhead = thead;
		if (assignHead)
			head = (Link<T>) thead;
		if (assignTail)
			tail = (Link<T>) ttail;
		System.out.println("                      " + thead.object + " "
				+ ttail.object + " list's " + head.object + " " + tail.object);
		return ret;
	}

	public void quickSort(Link<Integer> nhead, Link<Integer> ntail,
			Link<Integer> prevHead) {
		// base cases
		if (nhead == null)
			return;

		if (nhead == ntail)
			return;

		Wrapper wrap = partition(nhead, ntail, prevHead);
		Link<Integer> pivot = wrap.pivot;
		Link<Integer> prevtoPivot = wrap.prevtoPivot;

		// re assign the head and tail
		nhead = wrap.nhead;
		ntail = wrap.ntail;

		// These are critical conditions to fulfill. Easy as cake.
		if (prevtoPivot != null)
			quickSort(nhead, prevtoPivot, prevHead);

		if (pivot != ntail)
			quickSort(pivot.next, ntail, pivot);

	}

	public static void main(String args[]) {
		QuickSortLL<Integer> list = new QuickSortLL<Integer>();
		list.add(-4);
		list.add(7);
		list.add(8);
		list.add(2);
		list.add(-3);
		list.add(0);
		list.add(56);
		list.add(19);
		list.quickSort(list.head, list.tail, null);
		list.print();

	}
}
