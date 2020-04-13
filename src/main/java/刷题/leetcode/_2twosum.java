package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2019/12/25 15:47
 */
public class _2twosum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        int temp2=0;
        ListNode l3=new ListNode(0);
        result=l3;
        while(l1!=null&&l2!=null){
            ListNode temp=new ListNode(0);
            temp.val=(l1.val+l2.val+temp2)%10;
            temp2=(l1.val+l2.val+temp2)/10;
            l3.next=temp;
            l3=temp;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null&&l2==null&&temp2==1){
            ListNode x=new ListNode(1);
            l3.next=x;
        } else if(l2==null){
            l3.next=l1;
            while(l1!=null){
                int t=l1.val;
                l1.val=(l1.val+temp2)%10;
                temp2=(t+temp2)/10;
                l3=l1;
                l1=l1.next;
            }
            if(temp2==1){
                l3.next=new ListNode(1);
            }
        } else if (l1==null){
            l3.next=l2;
            while(l2!=null){
                int t=l2.val;
                l2.val=(l2.val+temp2)%10;
                temp2=(t+temp2)/10;
                l3=l2;
                l2=l2.next;
            }
            if(temp2==1){
                l3.next=new ListNode(1);
            }
        }
        return result.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }

    public ListNode() {

    }
}
