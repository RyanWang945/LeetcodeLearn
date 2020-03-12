package leetcode;

/**
 * @author Ryan
 * @date 2020/3/11 9:21
 */
public class _98isValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }
    public boolean dfs(TreeNode node,TreeNode min,TreeNode max){
        if(node==null) return true;
        if(min!=null&&min.val>=node.val) return false;
        if(max!=null&&max.val<=node.val) return false;
        return dfs(node.left,min,node)&&dfs(node.right,node,max);
    }
}
