package leetcode.offer;

import java.util.Arrays;

public class question56two {

    /*
    * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

 

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1
 

限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31
    *
    * */

    public static void main(String[] args) {
        int[] nums = {9,1,7,9,7,9,7};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && !flag) {
                result=nums[i];
                break;
            }
            if (nums[i] != nums[i + 1] && flag) {
                flag = false;
            }
            if (nums[i] == nums[i + 1]) {
                flag = true;
            }
        }
        if (result==0)
            result=nums[nums.length-1];

        return result;
    }


}
