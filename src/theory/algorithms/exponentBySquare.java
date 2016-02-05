package theory.algorithms;

public class exponentBySquare {

	public static long exp(long x, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return exp(x * x, n / 2);
		else
			return x * exp(x * x, (n - 1) / 2);

	}

	public static void main(String args[]){
	
	long time=System.nanoTime();
		System.out.println(exp(2,41));
		System.out.println(System.nanoTime()-time);
		time=System.nanoTime();
		System.out.println(Math.pow(2, 41));
		System.out.println(System.nanoTime()-time);
	}
	
}
