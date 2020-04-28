package leetcode;

public class question55 {
    /*
    * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
    *
    * */
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(canJump(a));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length==0){
            return false;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            if (max < (i + nums[i])) {
                max = i + nums[i];
            }
            if (max >= nums.length) {
                return true;
            }
        }
        return true;
    }
}
