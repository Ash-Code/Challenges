package tasks;

import java.util.Arrays;

public class BearSlowlySorts {
    public int minMoves(int[] w) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : w) {
            if (x > max)
                max = x;
            if (x < min)
                min = x;
        }
        int n = w.length;
        int[] w2 = Arrays.copyOfRange(w, 0, n);
        Arrays.sort(w2);
        if (w[0] == max && w[n - 1] == min)
            return 3;
        if (w[0] == min && w[n - 1] == max)
            if (Arrays.equals(w, w2))
                return 0;
            else
                return 1;
        if (w[0] == min || w[n - 1] == max)
            return 1;
        else
            return 2;
    }
}
