package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/28 15:00
 */
public class _237 {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
