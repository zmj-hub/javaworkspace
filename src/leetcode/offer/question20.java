package leetcode.offer;

public class question20 {

    /*
    *
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
* 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
* 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
    * */

    public static void main(String[] args) {
        String s = " 005047e+6";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {

        boolean number = false;
        boolean dot = false;
        boolean e = false;
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && !(e && (chars[i - 1] == 'e' || chars[i - 1] == 'E')))
                    return false;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                number = true;
            } else if (chars[i] == '.') {
                if (e || dot) {
                    return false;
                }
                dot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                if (!number || e) {
                    return false;
                }
                e = true;
                number=false;
            } else
                return false;
        }
        return number;
    }

}
