package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        List<List<String>> result=new ArrayList<>();
        int[] arr=new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=9;
        }
        nQueen(result,arr,0);
        for (List<String> list:result) {
            for (String ss:list) {
                System.out.println(ss);
            }
            System.out.println();
        }
    }

    public static void nQueen(List<List<String>> result, int[] arr, int x) {
        if (x == arr.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < arr.length; j++) {
                    if (j != arr[i]) {
                        stringBuilder.append(".");
                    } else
                        stringBuilder.append("Q");
                }
                list.add(stringBuilder.toString());
            }
            result.add(list);
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[x]=i;
                if (judge(arr,i)){
                    nQueen(result,arr,x+1);
                }
            }
        }

    }

    public static boolean judge(int[] arr, int x) {
        for (int i = 0; i < x; i++) {
            if (arr[i] == arr[x] || Math.abs(i - arr[i]) == Math.abs(x - arr[x]) || (i + arr[i]) == (x + arr[x])) {
                return false;
            }
        }
        return true;
    }
}
