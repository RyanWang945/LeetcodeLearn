package leetcode;

/**
 * @author Ryan
 * @date 2020/3/18 13:51
 */
public class _19removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode fast=pre,slow=pre;
        while(n!=0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return pre.next;
    }
}
