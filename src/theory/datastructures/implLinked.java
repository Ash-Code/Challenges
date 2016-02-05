package theory.datastructures;

public class implLinked {

	public static void main(String args[]) {
		LinkedListPrac<Integer> list = new LinkedListPrac<Integer>();
		
		list.add(34);
		list.add(-4);
		list.add(24);
		list.add(54);
		list.add(21);
		list.add(7);
		list.print();
		list.reverseAlt();

		list.print();
	}

}
