package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ID: renegad2
 * LANG: JAVA
 * TASK: wormhole
 **/

public class wormhole {
    public StringTokenizer st;
    public BufferedReader br;
    public boolean[] done;
    public int n;

    private boolean isCyclic(boolean[][] visited, int curr, int last, int zap, int[][] relationmap, int[][] map) {
//        System.out.println(curr + " (" + last + ")");
        if (visited[curr][zap])
            return true;
        visited[curr][zap]=true;
        boolean ret = false;
        int relation = -1;
        int mapper = -1;
        for (int i = 0; i < n; i++) {
            if (i == last)
                if (map[curr][last] == 1 && (relationmap[curr][last] == 1 || relationmap[last][curr] == 1)) {
                    done[curr] = true;
                    return true;
                } else
                    continue;
            if (relationmap[curr][i] == 1)
                relation = i;
            if (map[curr][i] == 1)
                mapper = i;
        }
        if (last == curr) {
            if (relation > -1) {
                visited[curr][zap]=false;
                ret |= isCyclic(visited, relation, curr, 0, relationmap, map);
            }
            if (mapper > -1 && zap==0){
                ret |= isCyclic(visited, mapper, curr, 1, relationmap, map);
                done[curr] = true;}
        } else {
            if (mapper > -1 && zap==0){
                ret |= isCyclic(visited, mapper, curr, 1,relationmap, map);
                done[curr] = true;}
            else if (relation > -1){
                ret |= isCyclic(visited, relation, curr,0,relationmap, map);
                done[curr] = true;}
        }
        visited[curr][zap] = false;
        return ret;
    }

    private int bruteForce(int[][] relationmap, int[][] currMap, int used) {
        int n = relationmap.length;
        if (used == ((1 << n) - 1)) {
            done = new boolean[n];
//            System.out.println("---------");
//            printMap(currMap);
            boolean ret = false;
            for (int i = 0; i < n; i++)
                if (true||!done[i]) {
//                    System.out.println("---");

                    if (isCyclic(new boolean[n][2], i, i, 0,relationmap, currMap)) {
                        ret = true;
                        break;
                    }
                }
//            System.out.println(ret);
            return ret ? 1 : 0;
        } else {
            /*if (used == 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        currMap[i][j] = relationmap[i][j];
                    }
                }
            }*/
            int ret = 0;
            int i = 0;
            while (((1 << i) & used) != 0)
                i++;

            if (((1 << i) & used) == 0)
                for (int j = i + 1; j < n; j++) {
                    if (((1 << j) & used) == 0) {
                        currMap[i][j] = 1;
                        currMap[j][i] = 1;
                        ret += bruteForce(relationmap, currMap, used | (1 << i | 1 << j));
                        currMap[i][j] = 0;
                        currMap[j][i] = 0;
                    }
                }

            return ret;
        }
    }

    public void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++)
                System.out.print(map[i][j] + " ");
            System.out.println("");
        }
    }

    public void solve(int testNumber, InputStreamReader in, PrintWriter out) {
        br = new BufferedReader(in);
        int n = ni();
        this.n = n;
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            input[i][0] = ni();
            input[i][1] = ni();
        }
        int[][] relationmap = new int[n][n];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int pos = i;
            for (int j = 0; j < n; j++) {
                if (input[j][1] == input[i][1] && input[j][0] > input[i][0] && Math.abs(input[i][0] - input[j][0]) < min) {
                    pos = j;
                    min = Math.abs(input[i][0] - input[j][0]);
                }
            }
            if (pos != i) {
//                System.out.println("Relationship of " + i + " " + pos);
                relationmap[i][pos] = 1;
            }
        }
//        printMap(relationmap);
        out.println(bruteForce(relationmap, new int[n][n], 0));
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
