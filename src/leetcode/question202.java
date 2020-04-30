package leetcode;

import java.util.HashSet;

public class question202 {
    /*
    *
    * 编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
* 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，
* 那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。

 

示例：

输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
    *
    * */

    public static void main(String[] args) {
        int n = 23;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        HashSet<String> hashSet = new HashSet<>();
        String s = String.valueOf(n);
        hashSet.add(s);
        int count=n;
        while (count!=1){
            count=0;
            for (int i = 0; i <s.length() ; i++) {
                count+=Math.pow(Integer.parseInt(String.valueOf(s.charAt(i))),2);
            }
            s=String.valueOf(count);
            if (hashSet.contains(s)){
                return false;
            }else
                hashSet.add(s);
        }
        return true;
    }
}
