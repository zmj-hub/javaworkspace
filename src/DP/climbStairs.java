package DP;

public class climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2;
        int max = 0;
        for (int i = 3; i <= n; i++) {
            max = a + b;
            a = b;
            b = max;
        }

        return max;
    }
}
