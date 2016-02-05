package theory.algorithms;

/*
 ID: renegad2
 LANG: JAVA
 TASK: milk3
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


//an amazing question for DFS
/*Consider pouring milk a decision, one can pour milk from any container to any container, 
* they are the choices. 
* Once we make a decision, and it doesn't pan out well, we must revert the containers to the 
* original position before the decision to make another decision. (hence the pourBack method)
* The DFS is terminated by a boolean[][][] that keeps a track of already visited conditions,
* otherwise we'll keep pouring back and forth.
*/
public class USACO {
	public static PrintWriter pw;
	static boolean valid[][][] = new boolean[20][20][20];
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static int pour(node f, node t) {

		int c = t.max - t.v;
		//System.out.println(".... pouring.. from " + f.id + " " + f.v + " to  "
			//	+ t.id + " " + t.v + " cap " + c);
		if (c >= f.v) {
			t.v += f.v;
			c = f.v;
			f.v = 0;

		} else {
			f.v -= c;
			t.v = t.max;
		}

	//	System.out.print(" final " + c);
		//System.out.println("");
		return c;
	}

	public static void pBack(node f, node t, int c) {
	//	System.out.println(".... BACK.. from " + f.id + " " + f.v + " to  "
		//		+ t.id + " " + t.v + " amount  " + c);
		f.v -= c;
		t.v += c;
	}

	public static class node {
		char id;
		int v, max;
		boolean full;

		public node(int v, int max, char id) {
			this.max = max;
			this.v = v;
			this.id = id;
			if (v == 0)
				full = false;
			if (v == max)
				full = true;
		}

		public boolean check() {
			if (this.v >= 0 && this.v <= max) {
				return true;
			}
			return false;
		}

	}

	public static void recurse(node A, node B, node C, int x) {
		//System.out.println("                            " + x + "      " + A.v
			//	+ "  " + B.v + " " + C.v);
		// check validation or return

		if (A.v < 0 || B.v < 0 || C.v < 0)
			return;
		else {
			if (valid[A.v][B.v][C.v])
				return;
			else
				valid[A.v][B.v][C.v] = true;
		}

		if (A.v == 0)
			list.add(C.v);

		int a = pour(C, A);
		recurse(A, B, C, x + 1);
		pBack(A, C, a);

		int b = pour(C, B);
		recurse(A, B, C, x + 1);
		pBack(B, C, b);

		a = pour(B, A);
		recurse(A, B, C, x + 1);
		pBack(A, B, a);

		b = pour(B, C);
		recurse(A, B, C, x + 1);
		pBack(C, B, b);

		a = pour(A, B);
		recurse(A, B, C, x + 1);
		pBack(B, A, a);

		b = pour(A, C);
		recurse(A, B, C, x + 1);
		pBack(C, A, b);

	}

	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		recurse(new node(0, A, 'A'), new node(0, B, 'B'), new node(C, C, 'C'),
				0);
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			a[i] = list.get(i);

		Arrays.sort(a);
		pw.print(a[0]);
		for (int i = 1; i < a.length; i++)
			pw.print(" " + a[i]);

		pw.close();

		System.exit(0);
	}
}
