package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Biscuits {
    public static void main(String[] args) {
        int[] a = {1, 2};//小孩胃口
        int[] b = {1, 2,3};//饼干重量
        allocateBiscuits(a, b);
    }


    public static void allocateBiscuits(int a[], int b[]) {
        int length1 = a.length;
        int length2 = b.length;
        int count = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (a[i]<=b [j]) {
                    b[j] = 0;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
