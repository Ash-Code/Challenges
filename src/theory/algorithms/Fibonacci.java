package theory.algorithms;

public class Fibonacci {

	static void fib2(int n) {
		int a = 1, b = 0, c = 0;
		System.out.println(b);
		System.out.println(a);
		while (n > 0) {

			c = a + b;
			b = a;
			a = c;
			System.out.println(c);
			n--;
		}
	}

	static int init(int n) {
		int mem[] = new int[n+1];
		for (int i = 0; i < n+1; i++)
			mem[i] = -1;
		mem[0] = 0;
		mem[1] = 1;
		return fib(n, mem);

	}

	static int fib(int n, int mem[]) {
	
		if (mem[n] != -1)
			return mem[n];
		
		mem[n] = (fib(n - 1, mem) + fib(n - 2, mem));
		return mem[n];
	}

	public static void main(String args[]) {

		System.out.println(init(21));
	}

}
