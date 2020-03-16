package leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/3/11 10:05
 */
public class _145postorderTraversal {
    /**
     * 后序遍历的递归方法
     */
    List<Integer> ans=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node){
        if(node==null) return ;
        dfs(node.left);
        dfs(node.right);
        ans.add(node.val);

    }
    /**
     * 后序遍历的迭代方法
     * 中退栈，存入stack2，左右push，循环
     */
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node=stack1.pop();
            stack2.push(node);
            if(node.left!=null)
                stack1.push(node.left);
            if(node.right!=null)
                stack1.push(node.right);
        }
        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }

}
