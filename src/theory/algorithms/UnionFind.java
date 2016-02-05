package theory.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class UnionFind {
	public static class Edge {
		int src, dest;

		public Edge(int s, int d) {
			src = s;
			dest = d;

		}
	}

	public static int find(int[] parent, int x) {
		if (parent[x] == -1)
			return x;
		else
			return find(parent, parent[x]);
	}

	public static void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	public static boolean isCycle(Edge[] edges, int lim) {
		int N = edges.length;
		int[] parent = new int[lim+1];
		Arrays.fill(parent, -1);
		for (int i = 0; i < N; i++) {
			int x = find(parent, edges[i].src);
			int y = find(parent, edges[i].dest);
			if (x == y)
				return true;
			union(parent, x, y);

		}

		return false;
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int N = ss.nextInt();// no of edges in question
		int lim=ss.nextInt();//highest value of a vertex
		Edge e[] = new Edge[N];
		for (int i = 0; i < N; i++) {
			e[i]=new Edge(ss.nextInt(),ss.nextInt());
		}

		System.out.println(isCycle(e, lim)?"Cycle found ":"No Cycle found");

	}

}
