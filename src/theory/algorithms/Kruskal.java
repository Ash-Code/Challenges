package theory.algorithms;
import java.util.Scanner;
import theory.algorithms.UnionFindLogN.Edge;

public class Kruskal {
	
	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int N = ss.nextInt();// no of edges in question
		int lim = ss.nextInt();// highest value of a vertex
		Edge e[] = new Edge[N];
		for (int i = 0; i < N; i++) {
			e[i] = new Edge(ss.nextInt(), ss.nextInt());
		}

		
		
		System.out.println(UnionFindLogN.isCycle(e, lim) ? "Cycle found " : "No Cycle found");

	}

	

}
