package leetcode;

/**
 * @author Ryan
 * @date 2020/2/26 14:28
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class _141hasCycle {
    public boolean hasCycle(ListNode head) {
        int[] n=new int[10000000];
        int i=0;
        n[i]=head.hashCode();
        ListNode ptr=head;
        while(ptr.next!=null){
            n[++i]=ptr.next.hashCode();
            ptr=ptr.next;
            for(int j=0;j<i;j++){
                if(n[i]==n[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasCycle2(ListNode head){
        if(head==null){
            return false;
        }else if(head.next==head){
            return true;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        while(p2!=null){
            if(p1==p2){
                return true;
            }
            p1=p1.next;
            p2=p2.next.next;
        }
        return false;
    }
}
//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int x){
//        val=x;
//        next=null;
//    }
//}
