package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/11 21:31
 */
public class _1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int n=grid.length,m=0,res=0;
        if(n==0) return 0;
        m=grid[0].length;
        int[][][] dp=new int[n+1][m+1][2];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int d=0;
                if(grid[i-1][j-1]==1){
                    dp[i][j][0]=dp[i][j-1][0]+1;
                    dp[i][j][1]=dp[i-1][j][1]+1;
                    d=Math.min(dp[i][j-1][0],dp[i-1][j][1]);
                    while(d>0){
                        if(dp[i][j-d][1]>d&&dp[i-d][j][0]>d) break;
                        d--;
                    }
                    res=Math.max(res,d+1);
                }
            }
        }
        return res*res;
    }
}
