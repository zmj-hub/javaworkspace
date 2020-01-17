package leetcode;

public class question14 {
    /*编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。*/
    public static void main(String[] args) {
        String[] str={"aa","a",};
        System.out.println(longestCommonPrefix(str));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        StringBuilder result=new StringBuilder();
        for (int i = 0; i <strs[0].length() ; i++) {
            for (int j = 1; j <strs.length ; j++) {
                if (strs[j].length()<i+1 ||strs[0].charAt(i)!= strs[j].charAt(i)){
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}
