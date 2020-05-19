package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/7 9:46
 */
public class _572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null) return true;
        return dfs(s,t);
    }
    private boolean dfs(TreeNode s, TreeNode t){
        if(s==null) return false;
        boolean flag=false;
        if(s.val==t.val){
            flag=dfs2(s,t);
        }
        if(flag==true)
            return flag;
        else
            return dfs(s.left,t)||dfs(s.right,t);
    }
    private boolean dfs2(TreeNode s, TreeNode t){
        if(s==null&&t==null) return true;
        if(s!=null&&t!=null&&s.val==t.val){
            return dfs2(s.left,t.left)&&dfs2(s.right,t.right);
        }else return false;
    }

}
