package theory.datastructures;

import java.util.ArrayList;

public class Heap<T extends Comparable<? super T>> {
	public ArrayList<T> heap;

	public Heap() {
		heap = new ArrayList<T>();
	}

	public int getParenti(int index) {
		return index / 2;
	}

	public int getLefti(int index) {
		return index << 1;
	}

	public int getRighti(int index) {
		return (index << 1) + 1;
	}

	public void swap(int a, int b) {
		T t = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, t);
	}

	public boolean add(T element) {// added elements randomly

		heap.add(element);
		return true;
	}

	public void print() {
		for (T x : heap) {
			System.out.println(x.toString());
		}
	}

	public void heapSortMax() {// amazing algo
		int size = heap.size();

		for (int i = size - 1; i >= 1; i--) {// till 1 since the last swap will
												// be between 0 and 1
			buildMaxHeap(i + 1);// sending i+1 since we'll be using size as
								// exclusive
			swap(0, i);
		}

	}



	private void maxHeapify(int i, int size) {// this function takes a smaller
												// value and
		// goes downwards, this max heapifying occurs within the limit of size(exclusive)
		int largest = i;
		int left = getLefti(i);
		int right = getRighti(i);

		if (left < size && heap.get(left).compareTo(heap.get(i)) > 0) {//checks if kid exists, if yes, should we swap?
			largest = left;
		}
		if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0) {
			largest = right;
		}

		swap(largest, i);
		if (largest != i)
			maxHeapify(largest, size);

	}
	
	

	private void buildMaxHeap(int size) {
		for (int i = size / 2; i >= 0; i--) {
			maxHeapify(i, size);
		}

	}
//---------------Just for doing decreasing sort
	
	public void heapSortMin() {
		int size = heap.size();

		for (int i = size - 1; i >= 1; i--) {
			buildMinHeap(i + 1);
			swap(0, i);
		}

	}
	private void minHeapify(int i, int size) {
		int smallest = i;
		int left = getLefti(i);
		int right = getRighti(i);

		if (left < size && heap.get(left).compareTo(heap.get(i)) < 0) {
			smallest = left;
		}
		if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
			smallest = right;
		}

		swap(smallest, i);
		if (smallest!= i)
			minHeapify(smallest, size);

	}

	
	private void buildMinHeap(int size) {
		for (int i = size / 2; i >= 0; i--) {
			minHeapify(i, size);
		}

	}

}
