package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/26 10:44
 */
public class _576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD=1000000007;
        if(N==0) return 0;
        int[][][] dp=new int[m+2][n+2][N+1];
        for(int x=0;x<=m+1;x++){
            dp[x][0][0]=1;
            dp[x][n+1][0]=1;
        }
        for(int x=0;x<=n+1;x++){
            dp[0][x][0]=1;
            dp[m+1][x][0]=1;
        }
        for(int k=1;k<=N;k++){
            for(int x=1;x<=m;x++){
                for(int y=1;y<=n;y++){
                    dp[x][y][k]=((dp[x-1][y][k-1]+dp[x+1][y][k-1])%MOD+(dp[x][y-1][k-1]+dp[x][y+1][k-1])%MOD)%MOD;
                }
            }
        }
        int ans=0;
        for(int k=1;k<=N;k++){
            ans=(ans+dp[i+1][j+1][k])%MOD;
        }
        return ans;
    }
}
