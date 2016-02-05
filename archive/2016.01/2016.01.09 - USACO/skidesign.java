package tasks;

import java.io.*;
import java.util.StringTokenizer;

/*
 ID: renegad2
 LANG: JAVA
 TASK: skidesign
 */

public class skidesign {
    public StringTokenizer st;
    public BufferedReader br;

    public void solve(int testNumber, InputStreamReader in, PrintWriter out) {
        br = new BufferedReader(in);
        int n = ni();
        int[] heights = new int[n + 1];
        for (int i = 1; i <= n; i++)
            heights[i] = ni();
        int res = Integer.MAX_VALUE;
        for (int h = 0; h <= 100; h++) {
            int curr = 0;
            for (int i = 1; i <= n; i++) {
                if (heights[i] - h > 8) {
                    curr += Math.pow(heights[i] - h - 8, 2);
                } else if (h - heights[i] > 9) {
                    curr += Math.pow(h - heights[i] - 9, 2);
                }
            }
            res = Math.min(curr, res);
        }
        out.println(res);
    }

    String n() {
        while (st == null || !st.hasMoreTokens()) {
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    String l() {
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    boolean hasMoreTokens() {
        while (st == null || !st.hasMoreTokens()) {
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (s == null)
                return false;
            st = new StringTokenizer(s);
        }
        return true;
    }

    int nb() {
        return Integer.parseInt(n(), 2);
    }

    long nbl() {
        return Long.parseLong(n(), 2);
    }

    int ni() {
        return Integer.parseInt(n());
    }

    double nd() {
        return Double.parseDouble(n());
    }

    long nl() {
        return Long.parseLong(n());
    }

    public static void main(String[] args) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("skidesign.in");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("skidesign.out");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader in = new InputStreamReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        skidesign solver = new skidesign();
        solver.solve(1, in, out);
        out.close();
    }

}
