package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/28 14:49
 */
public class _203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val==val){
                pre.next=curr.next;
                curr=curr.next;
                continue;
            }
            pre=pre.next;
            curr=curr.next;
        }
        return dummy.next;
    }
}
