package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question18 {
    /*
    * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
    * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/
    public static void main(String[] args) {
        int[] nums={1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums,0).toString());
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results=new ArrayList<>();
        if (nums.length<4)
            return results;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-3 ; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j <nums.length-2 ; j++) {
                if (j>(i+1) && nums[j]==nums[j-1]){
                    continue;
                }
                int x=j+1;
                int y=nums.length-1;

                while (x<y){
                    int sum=nums[i]+nums[j]+nums[x]+nums[y];
                    if (sum==target){
                        List<Integer> result=new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[x]);
                        result.add(nums[y]);
                        results.add(result);
                        while (x<y && nums[x]==nums[x+1]) x++;
                        while (x<y && nums[y]==nums[y-1]) y--;
                        x++;
                        y--;
                    }else if (sum<target){
                        x++;
                    }else {
                        y--;
                    }
                }
            }
        }
        return results;
    }
}
