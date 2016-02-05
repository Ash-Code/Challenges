package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskC {
    public StringTokenizer st;
    public BufferedReader br;

    public void solve(int testNumber, InputStreamReader in, PrintWriter out) {
        br = new BufferedReader(in);
        int n = ni();
        if (n == 0) {
            out.println("*");
            return;
        }
        int[][][] map = new int[n + 1][1 << n][1 << n];
        map[1][0][0] = 0;
        map[1][0][1] = 0;
        map[1][1][0] = 1;
        map[1][1][1] = 0;
        for (int i = 2; i <= n; i++) {
            int old_edge = 1 << (i - 1);
            for (int j = 0; j < old_edge; j++) {
                for (int k = 0; k < old_edge; k++) {
                    map[i][j][k] = map[i - 1][j][k];
                    map[i][j + old_edge][k] = map[i - 1][j][k];
                    map[i][j][k + old_edge] = map[i - 1][j][k];
                    map[i][j + old_edge][k + old_edge] = 1 - map[i - 1][j][k];
                }
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < 1 << n; j++) {
                out.print(map[n][i][j] == 1 ? "*" : "+");
            }
            out.println("");
        }

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

}
