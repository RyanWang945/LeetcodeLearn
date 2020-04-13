package 刷题.周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/7 23:26
 */
public class _3_7longestZigZag {
    int res=0;
    public int longestZigZag(TreeNode root) {
        res=0;
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

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);

    }
}
