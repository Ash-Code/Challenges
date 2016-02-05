package theory.algorithms;

import java.util.Scanner;
import java.util.TreeSet;

public class PrimAlgo {

	public static class Node implements Comparable<Node> {
		int id, dist, src;
		boolean inTree;

		public Node(int id, int c) {
			this.id = id;
			dist = c;
			src = 0;
			inTree = false;
		}

		@Override
		public int compareTo(Node a) {
			if (a.dist > dist)
				return -1;
			if (a.dist < dist)
				return 1;
			if (a.id > id)
				return -1;
			if (a.id < id)
				return 1;
			else
				return 0;
		}
	}

	public static int prim(int[][] map) {
		int n = map.length;
		Node[] nodes = new Node[n];
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++)
			nodes[i] = new Node(i, Integer.MAX_VALUE);
		TreeSet<Node> pq = new TreeSet<Node>();
		nodes[0].dist = 0;
		nodes[0].src = 0;
		pq.add(nodes[0]);
		int ts = 0, tc = 0;
		Node temp = nodes[0];
		while (ts < n) {
			Node curr = temp;
			curr.inTree = true;
			tc += curr.dist;
			ts++;
			// System.out.println(curr.id + " " + curr.dist + " " + tc + " " +
			// ts);
			for (int i = 0; i < n; i++) {
				if (map[curr.id][i] < Integer.MAX_VALUE && !nodes[i].inTree) {
					if (nodes[i].dist > map[curr.id][i])
						nodes[i].dist = map[curr.id][i];
					nodes[i].src = curr.id;
				}
			}
			int min = Integer.MAX_VALUE;// not using a priority queue since the
										// values of nodes get modified each
										// time, and resorting is tough
										// programming, not worth it. Just
										// search the largest in order n
			for (int i = 0; i < n; i++) {
				if (nodes[i].dist < min && !nodes[i].inTree) {
					temp = nodes[i];
					min = nodes[i].dist;
				}
			}

		}
		res = Math.min(res, tc);

		return res;
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = ss.nextInt();
		System.out.println(prim(map));
	}

}
