package DP;

public  class DP {
    public static int dp(int n, int m, int[] g, int[] p) {
        int[] now = new int[m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= p[i]; j--) {
                now[j] = Math.max(now[j], now[j - p[i]] + g[i]);
            }
            for (int k = 0; k < m + 1; k++) {
                System.out.print(now[k] + " ");
            }
            System.out.println();
        }
        return now[m];
    }
}
