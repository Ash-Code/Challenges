package theory.algorithms;

public class quickSort {

	public static void swap(int[] A,int f, int t){
		int temp;
		temp=A[f];
		A[f]=A[t];
		A[t]=temp;
		
	}
	
	public static int partition(int A[], int lo, int hi) {
		int pivot = A[hi];
		int ws=lo;
		for(int i=lo;i<hi;i++){
			if(A[i]<=pivot){
				swap(A, ws, i);
				ws++;
			}
			
		}
		swap(A, ws, hi);
		return ws;
	}

	public static void Sort(int[] A, int lo, int hi) {

		if(lo>=hi){
			return;
		}
		int q=partition(A, lo, hi);
		Sort(A, lo,q-1);
		Sort(A, q+1, hi);
		
	}

	public static void main(String args[]) {
long time = System.nanoTime();
		int[] A={-5,6,7,2,45,2,-67,99};
		Sort(A, 0, A.length-1);

		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println("");
		System.out.println(System.nanoTime()-time);
	}

}
