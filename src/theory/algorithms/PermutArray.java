package theory.algorithms;

import java.util.ArrayList;

public class PermutArray {

	public void swap(int i, int j, int[] a) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void permut(int startpos, int[] a, ArrayList<int[]> perms) {
		if (startpos < a.length) {
			for (int i = startpos; i < a.length; i++) {
				swap(startpos, i, a);
				permut(startpos + 1, a, perms);
				swap(startpos, i, a);
			}
		} else {
			perms.add(a.clone());
		}

	}

}
