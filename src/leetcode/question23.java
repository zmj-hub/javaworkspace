package leetcode;

public class question23 {
    /*
    * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
    * */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
//        listNode1.next = null;
        ListNode listNode2 = new ListNode(4);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(5);
        listNode2.next = listNode3;
        listNode3.next=null;
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(4);
        listNode5.next = listNode6;
        listNode6.next=null;
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode7.next = listNode8;
        listNode8.next=null;
        ListNode[] lists=new ListNode[3];
        lists[0]=listNode1;
        lists[1]=listNode4;
        lists[2]=listNode7;
        mergeKLists(lists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len==0)
            return null;
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
            }
            if (len % 2 == 1) {
                lists[len/2] = lists[len - 1];
                len++;
            }
            len = len / 2;
        }
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultFirst = new ListNode(0);
        ListNode first = resultFirst;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                first.next = l2;
                l2 = l2.next;
            } else {
                first.next = l1;
                l1 = l1.next;
            }
            first = first.next;
        }
        first.next = l1 == null ? l2 : l1;
        return resultFirst.next;
    }
}
