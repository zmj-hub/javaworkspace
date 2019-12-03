package DP;

public class dpBeiBao {
    public static void main(String[] args) {

        int[] val = {2, 3, 4, 5, 6, 6};
        int[] v = {1, 2, 3, 4, 5, 6};
        System.out.println(beibao1(6, 12, val, v));

    }

    public static int beibao(int t, int n, int[] val, int[] v) {
        int[] now = new int[n + 1];
        for (int i = 0; i < t; i++) {
            for (int j = n; j >= v[i]; j--) {
                now[j] = Math.max(now[j], now[j - v[i]] + val[i]);
//                dp[j]=w[i]<=j?max(dp[j],dp[j-w[i]]+v[i]):dp[j];
            }
            for (int k = 0; k < n + 1; k++) {
                System.out.print(now[k] + " ");
            }
            System.out.println();

        }
        return now[n];
    }

    public static int beibao1(int t, int n, int[] val, int[] v) {
        int[] now = new int[n + 1];
        int[] pre = new int[n + 1];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < v[i]) {
                    now[j] = pre[j];
                } else {
                    now[j] = Math.max(pre[j], pre[j - v[i]] + val[i]);
                }
            }
            for (int k = 0; k < n + 1; k++) {
                System.out.print(now[k] + " ");
            }
            System.out.println();
            for (int j = 0; j <= n; j++) {
                pre[j] = now[j];
            }
        }
        return now[n];
    }
}


