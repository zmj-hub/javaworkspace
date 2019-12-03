package leetcode;

public class question02 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum=new ListNode(0);
        ListNode p =l1;
        ListNode q=l2,curr=sum;
        int  flage=0;
        while (p !=null || q!=null){
            int x=(p !=null) ? p.val:0;
            int y=(q !=null) ? q.val:0;
            flage= (x+y)>=10 ? 1:0;
            curr.next=new ListNode((x+y)%10+flage);
            curr=curr.next;
            if (p!=null){
                p=p.next;
            }
            if (q!=null){
                q=q.next;
            }
        }
        if (flage==1){
            curr.next=new ListNode(flage);
        }

        return sum.next;
    }
}
