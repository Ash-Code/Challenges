package theory.algorithms;

public class Parenthesis {
	static int M[][];
	static int S[][];

	public static long Solve(int p[]) {
		int n = p.length - 1, q = 0, j = 0;
		M = new int[n + 1][n + 1];
		S = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++)
			for (int f = 0; f <= n; f++)
				M[i][f] = 1000000;

		for (int i = 1; i <= n; i++) {
			M[i][i] = 0;
		}

		for (int l = 2; l <=n; l++) {
			for (int i = 1; i <= n - l+1; i++) {
				j = i + l - 1;
				for (int k = i; k < j; k++) {
					
					q = M[i][k] + M[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (M[i][j] > q) {
						M[i][j] = q;
						S[i][j] = k;

					}
				}
			}

		}
		
		print(1,n);
		
		return M[1][n];
	}

	public static void print(int i, int j) {
		if (i == j){
			System.out.print(" A" + i +" ");
			return;
		}
		else {
			System.out.print("(");
			print(i, S[i][j]);
			print(S[i][j] + 1, j);
			System.out.print(")");
		}

	}

	public static void main(String args[]) {
		int[] p = { 30, 35, 15, 5, 10, 20, 25 };
		System.out.println("solution to the problem is : " + Solve(p));
	}

}
