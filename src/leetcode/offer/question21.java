package leetcode.offer;

public class question21 {

    /*
    *
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。



示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
    * */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        exchange(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static int[] exchange(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            while (i < j) {
                if (nums[i] % 2 == 0)
                    break;
                else i++;
            }
            while (i < j) {
                if (nums[j] % 2 == 1)
                    break;
                else j--;
            }
            int temp = 0;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
