package leetcode.offer;

public class question53 {

    /*
    * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 

示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8
 

限制：

1 <= 数组长度 <= 10000
    *
    * */
    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(missingNumber(nums));
    }

//    public static int missingNumber(int[] nums) {
//        for (int i = 0; i <nums.length ; i++) {
//            if (nums[i]!=i)
//                return i;
//        }
//        return nums.length;
//    }

    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int num = (i + j) / 2;
            if (num == nums[num])
                i = num + 1;
            else j = num - 1;
        }
        return i;
    }
}
