package theory.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class LSubSeq {

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int N = (int) st.nval;
		int l[] = new int[N];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			l[i] = (int) st.nval;
		}

		int best[] = new int[N];
		best[0] = l[N - 1];
		int hr = 1;
		for (int i = N - 1; i >= 0; i++) {
		
			if (l[i] < best[hr-1]) {
				best[hr-1] = l[i];
				continue;
			}

			for (int j = hr - 1; j >= 0; j--) {
				if (l[i] > best[j]) {
					best[++j] = l[i];
					if (j == hr)
						hr++;
				}
			}
			
			

		}

	}

}
