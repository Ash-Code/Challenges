package theory.algorithms;

public class knapsack {

	public static int Solve(int[] v, int[] w, int W) {
		int[][] dp = new int[v.length + 1][W + 1];
		for (int i = 0; i <= W; i++) {
			dp[0][i] = 0;
		}

		int n = 0;
		/*
		 * Assume you have to maximize val upto a certain weight w, a smaller
		 * subprob. 3 cases arise:
		 *  1. There are no items in the knapsack, or the
		 * weight of the knapsack is 0 - the benefit is 0 
		 * 2. The weight of item i exceeds the weight w of the knapsack - item i cannot be included in
		 * the knapsack and the maximum benefit is B[i-1, w] 3. Otherwise, the
		 * benefit is the maximum achieved by either not including item i ( i.e.,
		 * B[i-1, w]), or by including item i (i.e., B[i-1, w-wi]+bi)
		 */
		for (int i = 0; i < v.length; i++) {
			n++;
			for (int j = 0; j <= W; j++) {
				if (w[i] <= j) {
					dp[n][j] = Math.max(dp[n - 1][j], v[i]
							+ dp[n - 1][j - w[i]]);
					System.out.println("i " + n + " j " + j + " val "
							+ dp[n][j] + " prev " + dp[n - 1][j]);
				} else
					dp[n][j] = dp[n - 1][j];
			}
		}

		return dp[v.length][W];
	}

	public static void main(String args[]) {

		int v[] = { 270, 200, 60, 50, 230 };
		int w[] = { 5, 3, 8, 8, 5 };
		int W = 10;
		System.out.println(Solve(v, w, W));

	}

}
