package leetcode;

public class question409 {

    /*给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。*/

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int[] flag = new int[128];
        for (char c : s.toCharArray()) {
            flag[c]++;
        }
        int oddFlag = 0;
        int count = 0;
        for (int i = 0; i < 128; i++) {
            if (flag[i] % 2 == 0) {
                count += flag[i];
            } else {
                if (oddFlag == 0) {
                    count++;
                    oddFlag = 1;
                }
                count += (flag[i] - 1);
            }
        }

        return count;
    }
}
