package theory.datastructures;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetPrac {

	public static class Node implements Comparable<Node> {
		int x, y;
		int count=200000, bla;

		public Node(int x, int y, int bla) {
			this.x = x;
			this.y = y;
			this.bla = bla;

		}

		@Override
		public int compareTo(Node n) {
			if (count > n.count )
				return 1;
			if (count < n.count )
				return -1;
			if(this.x>n.x )
				return 1;
			if(this.x<n.x )
				return -1;
			else 

				return 0;
		}

	}

	public static void main(String args[]) {
		TreeSet<Node> pq = new TreeSet<Node>();
		
		
		
		System.out.println(pq.add(new Node(1,2,1212)));
		System.out.println(pq.add(new Node(2,2,234324)));
		
		Iterator<Node> it = pq.iterator();
		Node temp;
		while(it.hasNext()){
			temp = it.next();
			System.out.println("x :"+ temp.x + "y : "+temp.y);
			System.out.println("");
		}
		
		
		
	}
}
