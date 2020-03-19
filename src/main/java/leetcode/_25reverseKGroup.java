package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/18 19:38
 */
public class _25reverseKGroup {
    @Test
    public void test() {
        ListNode root=new ListNode(1);
        ListNode n2=root.next=new ListNode(2);
        ListNode n3=n2.next=new ListNode(3);
        ListNode n4=n3.next=new ListNode(4);
        ListNode n5=n4.next=new ListNode(5);
        ListNode n6=n5.next=new ListNode(6);
        //reverseKGroup(root,2);
        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }
    }
}
