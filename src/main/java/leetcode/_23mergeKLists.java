package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ryan
 * @date 2020/3/18 15:27
 */
public class _23mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i=0;i<lists.length;i++) {
            while(lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode head=new ListNode(0);;
        ListNode temp=head;
        while(!queue.isEmpty()){
            temp.next=queue.poll();
            temp=temp.next;
        }
        temp.next=null;
        return head.next;
    }
}
