package DP;

import java.util.Arrays;

public class maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1};
//        maxSubArray(nums);
        System.out.println(maxSubArray(nums));
    }


    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] now = new int[len + 1];
        if (nums[0] < 0) {
            now[0] = nums[0];
        }
        for (int i = 1; i <= len; i++) {
            now[i] = Math.max(nums[i - 1], now[i - 1] + nums[i - 1]);
        }
//        for (int i = 0; i <=len ; i++) {
//            System.out.print(now[i] + " ");
//        }
//        System.out.println();
        Arrays.sort(now);
//        return Arrays.stream(now).max().getAsInt();
        return now[len];
    }
}
