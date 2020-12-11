package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/25 10:14
 */
public class _437 {
    int target;
    int count=0;
    int Sum;
    public int pathSum(TreeNode root, int sum) {
        target=sum;
        Sum=sum;
        dfs(root);
        return count;
    }
    private void dfs(TreeNode root){
        if(root==null) return;
        dfs2(root,0);
        dfs(root.left);
        dfs(root.right);
    }
    private void dfs2(TreeNode node,int s){
        if(node==null) return;
        if(node!=null&&s+node.val==target)
            count++;
        dfs2(node.left,s+node.val);
        dfs2(node.right,s+node.val);
        return;
    }
}
