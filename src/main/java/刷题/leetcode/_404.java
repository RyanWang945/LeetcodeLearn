package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/7/28 8:45
 */
public class _404 {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return sum;
        dfs(root);
        return sum;
    }
    private void dfs(TreeNode root){
        if(root!=null){
            dfs(root.left);
            dfs(root.right);
        }
        if(root==null||root.left==null) return;
        if(root.left.left==null&&root.left.right==null){
            sum+=root.left.val;
        }
    }

    /**
     * 前序遍历和后序遍历其实都可以
     */
    int sum2=0;
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root==null) return sum;
        dfs2(root);
        return sum;
    }
    private void dfs2(TreeNode root){

        if(root==null) return;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            sum2+=root.left.val;
        }

        dfs2(root.left);
        dfs2(root.right);
    }

}
