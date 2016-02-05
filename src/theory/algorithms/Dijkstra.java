package theory.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Dijkstra {

	public static class Node implements Comparable<Node> {
		public int cost, name, minCost = 2000000;
		ArrayList<Node> link;
		boolean visited;

		public Node(int cost, int name) {
			this.cost = cost;
			this.name = name;
			link = new ArrayList<Node>();
			visited = false;
		}

		@Override
		public int compareTo(Node right) {// This compare function is
											// responsible
											// for the items that go inside the
											// treeSet and items that are
											// removed (ONLY THE PARAMETERS
											// MENTIONED GET COMPARED.)

			if (minCost > right.minCost)// Comparison
										// equation-->
										// positive
										// value means
										// this is
										// greater than
										// right
				return 1;
			if (minCost < right.minCost)// vice versa
				return -1;
			if (name > right.name)
				return 1;
			if (name < right.name)
				return -1;
			else
				return 0;// this function MUST return a 0 to specify when the
							// two objects being compared are equal; for
							// removing and other purposes
		}

	}

	public static TreeSet<Node> add(Node start) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		TreeSet<Node> pq = new TreeSet<Node>();
		Node top = null;
		while (!q.isEmpty()) {
			top = q.pop();
			System.out
					.println("top.name " + top.name + "so ? : " + pq.add(top));
			if (top.link.isEmpty()) {
				continue;
			}

			for (int i = 0; i < top.link.size(); i++) {
				if (!top.link.get(i).visited) {
					q.add(top.link.get(i));
					top.link.get(i).visited = true;
				}
			}

		}
		return pq;

	}

	public static int[] ShortestPath(Node start) {
		TreeSet<Node> pq;
		start.minCost = 0;
		pq = add(start);

		Node top = null, temp = null;
		int[] lister = new int[10];

		Iterator<Node> it = pq.iterator();
		while (it.hasNext()) {
			temp = it.next();
			System.out.println("name : " + temp.name + "minCost ::"
					+ temp.minCost);
		}

		while (!pq.isEmpty()) {

			top = pq.pollFirst(); // using pollFirst instead of
									// pq.remove(pq.first) since remove function
									// checks whether the elements are equal or
									// not using the comparator, ours is faulty.

			lister[top.name] = top.minCost;

			for (int i = 0; i < top.link.size(); i++) {

				if (top.link.get(i).minCost > top.minCost
						+ top.link.get(i).cost) {

					top.link.get(i).minCost = top.minCost
							+ top.link.get(i).cost;
					System.out.println("from parent : " + top.name + " name : "
							+ top.link.get(i).name + " minCost : "
							+ top.link.get(i).minCost);
				}
			}
		}

		return lister;
	}

	public static void main(String args[]) {

		int[] lister;
		Node n = new Node(100, 1), b = new Node(10, 2), c = new Node(200, 3), d = new Node(
				10, 4), e = new Node(5, 5), f = new Node(20, 6), g = new Node(
				10, 7), h = new Node(10, 8);

		n.link.add(b);
		n.link.add(f);
		b.link.add(c);
		b.link.add(d);
		b.link.add(e);
		e.link.add(g);
		c.link.add(g);
		f.link.add(d);
		d.link.add(h);
		h.link.add(g);

		lister = ShortestPath(n);
		for (int i = 0; i < 10; i++)
			System.out.println(" name : " + i + " minCost " + lister[i]);
	}

}
