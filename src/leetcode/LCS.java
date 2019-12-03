package leetcode;

import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine().toLowerCase();
            String s2 = scanner.nextLine().toLowerCase();
//            System.out.println(s1);
//            System.out.println(s2);
            findLCS(s1,s2);
            System.out.println(findLCS(s1,s2));
        }

    }

    public static int findLCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        char[] ss = s1.toCharArray();
        char[] aa = s2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (ss[i-1] == aa[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}
