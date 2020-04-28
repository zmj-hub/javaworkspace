package leetcode.offer;

public class question05 {

    /*
    *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000
    *
    * */

    public static void main(String[] args) {
        String s = "ww w e";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' ') {
                result.append("%20");
            } else {
                result.append(temp);
            }
        }
        return result.toString();
//        return s.replace(" ","%20");
    }
}
