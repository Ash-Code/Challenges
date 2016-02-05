package theory.algorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class ZigZag {

	public static void Read() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(
				new FileInputStream("C:/text.txt")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int i = 0;
		int seq[] = new int[19];
		while (i < 19) {
			seq[i] = (int) st.nval;
			i++;
			st.nextToken();

		}

		System.out.println(LongestSeq(seq));

	}

	public static int Sign(int a) {
		if (a < 0) {
			return -1;
		} else
			return 1;
	}

	public static int LongestSeq(int[] seq) {
		int S[] = new int[19];
		int max = 2;

		for (int i = 0; i < 19; i++) {
			S[i] = 1;
		}

		S[1] = 2 * Sign(seq[1] - seq[0]);

		for (int i = 2; i < 19; i++) {
			for (int j = 1; j < i; j++) {

				if (S[j] * (seq[i] - seq[j]) < 0) {
					S[i] = (1 + Math.abs(S[j])) * Sign(S[j] * (-1));
				}

			}
			if(S[i]==1){
				S[i]= 2*Sign(seq[i]-seq[0]);
			}
		}
		for (int i = 0; i < 19; i++) {
			if (Math.abs(S[i]) > max) {
				max = Math.abs(S[i]);
			}
		}
		for (int i = 0; i < 19; i++) {
			System.out.println(" i " + i + " Solution :" + S[i]);
		}
		return max;

	}

	public static void main(String args[]) throws IOException {
		ZigZag.Read();
	}
}
