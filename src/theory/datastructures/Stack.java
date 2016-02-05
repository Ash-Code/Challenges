package theory.datastructures;

public class Stack<T> {
	int top = -1;
	private int cap;
	Object[] stack;

	public Stack(int size) {
		stack = new Object[size];
		cap = size;
	}

	public void add(T element) {
		if (top == cap - 1) {
			System.out.println("Stack Overflow");
		} else {
			stack[++top] = element;
		}
	}

	public T pop() {
		if (top == -1) {
			System.out.println("Stack underflow");
			return null;

		} else {
            @SuppressWarnings("unchecked")
			T element = (T) stack[top];
			top--;
			return element;
		}

	}

	// for infinite capacity, check the position of top, and double the
	// capacity, then call stack = Arrays.copyOf(stack, cap');
}
