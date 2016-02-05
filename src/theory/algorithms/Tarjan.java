package theory.algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class Tarjan {
	public static int[][] map;
	static int index;

	public static class node {
		int pos;
		int index;
		int lowlink;
		int data;
		ArrayList<node> list = new ArrayList<node>();

		public node(int p, int data, int index, int ll) {
			pos = p;
			this.index = index;
			this.lowlink = ll;
			this.data = data;
		}
	}

	static Stack<node> s;

	public static void strongConnect(node n) {
		n.index = index;
		n.lowlink = index;
		index++;
		s.push(n);

		for (node x : n.list) {
			if (x.index == 0) {
				strongConnect(x);
				n.lowlink = Math.min(n.lowlink, x.lowlink);
			} else if (s.contains(x)) {
				n.lowlink = Math.min(n.lowlink, x.index);
			}

		}

		if (n.lowlink == n.index) {
			System.out.println(" root node " + n.pos + " " + n.data
					+ " with index:  " + n.lowlink);
			while (s.peek().lowlink == n.lowlink) {
				System.out.println("        " + s.pop().pos + " ");
			}

		}

	}

	public static void main(String args[]) {
		int[] comp = new int[60];
		index = 1;
		s = new Stack<node>();
		for (int i = 0; i < comp.length; i++) {
			if (comp[i] == 0) {
				strongConnect(new node(i, 0, 0, 0));
			}
		}

	}

}
