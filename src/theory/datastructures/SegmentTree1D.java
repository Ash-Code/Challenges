package theory.datastructures;

import java.util.Scanner;

public class SegmentTree1D {
	static int tree[][];
	static int k;

	static void insert(int x) {
		for (int i = 0; i < k; i++) {
			tree[i][x]++;
			x /= 2;// update parent
		}
	}

	static void erase(int x) {
		for (int i = 0; i < k; i++) {
			tree[i][x]--;
			x /= 2;
		}
	}

	static int kThElement(int K) {// O(k) process
		int a = 0, b = k;
		System.out.println("Pour = " + K);
		while (b > 0) {
			b--;// Each time go down a level
			a *= 2;// Jumping to the left child
			System.out.println("b: " + b + " a: " + a);
			if (tree[b][a] < K) {// We want the element with just larger
									// frequency coz if an element has >1
									// freq, its predecessor will have
									// significantly lower freq <<K
				K -= tree[b][a++];// jump to the right child and repeat
				System.out.println("ff incr" + a + " pending K :" + K);
			}
		}
		if (K != 0)
			System.out.println("ERROR " + K);
		System.out.println("ans " + a);
		return a;
	}

	public static void main(String args[]) {

		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int y = ss.nextInt();
		k = 1 + (int) (Math.log(n) / Math.log(2));
		tree = new int[k][n];
		System.out.println(k);
		for (int i = 0; i < y; i++) {
			int a = ss.nextInt();
			if (a >= n)
				continue;
			insert(a);
		}
		System.out.print("Ind : " + ":" + " ");
		for (int j = 0; j < n; j++) {
			System.out.print(j + " ");
		}
		System.out.println("");
		for (int i = 0; i < k; i++) {
			System.out.print("Lvl : " + i + " ");
			for (int j = 0; j < n; j++) {
				System.out.print(tree[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		for (int i = 1; i <= y; i++)
			System.out.print(kThElement(i) + " ");

	}
}
