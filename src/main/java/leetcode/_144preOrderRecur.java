package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/3/16 13:08
 */
public class _144preOrderRecur {
    /**
     * 前序遍历
     * 首先是简单的dfs
     */
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root){
        if(root==null)
            return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
    /**
     * 然后是迭代解法
     * 中访问，右左push
     */
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
        return res;
    }
}
