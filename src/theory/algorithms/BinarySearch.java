package theory.algorithms;

import java.io.IOException;

public class BinarySearch {
    public static void BS(double hi, double lo, double target) {
        double mid = 0;
        int c = 0;

        while (mid != target) {
            mid = lo + (hi - lo) / 2;
            if (mid >= target) {
                hi = mid;
            } else {
                lo = mid;
            }


        }
        System.out.println("result : " + mid);


    }

    public static void main(String[] args) throws IOException {
        int a = 10;
        int b = -17;
        BS(15, 1, 8.43425232342333);
    }

}
