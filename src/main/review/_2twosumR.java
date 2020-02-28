/**
 * @author Ryan
 * @date 2019/12/27 12:22
 */
public class _2twosumR {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode pr=new ListNode(0);
        ListNode result=new ListNode(0);
        int a=0,b=0;//a指代除以10的余数，b指代十分位。
        result=pr;
        while(l1!=null&&l2!=null){
            ListNode temp=new ListNode(0);
            a=(l1.val+l2.val+b)%10;
            b=(l1.val+l2.val+b)/10;
            l1=l1.next;
            l2=l2.next;
            temp.val=a;
            pr.next=temp;
            pr=temp;
        }
        if(l1==null&&l2==null){
            if(b==1){
                ListNode x=new ListNode(1);
                pr.next=x;
            }
        }else if(l1!=null){
            while(l1!=null){
                ListNode temp=new ListNode(0);
                a=(l1.val+b)%10;
                b=(l1.val+b)/10;
                l1=l1.next;
                temp.val=a;
                pr.next=temp;
                pr=temp;
            }
            if(b==1){
                pr.next=new ListNode(1);
            }
        }else if(l2!=null){
            while(l2!=null){
                ListNode temp=new ListNode(0);
                a=(l2.val+b)%10;
                b=(l2.val+b)/10;
                l2=l2.next;
                temp.val=a;
                pr.next=temp;
                pr=temp;
            }
            if(b==1){
                pr.next=new ListNode(1);
            }
        }
        return result.next;
    }

}
class ListNode{
    ListNode next;
    ListNode(int i){
        this.val=i;
    }
    int val;
}
