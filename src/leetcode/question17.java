package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question17 {
    /*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。*/
//    final static Map<Character,char[]> map = new HashMap<>();
     final static Map<Character,char[]> map = new HashMap<Character, char[]>(){
        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r','s'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y','z'});
        }
    };
//    static {
//        map.put('2', new char[]{'a', 'b', 'c'});
//        map.put('3', new char[]{'d', 'e', 'f'});
//        map.put('4', new char[]{'g', 'h', 'i'});
//        map.put('5', new char[]{'j', 'k', 'l'});
//        map.put('6', new char[]{'m', 'n', 'o'});
//        map.put('7', new char[]{'p', 'q', 'r','s'});
//        map.put('8', new char[]{'t', 'u', 'v'});
//        map.put('9', new char[]{'w', 'x', 'y','z'});
//    }
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String digits="23";
        System.out.println(letterCombinations(digits));
    }
    private static List<String> letterCombinations(String digits) {
        if ( digits ==null||digits.length()==0){
            return result;
        }
        char[] ch = map.get(digits.charAt(0));
        if (digits.length()==1){
            for (int i = 0; i <ch.length ; i++) {
                result.add(String.valueOf(ch[i]));
            }
            return result;
        }

         List<String> temp =new ArrayList<>(letterCombinations(digits.substring(1)));
         result = new ArrayList<>();
        for (int i = 0; i <ch.length; i++) {
            for (String ss: temp) {
                result.add(ch[i]+ss);
            }
        }
        return result;
    }
}
