package DP;

import java.util.Arrays;

public class rob {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        for (int i = 2; i <= len + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }
        Arrays.sort(dp);
        return dp[len + 1];
    }
}
