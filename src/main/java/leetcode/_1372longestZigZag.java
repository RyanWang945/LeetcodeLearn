package leetcode;

/**
 * @author Ryan
 * @date 2020/3/21 22:25
 */
public class _1372longestZigZag {
    int res=0;
    public int longestZigZag(TreeNode root) {
        solve(root);
        return res-1;
    }
    private int[] solve(TreeNode cur){
        if(cur==null) return new int[] {0,0};
        int[] left=solve(cur.left);
        int[] right=solve(cur.right);
        int[] ans=new int[]{left[1]+1,right[0]+1};
        res=Math.max(this.res,ans[0]);
        res=Math.max(this.res,ans[1]);
        return ans;
    }

    private int result;

    public int longestZigZag2(TreeNode root) {
        dfs(root.left, -1, 1);
        dfs(root.right, 1, 1);
        return result;
    }

    private void dfs(TreeNode root, int last, int len) {
        if (null == root) {
            return;
        }
        result = Math.max(result, len);
        if (last == -1) {
            dfs(root.left, -1, 1);
            dfs(root.right, 1, len + 1);
        } else {
            dfs(root.left, -1, len + 1);
            dfs(root.right, 1, 1);
        }
    }
}
