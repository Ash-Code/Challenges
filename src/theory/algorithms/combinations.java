package theory.algorithms;

import java.util.HashMap;
import java.util.Map;

public class combinations {

	private static Map<Integer, Long> factorialMap = new HashMap<Integer, Long>();

	public static Long getFactorial(int number) {

		Long val = factorialMap.get(number);
		if (val != null) {

			return val;
		} else {

			val = getFactorialRecursive(number);

			factorialMap.put(number, val);
			return val;
		}
	}

	public static Long getFactorialRecursive(int number) {

		if (number < 2) {
			return 1L;
		} else {
			return number * getFactorial(number - 1);
		}
	}

	public static Long combination(int fromVal, int chooseVal) {
		return getFactorial(fromVal)
				/ (getFactorial(chooseVal) * getFactorial(fromVal - chooseVal));
	}
	public static Long Perm(int fromVal, int chooseVal) {
		return getFactorial(fromVal)
				/ getFactorial(fromVal-chooseVal);
	}
	public static void main(String args[]) {
		long time = System.nanoTime();
		System.out.println(combination(5,2));
		System.out.println(System.nanoTime() - time);
	}
}
