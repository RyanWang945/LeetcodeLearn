package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/3/11 9:26
 * 这里包含了二叉树的常用递归和迭代
 */
public class _94inorderTraversal {
    /**
     * 中序遍历的递归方法
     */
    List<Integer> ans=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
    }
    /**
     * 中序遍历的迭代法
     */
    public List<Integer> inorderTraversal2(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            //ans.add(stack.pop().val);
            curr=stack.pop();
            ans.add(curr.val);
            curr=curr.right;
        }
        return ans;
    }
}
