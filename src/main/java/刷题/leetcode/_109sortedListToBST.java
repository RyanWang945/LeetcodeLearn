package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/12 19:37
 */
public class _109sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return helper(head,null);
    }
    private TreeNode helper(ListNode head,ListNode tail){
        if(head==tail) return null;
        ListNode slow=head;
        ListNode fast=head;
        //因为fast是每次 前进两个，所以有两种情况，直接到tail或者到tail前一个节点
        while(fast!=tail&&fast.next!=tail){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=helper(head,slow);
        root.right=helper(slow.next,tail);
        return root;
    }
}
