package DP;

public class dpGold {
    public static void main(String[] args) {
        int[] g = {400, 500, 200, 300, 350};//每座金矿金子数量
        int[] p = {5, 5, 3, 4, 3};//每座金矿需要的人数量
        System.out.println(dp(5, 10, g, p));
    }

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
