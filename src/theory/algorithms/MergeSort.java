package theory.algorithms;

import java.util.Scanner;

public class MergeSort {

	public static void mergeSort(int[] A, int start, int end) {
		if (start >= end)
			return;

		int mid = (start + end) / 2;
		
		mergeSort(A, start, mid);
		mergeSort(A, mid + 1, end);
		//System.out.print(start+" "+end+" "+mid+"    ");
		//print(A);
		int[] helper = new int[end - start + 1];
		for(int i=start;i<=end;i++)
			helper[i-start]=A[i];
		int left = start;
		int right = mid + 1;
		int hpos = 0;
		for (hpos = 0; left <= mid && right <= end; hpos++) {//copy in order. This is the meat of the algorithm
			if (A[left] <= A[right]) {
				helper[hpos] = A[left];
				left++;
			} else {
				helper[hpos] = A[right];
				right++;
			}
		}

		for (; hpos < helper.length; hpos++) {//the right end is already in the helper
			if(left<=mid){
			helper[hpos] = A[left];
			left++;}
		}
		for (int i = start; i <= end; i++) {
			A[i] = helper[i - start];
		}
		//print(A);

	}

    //Simpler Version


    public void mergeSort2(int[] A, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        int[] helper = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        for (int hpos = 0; hpos < helper.length; hpos++) {
            if (left > mid) {
                helper[hpos] = A[right];
                right++;
                continue;
            }
            if (right > end) {
                helper[hpos] = A[left];
                left++;
                continue;
            }
            if (A[left] <= A[right]) {
                helper[hpos] = A[left];
                left++;
            } else {
                helper[hpos] = A[right];
                right++;
            }
        }
        for (int i = start; i <= end; i++) {
            A[i] = helper[i - start];
        }
    }


    public static void print(int[] A) {
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		System.out.println("");
	}
	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = ss.nextInt();
		mergeSort(A, 0, A.length - 1);
		for (int x : A)
			System.out.print(x + " ");

	}

}
