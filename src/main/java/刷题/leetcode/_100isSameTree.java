package 刷题.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/9 19:21
 */
public class _100isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode node1=queue1.poll();
            TreeNode node2=queue2.poll();
            if(node1==null&&node2==null)
                continue;
            if((node1==null&&node2!=null)||(node1!=null&&node2==null))
                return false;
            if(node1.val==node2.val){
                if(node1.left!=null) queue1.add(node1.left);
                else queue1.add(null);
                if(node1.right!=null) queue1.add(node1.right);
                else queue1.add(null);
                if(node2.left!=null) queue2.add(node2.left);
                else queue2.add(null);
                if(node2.right!=null) queue2.add(node2.right);
                else queue2.add(null);
            }
            else return false;
        }
        return true;
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        queue1.add(p);
        queue2.add(q);
        while(!queue1.isEmpty()){
            TreeNode node=queue1.poll();
            if(node!=null){
                list1.add(node.val);
                if(node.left!=null) queue1.add(node.left);
                else queue1.add(null);
                if(node.right!=null) queue1.add(node.right);
                else  queue1.add(null);
            }
            else list1.add(null);
        }
        while(!queue2.isEmpty()){
            TreeNode node=queue2.poll();
            if(node!=null){
                list2.add(node.val);
                if(node.left!=null) queue2.add(node.left);
                else queue2.add(null);
                if(node.right!=null) queue2.add(node.right);
                else  queue2.add(null);
            }else list2.add(null);
        }
        if(list1.size()!=list2.size())
            return false;
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)==list2.get(i))
                continue;
            else if(list1.get(i)!=list2.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        list.add(null);
        list.add(2);
        list.add(null);
        list2.add(1);
        list2.add(2);
        list2.add(null);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        for(int i=0;i<3;i++){
            System.out.println(list.get(i)==list2.get(i));
        }
    }
}
