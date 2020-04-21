package 刷题.leetcode;

import java.util.List;

/**
 * @author Ryan
 * @date 2020/4/1 19:46
 */
public class _120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        int[] dp=new int[triangle.size()];
        dp[0]=triangle.get(0).get(0);
        int prev=0,cur;
        for(int i=1;i<triangle.size();i++){
            List<Integer> rows=triangle.get(i);
            for(int j=0;j<=i;j++){
                cur=dp[j];
                if(j==0)
                    dp[j]=cur+rows.get(j);
                else if(j==i)
                    dp[j]=prev+rows.get(j);
                else dp[j]=Math.min(cur,prev)+rows.get(j);
                prev=cur;
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();i++){
            res=Math.min(res,dp[i]);
        }
        return res;
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            dp[i][0]=triangle.get(i).get(0)+dp[i-1][0];
            dp[i][triangle.get(i).size()-1]=triangle.get(i).get(triangle.get(i).size()-1)+dp[i-1][triangle.get(i-1).size()-1];
            for(int j=1;j<triangle.get(i).size()-1;j++){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<dp[n-1].length;i++){
            res=Math.min(dp[n-1][i],res);
        }
        return res;
    }
}
