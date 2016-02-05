package theory.algorithms;

public class bitmanipulation {

	public static void display(int a, int b) {
		System.out.println("a : " + Integer.toBinaryString(a) + " b:  "
				+ Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(a & (~b)));

	}

	// Every bit representation of nos represents a set.
	// ^ extracts bits which are different by setting/clearing each resultant
	// bit
	// ^ ~ subtracts the negated numbers set bits in common
	// A|=1<<x set the xth bit
	// A&=(1<<x) clear the xth bit.
	// A&(1<<x)!=0 test if the xth bit is set

	// lastBit of a number is also the largest power of 2 that divides it--->
	// last bit= last set bit == x&-x

	public static void main(String args[]) {
		display(5, 9);
		System.out.println();
	}
}
