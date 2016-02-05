package theory.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class prac1 {

	static PrintWriter pw;
	static int[][] in;
	static int N;

	public static int UP() {
		int ans = 0, t = 0;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				t += in[i][j] & in[j][i];
			}
			t %= 2;
			// System.out.println(" item " + i + " : " + t);
			ans += t;
			t = 0;

		}
		ans %= 2;
		return ans;
	}

	public static void flipR(int x) {
		for (int i = 0; i < N; i++) {
			in[x][i] ^= 1;
		}
	}

	public static void flipC(int x) {
		for (int i = 0; i < N; i++) {
			in[i][x] ^= 1;
		}
	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		N = (int) st.nval;
		in = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				st.nextToken();
				in[i][j] = (int) st.nval;

			}
		}
		StringBuilder sb = new StringBuilder();
		st.nextToken();
		int Q = (int) st.nval;
		int q = 0, x = 0;
		for (int i = 0; i < Q; i++) {
			st.nextToken();
			if (st.nval != 3) {
				q = (int) st.nval;
				st.nextToken();
				x = (int) st.nval;
				if (q == 2)
					flipC(x - 1);
				if (q == 1)
					flipR(x - 1);
			} else {
				sb.append(UP());
			}
		}
		pw.println(sb.toString());
		pw.println(System.currentTimeMillis() - time);
		bf.close();

		pw.close();
		System.exit(0);

	}
}