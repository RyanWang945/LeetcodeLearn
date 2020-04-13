package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/14 13:11
 */
public class _116connect {
//    public Node connect(Node root) {
//        if(root==null) return root;
//        Queue<Node> queue=new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            Node pre=new Node();
//            Queue<Node> temp=new LinkedList<>();
//            while(!queue.isEmpty()){
//                Node node = queue.poll();
//                if(node!=null){
//                    pre.next=node;
//                    pre=pre.next;
//                }else pre=null;
//                if(node.left!=null)
//                    temp.add(node.left);
//                if(node.right!=null)
//                    temp.add(node.right);
//            }
//            queue=temp;
//        }
//        return root;
//    }
//    public Node connect2(Node root){
//        if(root==null)
//            return root;
//        Node leftmost=root;
//        while(leftmost.left!=null){
//            Node head=leftmost;
//            while(head!=null){
//                head.left.next=head.right;
//                if(head.next!=null){
//                    head.right.next=head.next.left;
//                }
//                head=head.next;
//            }
//            leftmost=leftmost.left;
//        }
//        return root;
//    }
}
