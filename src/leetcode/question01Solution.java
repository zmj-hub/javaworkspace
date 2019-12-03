package leetcode;

import java.util.Arrays;

public class question01Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] a = twoSum(nums, 6);
//        for (int i = 0; i <a.length ; i++) {
//            System.out.print(a[i]+" ");
//        }
        Arrays.stream(a).forEach(value -> System.out.print(value+" "));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
//                    int first=nums[i];
//                    int second=nums[j];
                    nums = new int[]{i, j};
//                    nums={first,second};
                }
            }
        }

        return nums;
    }

}
