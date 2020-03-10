package leetcode;

/**
 * @author Ryan
 * @date 2020/3/10 10:27
 */
public class _112hasPathSum {
    int flag;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        dfs(root,root.val,sum);
        if(flag==1)
            return true;
        else return false;
    }
    public void dfs(TreeNode node,int s,int sum){
        if(node==null&&s==sum){
            flag = 1;
        }

        else if(node!=null){
            dfs(node.left,s+node.val,sum);
            dfs(node.right,s+node.val,sum);
        }
    }
}