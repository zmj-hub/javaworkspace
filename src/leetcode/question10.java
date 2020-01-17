package leetcode;

enum Result {
    TRUE, FALSE
}
public class question10 {
    /*
    * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
*/
    static Result[][] memo;
    public static void main(String[] args) {
        System.out.println(isMatch("aab","c*a*b"));
    }
    private static boolean isMatch(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);


        /*动态规划*/

//        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//        dp[s.length()][p.length()] = true;
//
//        for (int i = s.length(); i >= 0; i--){
//            for (int j = p.length() - 1; j >= 0; j--){
//                boolean first_match = (i < s.length() &&
//                        (p.charAt(j) == s.charAt(i) ||
//                                p.charAt(j) == '.'));
//                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
//                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
//                } else {
//                    dp[i][j] = first_match && dp[i+1][j+1];
//                }
//            }
//        }
//        return dp[0][0];
        
        /*回溯法*/

//        if (p.isEmpty()) return s.isEmpty();
//        boolean first_match = (!s.isEmpty() &&
//                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
//
//        if (p.length() >= 2 && p.charAt(1) == '*'){
//            return (isMatch(s, p.substring(2)) ||
//                    (first_match && isMatch(s.substring(1), p)));
//        } else {
//            return first_match && isMatch(s.substring(1), p.substring(1));
//        }




//        if (s.equals(p)){
//            return true;
//        }
//        int len = s.length();
//        int plen= p.length();
//        boolean[] dp = new boolean[len + 1];
//        char[] ss = s.toCharArray();
//        char[] pp = new char[s.length()+1];
//        int flag = 0;
//        pp[0]=ss[0];
//        for (int i = 0; i <ss.length ; i++) {
//            if (pp[i]==ss[i] || pp[i]=='.'){
//                dp[i]=true;
//                if (flag+1>=plen){
//                    return false;
//                }
//                pp[i+1]=p.charAt(flag+1);
//                if (p.charAt(flag+1)!='*'){
//                    flag=flag+1;
//                }
//            } else if(pp[i]=='*') {
//                if (ss[i]==p.charAt(flag)|| p.charAt(flag)=='.'){
//                    dp[i]=true;
//                    pp[i+1]='*';
//                }else if(ss[i]==p.charAt(flag+1) || p.charAt(flag+1)=='.'){
//                    dp[i]=true;
//                    if (flag+1>=plen){
//                        return false;
//                    }
//                    pp[i+1]=p.charAt(flag+1);
//                    if (p.charAt(flag+1)!='*'){
//                        flag=flag+1;
//                    }
//                }else {
//                    return false;
//                }
//            }else {
//                return false;
//            }
//        }
//
//        return dp[len-1];
    }
    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }


}
