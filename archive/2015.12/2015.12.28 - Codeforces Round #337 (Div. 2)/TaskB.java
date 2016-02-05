package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskB {
    public StringTokenizer st;
    public BufferedReader br;

    public void solve(int testNumber, InputStreamReader in, PrintWriter out) {
        br = new BufferedReader(in);
        int n = ni();
        long[] arr = new long[n];
        long min=Integer.MAX_VALUE;
        int minp1=-1;
        int minp2=-1;
        for (int i = 0; i < n; i++) {
            arr[i] = nl();
            if(arr[i]<=min){
                min=arr[i];
                minp1=i;
            }
        }
        int d=0;
        for(int i=0;i<n;i++){
            if(arr[i]==min){
                minp2=minp1;
                minp1=i;
                d=Math.max(d,minp2>=minp1?(n-(minp2+1)+minp1):minp1-minp2-1);
            }
        }
        long res=(min*((long)arr.length))+d;
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

}
