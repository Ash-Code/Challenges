package theory.algorithms;

import java.util.Scanner;

//can be used on whatever datastructure that can tell what it's position will be, and what can be the max position.
//Positive integer numbers can do that.

public class CountingSort {

	public static int[] countSort(int[] A, int max) {
		int n = A.length;
		int[] aux = new int[max + 1];
		for (int i = 0; i < n; i++)
			aux[A[i]]++;
		for (int i = 1; i <= max; i++){
			aux[i] += aux[i - 1];//accumulate positions
		}
	
		
		int[] result = new int[n];
		for (int i = n-1; i >=0; i--) {//starting from the end for a stable sort
			int pos=aux[A[i]]-1;//aux keeps a record based on 1 index
			result[pos] = A[i];
			aux[A[i]]--;
		}
		return result;

	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[] A = new int[n];
        int max=0;
		for (int i = 0; i < n; i++){
			A[i] = Math.abs(ss.nextInt());
            max=Math.max(max,A[i]);
        }
		int[] result = countSort(A, max);

		for (int x : result)
			System.out.print(x+" ");
		
		ss.close();
	}

}
