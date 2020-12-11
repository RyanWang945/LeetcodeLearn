package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/10 9:22
 */
public class _543diameterOfBinaryTree {
    int maxLen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return 0;
        dfs(root);
        return maxLen-1;
    }
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        maxLen=Math.max(maxLen,left+right+1);
        return Math.max(left,right)+1;
    }
}
