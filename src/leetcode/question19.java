package leetcode;

public class question19 {
    /*
    * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？*/
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = null;
//        ListNode listNode2 = new ListNode(2);
//        listNode1.next = listNode2;
//        ListNode listNode3 = new ListNode(3);
//        listNode2.next = listNode3;
//        ListNode listNode4 = new ListNode(4);
//        listNode3.next = listNode4;
//        ListNode listNode5 = new ListNode(5);
//        listNode4.next = listNode5;
//        listNode5.next = null;
        ListNode head = removeNthFromEnd(listNode1, 1);
//        ListNode first = new ListNode(0);
//        first.next = head;
//        while (first.next != null) {
//            first = first.next;
//            System.out.print(first.val + " ");
//        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /*一次遍历方法*/
        if (head==null)
            return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode first = node;
        ListNode second = node;
        int len = 0;
        while (first.next != null) {
            if (len <n) {
                len++;
                first = first.next;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        second.next = second.next.next;
        return node.next;





        /*遍历两遍的方法*/
//        if (head == null)
//            return null;
//        int len = 0;
//        ListNode first=new ListNode(0);
//        first.next = head;
//        ListNode pre = first;
//        while (pre.next != null) {
//            pre = pre.next;
//            len++;
//        }
//        pre=first;
//        int i = 0;
//        while (i < len - n) {
//            i++;
//            pre = pre.next;
//        }
//        pre.next = pre.next.next;
//        return first.next;
    }
}
