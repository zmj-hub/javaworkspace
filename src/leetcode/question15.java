package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question15 {
    /*
    * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (nums.length<3)
            return result;
        for (int i = 0; i <nums.length ; i++) {
            int ll = i + 1;
            int rr = len - 1;
            if (nums[i]>0)
                break;
            if (i>0 && nums[i]==nums[i-1]) continue;
            while (ll<rr){
                /*8.11 8.26 9.26 10.26 11.26 12.26 1.26*/
                if (nums[i]+nums[ll]+nums[rr]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[ll]);
                    list.add(nums[rr]);
                    result.add(list);
                    while (ll<rr && nums[rr]==nums[rr-1]) rr--;
                    while (ll<rr && nums[ll]==nums[ll+1]) ll++;
                    rr--;
                    ll++;
                }else if (nums[i]+nums[ll]+nums[rr]>0){
                    rr--;
                }else {
                    ll++;
                }
            }

        }

        return result;
    }

}
