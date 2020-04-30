package leetcode.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class question50 {
    /*
    * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "
    *
    * */

    public static void main(String[] args) {
        String s = "weqqww";
        System.out.println(firstUniqChar(s));
    }

    public static char firstUniqChar(String s) {
        HashMap<Character, Boolean> hashMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hashMap.put(chars[i], !hashMap.containsKey(chars[i]));
        }
        for (Map.Entry<Character, Boolean> entry : hashMap.entrySet()) {
            if (entry.getValue())
                return entry.getKey();
        }
        return ' ';
    }
}
