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
}