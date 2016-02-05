package theory.algorithms;

public class gcd {
	static int gcd2(int a, int b)
	{
	  if(a == 0 || b == 0) return a+b;
	  return gcd2(b,a%b);
	}
	
	public static long gcd1(long a, long b) {
		if (a < b)
			return gcd1(b, a);
		if (a % b == 0)
			return b;
		else
			return gcd1(b, a % b);
	}

	public static long lcm(long a, long b) {
		return ((a * b) / gcd1(a, b));

	}

	public static long lcmofarray(long[] arr, int start, int end) {// finding the
																	// LCM of an
																	// array
		if ((end - start) == 1)
			return lcm(arr[start], arr[end - 1]);
		else
			return (lcm(arr[start], lcmofarray(arr, start + 1, end)));
	}
	public static void main(String args[]){
	System.out.println(	gcd2(512,1024));
	}

}
