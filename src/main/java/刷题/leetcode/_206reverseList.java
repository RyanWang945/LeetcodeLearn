package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/2 20:23
 */
public class _206reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    /**
     *这个版本是最浅显易懂的
     */
    public ListNode reverseList2(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=null;
        while(head!=null){
            ListNode temp=dummy.next;
            ListNode next=head.next;
            dummy.next=head;
            head.next=temp;
            head=next;
        }
        return dummy.next;
    }
}