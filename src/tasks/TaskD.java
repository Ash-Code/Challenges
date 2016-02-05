package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskD {
	public StringTokenizer st;
	public BufferedReader br;

    public void solve(int testNumber, InputStreamReader in, PrintWriter out) {
       br=new BufferedReader(in);

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
