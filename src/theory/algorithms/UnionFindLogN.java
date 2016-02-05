package theory.algorithms;

import java.util.Scanner;

public class UnionFindLogN {
	public static class Edge {
		int src, dest;

		public Edge(int s, int d) {
			src = s;
			dest = d;

		}
	}

	public static class subsets {
		int parent, rank;

		public subsets(int p, int r) {
			parent = p;
			rank = r;
		}
	}

	public static int find(subsets[] sub, int x) {
		System.out.println(x);
		if (sub[x].parent != x) {
			sub[x].parent = find(sub, sub[x].parent);// path compression every
														// time we search
		}
		return sub[x].parent;
	}

	public static void union(subsets[] sub, int x, int y) {
		int xroot = find(sub, x);
		int yroot = find(sub, y);
		System.out.println("Union of x: " + xroot + " y: " + yroot);
		if (sub[xroot].rank > sub[yroot].rank) {
			sub[yroot].parent = xroot;
			System.out.println("X>Y");
		} else if (sub[xroot].rank < sub[yroot].rank) {
			sub[xroot].parent = yroot;
			System.out.println("X<Y");
		} else {
			System.out.println("Equal ranks upranking y ");
			sub[xroot].parent = yroot;
			sub[yroot].rank++;
		}

	}

	public static boolean isCycle(Edge[] edges, int lim) {
		int N = edges.length;
		subsets sub[] = new subsets[lim + 1];
		for (int i = 0; i <= lim; i++) {
			sub[i] = new subsets(i, 0);
		}
		for (int i = 0; i < N; i++) {
			System.out.println("EDGE: " + edges[i].src + " " + edges[i].dest
					+ " 2's parent " + sub[2].parent);
			int x = find(sub, edges[i].src);
			System.out.println(" X " + x);

			int y = find(sub, edges[i].dest);
			System.out.println(" Y " + y);
			if (x == y)
				return true;
			union(sub, x, y);

		}

		return false;
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int N = ss.nextInt();// no of edges in question
		int lim = ss.nextInt();// highest value of a vertex
		Edge e[] = new Edge[N];
		for (int i = 0; i < N; i++) {
			e[i] = new Edge(ss.nextInt(), ss.nextInt());
		}

		System.out.println(isCycle(e, lim) ? "Cycle found " : "No Cycle found");

	}

}
