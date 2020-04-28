package leetcode.offer;

import java.util.Arrays;

public class question56 {

    /*
    * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

 

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
 

限制：

2 <= nums <= 10000
    *
    *
    * */

    public static void main(String[] args) {
        int[] nums={1,2,10,4,1,4,3,3};
        singleNumbers(nums);
        System.out.println("111");
    }

    public static int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int count=0;
        boolean flag=false;
        for (int i = 0; i <nums.length-1 ; i++) {
            if (nums[i]!=nums[i+1] && !flag){
                result[count]=nums[i];
                count++;
            }
            if (nums[i]!=nums[i+1] && flag){
                flag=false;
            }
            if (nums[i]==nums[i+1]){
                flag=true;
            }
        }
        if (result[1]==0){
            result[count]=nums[nums.length-1];
        }
        return result;
    }
}
