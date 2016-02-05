package theory.datastructures;

public class BIT {

	public static class Fen {
		long[] fen;
		int maxVal;
		int bitmask;

		public Fen(int n) {
			fen = new long[n + 1];
			maxVal = n;// index 0 is always 0;
			int t = maxVal;
			int c = -1;
			while (t > 0) {
				t >>= 1;
				c++;
			}
			bitmask = 1 << c;
		}

		public long get(int idx) {

			long sum = 0;
			for (int i = idx; i > 0; i -= (i & -i))
				sum += fen[i];
			return sum;
		}

		public void set(int idx, int val) {

			for (int i = idx; i <= maxVal; i += (i & -i))
				fen[i] += val;
		}

		public long getR(int idx1, int idx2) {// get vals between a range
			return get(idx2) - get(idx1 - 1);
		}

		public long getP(int idx) {// get val at a point
			return getR(idx, idx - 1);
		}

		public int getIndex(long sum) {
			int bm = bitmask;
			int idx = 0;

			while (bm != 0 && idx < maxVal) {
				int tIdx = idx + bm;
				if (tIdx > maxVal) {
					bm >>= 1;
					continue;
				}

				if (fen[tIdx] == sum)
					return tIdx;
				else if (sum > fen[tIdx]) {// coz fen[idx] stores the sum of all
											// indices less than it, idx is a
											// power of 2 now
					idx = tIdx;
					sum -= fen[tIdx];// update the sum to be found;
				}
				bm >>= 1;
			}
			if (sum != 0)
				return -1;
			else
				return idx;
		}
	}

	public static void main(String args[]) {
		Fen fen = new Fen(10);// the maxVal is 10
		fen.set(9, 1);
		fen.set(2, 1);
		fen.set(3, 1);
		fen.set(6, 1);
		fen.set(7, 1);
		fen.set(5, 1);
		for (int i = 1; i <= 10; i++)
			System.out.print(fen.get(i) + " ");
		System.out.println("");
		System.out.println(fen.getR(2, 5));
		System.out.println(fen.getIndex(3));// index recieved is 1 based

	}

}
