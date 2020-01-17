package leetcode;

import java.util.Arrays;

public class question16 {
    /*
    * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).*/
    public static void main(String[] args) {
        int[] nums={1,2,0,-3};
//        [1,2,4,8,16,32,64,128]
//        82
        System.out.println(threeSumClosest(nums,1));
    }
    private static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        if (nums==null||nums.length<3)
            return result;
        Arrays.sort(nums);
        int len = nums.length;
        int sum = nums[0]+nums[1]+nums[2];
        int flag = Math.abs(sum-target);
        for (int i = 0; i <len ; i++) {
            int ll = i + 1;
            int rr = len - 1;
            while (ll<rr){
                int temp=nums[i]+nums[ll]+nums[rr];
                if (Math.abs(temp-target)<flag){
                    sum = temp;
                    flag = Math.abs(temp-target);
                }
                if (temp>target){
                    rr--;
                }else {
                    ll++;
                }
            }
        }
        return sum;
    }
}
