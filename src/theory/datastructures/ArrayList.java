package theory.datastructures;

import java.util.Arrays;

public class ArrayList<T> {
	private int cap = 100;
	private int size;
	public Object list[];

	public ArrayList() {
		list = new Object[cap];
		size = 0;
	}

	public void add(T element) {
		if (list.length - size < 5) {
			increaseSize();
		}
		list[size] = element;
		size++;

	}

	public void remove(int index) {
		if (index < size) {
			list[index] = null;
			while (index < size - 1) {// copy all elements after the removed index, takes time
				list[index] = list[index + 1];
				index++;
			}
			list[index] = null;
			size--;

		} else {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	public T get(int index) {
		if(index<size){
			return (T) list[index];
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
		
	}

	public int size() {
		return size;
	}

	public void increaseSize() {
		list = Arrays.copyOf(list, list.length * 2);
	}
}
