package leetcode;

import java.util.Arrays;

public class question01Solution {
//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//    示例:
//
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] a = twoSum(nums, 6);
//        for (int i = 0; i <a.length ; i++) {
//            System.out.print(a[i]+" ");
//        }
        Arrays.stream(a).forEach(value -> System.out.print(value + " "));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
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
