package leetcode;

public class question05 {
//    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//    示例 1：
//
//    输入: "babad"
//    输出: "bab"
//    注意: "aba" 也是一个有效答案。
//    示例 2：
//
//    输入: "cbbd"
//    输出: "bb"

    public static void main(String[] args) {

//        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestCommonSubstring("aqwerqtqq"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 2) {
            return String.valueOf(s.charAt(0));
        }
        int max = 1;
        String sub = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if ((j - i + 1) > max && judge(s, i, j)) {
                    max = j - i + 1;
                    sub = s.substring(i, j + 1);
                }
            }
        }
        return sub;
    }

    public static boolean judge(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static String longestCommonSubstring(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        String reverse = new StringBuffer(s).reverse().toString();
        int len = s.length();
        String res;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
            }
        }

        return reverse;
    }

}
