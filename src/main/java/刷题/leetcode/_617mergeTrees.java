package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/16 15:51
 */
public class _617mergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1,t2);
    }
    private TreeNode dfs(TreeNode t1,TreeNode t2){
        if(t1!=null&&t2!=null){
            t1.val+=t2.val;
            t1.left=dfs(t1.left,t2.left);
            t1.right=dfs(t1.right,t2.right);
        }else if(t1==null&&t2!=null)
            return t2;
        else return t1;
        return t1;
    }
}
