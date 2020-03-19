package leetcode;

/**
 * @author Ryan
 * @date 2020/3/18 17:06
 */
public class _24swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode index=head;
        ListNode pre=new ListNode(0);
        pre.next=index;
        ListNode h=pre;
        while(index!=null&&index.next!=null){
            ListNode temp=index.next;
            index.next=temp.next;
            temp.next=index;
            pre.next=temp;
            pre=index;
            index=index.next;
        }
        return h.next;
    }
}
