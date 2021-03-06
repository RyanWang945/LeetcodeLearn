package 刷题.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/6 10:28
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _101isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return true;
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1=queue.poll();
            TreeNode t2=queue.poll();
            if(t1==null&&t2==null)
                break;
            if(t1==null||t2==null) return false;
            if(t1.val!=t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args) {
        List<TreeNode> list=new ArrayList<>();
        list.add(null);
        list.add(null);
        for(TreeNode a:list){
            System.out.println(a);
        }
    }
    boolean flag=true;
    public boolean isSymmetric3(TreeNode root) {
        dfs(root,root);
        return flag;
    }
    private void dfs(TreeNode a,TreeNode b){
        if(flag==false) return;
        if(a==null&&b==null) return;
        if(a==null||b==null){
            flag=false;
            return;
        }
        if(a.val!=b.val){
            flag=false;
            return;
        }
        dfs(a.left,b.right);
        dfs(a.right,b.left);
    }
}
