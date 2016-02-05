package theory.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxFlow {

	public int INF = Integer.MAX_VALUE;

	class Solution {
		int maxFlow;
		ArrayList<String> flow;

		public Solution(int n, int[][] residual, int[][] capacity, int result) {
			maxFlow = result;
			flow = new ArrayList<String>();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(capacity[i][j]>0){
						flow.add("Flow from: "+i+" -> "+j+" = "+residual[j][i]);
					}
				}
			}
		}
	
	}

	class FastSolver {

		public int findPath(int[][] residual, int source, int sink) {
			int n = residual[0].length;
			LinkedList<Integer> q = new LinkedList<Integer>();
			boolean visited[] = new boolean[n];
			int[] from = new int[n];
			Arrays.fill(from, -1);
			q.add(source);
			visited[source] = true;
			int minCap = INF;
			int where = -1;
			outer: while (!q.isEmpty()) {
				where = q.pollFirst();
				for (int i = 0; i < n; i++) {
					if (!visited[i] && residual[where][i] > 0) {
						q.add(i);
						visited[i] = true;
						from[i] = where;
						if (i == sink)
							break outer;
					}
				}
			}
			where = sink;
			int prev = -1;

			while (from[where] > -1) {
				prev = from[where];
				
				if (prev < 0)
					break;
				minCap = Math.min(minCap, residual[prev][where]);
				where = prev;
			}
			where = sink;
			prev = -1;
			Stack<Integer> path = new Stack<Integer>();
		path.add(where);
			if (minCap < INF) {
				while (from[where] >= 0) {
					prev = from[where];
					path.add(prev);
					residual[prev][where] -= minCap;
					residual[where][prev] += minCap;
					where = prev;
				}
				System.out.println("Augmented value : "+minCap+" on path: ");
				while(!path.isEmpty())
					System.out.print(path.pop()+""+(path.size()>0?"-->":""));	
				System.out.println("");
				return minCap;
			} else
				return -1;
		}

		public Solution maxFlow(int source, int sink, int[][] capacity) {
			int n = capacity[0].length;
			int[][] residual = new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					residual[i][j]=capacity[i][j];
				}
			}
			int result = 0;

			while (true) {
				int augment = findPath(residual, source, sink);
				if (augment < 0)
					break;
				result += augment;
			}
			return new Solution(n, residual, capacity, result);
		}

		public void Solve() {

			System.out.println("Please enter the number of nodes : ");
			int n = ni();
			int[][] capacity = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(capacity[i], INF);
			}
			System.out
					.println("Please enter the capacity matrix (-1 for no edge) : ");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					capacity[i][j] = ni();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (capacity[i][j] > 0) {
						capacity[j][i] = 0;
					}
				}
			}

			System.out.println("Enter source : ");
			int source = ni();
			System.out.println("Enter sink : ");
			int sink = ni();
			long time1=System.nanoTime();
			Solution solution = maxFlow(source, sink, capacity);
			long time2=System.nanoTime();
			System.out.println("TIME TAKEN "+(time2-time1));
			System.out.println("Maximum flow on network : "+solution.maxFlow);
			ArrayList<String> flow=solution.flow;
			System.out.println("Residual flow is as follows :");
			for(String x:flow){
				System.out.println(x);
			}
		}

		BufferedReader br;
		StringTokenizer st;

		public FastSolver(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}

		String n() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return null;
				st = new StringTokenizer(s);
			}
			return st.nextToken();
		}

		String l() {
			String s = null;
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;

		}

		boolean hasMoreTokens() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}

		int nb() {
			return Integer.parseInt(n(), 2);
		}

		long nbl() {
			return Long.parseLong(n(), 2);
		}

		int ni() {
			return Integer.parseInt(n());
		}

		double nd() {
			return Double.parseDouble(n());
		}

		long nl() {
			return Long.parseLong(n());
		}
	}

	public void run() {
		
		FastSolver in = new FastSolver(System.in);
		PrintWriter out = new PrintWriter(System.out);
		in.Solve();
		out.close();
	}

	public static void main(String[] args) {
		new MaxFlow().run();
	}
}