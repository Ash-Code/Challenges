package tasks;

import java.util.Arrays;

public class PalindromePath {
    public int shortestLength(int n, int[] a, int[] b, String c) {
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], INF);
        dp[i][i]=0;
        }

        for (int i = 0; i < a.length; i++) {
            map[a[i]][b[i]] =map[b[i]][a[i]]= c.charAt(i);
            dp[a[i]][b[i]] =dp[b[i]][a[i]]= 1;
        }
        int done = 0;
        while (true) {
            done = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k1 = 0; k1 < n; k1++) {
                        if (map[i][k1] != 0)
                            for (int k2 = 0; k2 < n; k2++) {
                                if (map[j][k2] != 0) {
                                    if (k1 == j || k2 == i || dp[k1][k2] == INF)
                                        continue;
                                    if (map[i][k1] == map[j][k2]) {
                                        int reduced=dp[i][k1]+dp[k1][k2]+dp[j][k2];
                                        if(dp[i][j]>reduced){
                                            dp[i][j]=dp[j][i]=reduced;
                                            done++;
                                        }
                                    }
                                }
                            }
                    }
                }
            }
            if (done == 0)
                break;
        }

        return dp[0][1]==INF?-1:dp[0][1];
    }
}
