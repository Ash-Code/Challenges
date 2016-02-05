package theory.algorithms;

import java.util.Scanner;

public class ZAlgo extends Thread {

	public int buildZ(String T, String P) {
		StringBuilder sb = new StringBuilder();
		sb.append(P).append("$").append(T);
		char[] S = sb.toString().toCharArray();
		int count = 0;
		int p = P.length();
		int s = S.length;
		int[] Z = new int[S.length];
		int r = -1, l = -1, k = 0, b = 0;
		for (int i = 1; i < S.length; i++) {
			if (i > r) {
				l = r = i;
				while (r < s && S[r] == S[r - l]) {
					r++;
					Z[i]++;
				}
				r--;
			} else {
				b = r - i + 1;
				k = i - l;
				if (Z[k] < b)
					Z[i] = Z[k];
				else {
					while (r + 1 < s && S[r + 1] == S[r + 1 - i])
						r++;
					Z[i] = r - i + 1;
				}
			}
			if (Z[i] == p)
				count++;

		}

		for (int i = 0; i < S.length; i++) {
			System.out.print(Z[i] + " ");
		}
		System.out.println();
		return count;
	}

	@Override
	public void run() {
		Scanner ss = new Scanner(System.in);

		String p = ss.next();
		String t = ss.next();
		System.out.println(buildZ(t, p));
	}

	public static void main(String args[]) {
		new ZAlgo().start();
	}

}
