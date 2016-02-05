package theory.algorithms;

import java.util.HashSet;

public class Hashing {
	public static class dice {
		int l, r, t, f, d, b;

		public dice(int a, int b, int c, int d, int e, int f) {
			l = a;
			r = b;
			t = c;
			f = d;
			this.d = e;
			b = f;
		}

		@Override
		public boolean equals(Object x) {
			if (!(x instanceof dice))
				return false;
			dice z = (dice) x;
			if (z.l == l && z.r == r && z.t == t && z.f == f && z.d == d
					&& z.b == b) {
				return true;
			} else
				return false;
		}

		@Override
		public int hashCode() {
			return l - r + t - f + d - b;
		}

	}

	public static dice rotateL(dice dd) {
		int l = dd.f;
		int r = dd.b;
		int t = dd.t;
		int f = dd.r;
		int d = dd.d;
		int b = dd.l;
		return new dice(l, r, t, f, d, b);
	}

	public static dice copy(dice dd) {
		return new dice(dd.l, dd.r, dd.t, dd.f, dd.d, dd.b);
	}

	public static void main(String args[]) {
		HashSet<dice> set = new HashSet<dice>();
		dice d = new dice(1, 2, 3, 4, 5, 6);
		dice dd=copy(d);
		System.out.println(dd.equals(d) +" "+(dd==d));
		
	}

}
