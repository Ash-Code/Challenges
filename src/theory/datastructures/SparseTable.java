package theory.datastructures;

import java.util.Scanner;

public class SparseTable {

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = ss.nextInt();
		int[][] ST;
		int k = (int) (Math.log(n) / Math.log(2));
		System.out.println(k);
		ST = new int[n][k + 1];
		for (int j = 0; j < n; j++) {
			ST[j][0] = array[j];
		}

		for (int j = 1; 1 << j < n; j++) {

			for (int i = 0; i < n - (1 << j) + 1; i++) {
				if (ST[i][j - 1] <= ST[i + (1 << (j - 1))][j - 1])
					ST[i][j] = ST[i][j - 1];
				else
					ST[i][j] = ST[i + (1 << (j - 1))][j - 1];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; 1 << j < n; j++) {
				System.out.print(ST[i][j] + " ");
			}
			System.out.println("");
		}

		int m = ss.nextInt();
		for (int i = 0; i < m; i++) {
			int a = ss.nextInt();
			int b = ss.nextInt();
			if (b < a)
				System.out.println(-1);
			else {
				int k1 = (int) (Math.log(b - a + 1) / Math.log(2));
				System.out.println(k1 + " " + ((b - (1 << k1)) + 1));
				if (ST[a][k1] <= ST[(b - (1 << k1)) + 1][k1])
					System.out.println(ST[a][k1]);
				else
					System.out.println(ST[(b - (1 << k1)) + 1][k1]);

			}
		}

	}
}
