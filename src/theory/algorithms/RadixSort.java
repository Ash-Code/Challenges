package theory.algorithms;

import java.util.Scanner;

public class RadixSort {

	public static int[] countSort(int[] A, int exp) {// the max for counSort
														// will be 9, since we
														// are using 10 based
														// digits
		int n = A.length;
		int[] aux = new int[10];
		for (int i = 0; i < n; i++)
			aux[(A[i] / exp) % 10]++;// extracts the digit and counts
										// occurrences
		for (int i = 1; i <= 9; i++) {
			aux[i] += aux[i - 1];// accumulates
		}

		int[] result = new int[n];
		for (int i = 0; i <n; i++) {// A STABLE SORT IS NECESSARY!
											// otherwise you ruin the original
											// established order
			int pos = aux[(A[i] / exp) % 10] - 1;
			result[pos] = A[i];// places them according to extracted digit's
								// order
			aux[(A[i] / exp) % 10]--;
		}
		System.out.print(exp + "     ");
		print(result);
		return result;

	}

	public static void print(int[] A) {
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		System.out.println("");
	}

	public static int max(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++)
			if (A[i] > max)
				max = A[i];
		return max;
	}

	public static int[] radixSort(int[] A) {
		int max = max(A);
		int lim = (int) Math.log10(max) + 1;// assuming a base of 10, get the
											// maximum exponent to be sent

		for (int i = 0; i <= lim; i++) {
			A = countSort(A, (int) (1 * Math.pow(10, i)));
		}

		return A;
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = ss.nextInt();
		int[] result = radixSort(A);

		for (int x : result)
			System.out.print(x + " ");

		ss.close();
	}

}
