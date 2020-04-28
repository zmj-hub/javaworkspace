package leetcode.offer;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class question06 {
    /*
    * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 

限制：

0 <= 链表长度 <= 10000
    *
    * */
    public static void main(String[] args) {
        int[] result={2,3,1};
        Collections.reverse(Arrays.asList(result));

    }

    public int[] reversePrint(ListNode head) {
        Stack stack=new Stack();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] result=new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=Integer.parseInt(stack.pop().toString());
        }
        return result;
    }
}
