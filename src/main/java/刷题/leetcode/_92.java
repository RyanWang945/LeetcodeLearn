package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/28 14:46
 */
public class _92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

    /**
     *6月9号写的，一遍过，还挺明确的
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        int step=1;
        while(step!=m){
            pre=pre.next;
            head=head.next;
            step++;
        }
        int target=n-m+1;
        int count=0;
        ListNode dummy2=new ListNode(0);
        dummy2.next=null;
        ListNode temp;
        ListNode next;
        ListNode rear=head;
        while(count!=target){
            temp=dummy2.next;
            next=head.next;
            dummy2.next=head;
            head.next=temp;
            head=next;
            count++;
        }
        pre.next=dummy2.next;
        rear.next=head;
        return dummy.next;
    }
}
