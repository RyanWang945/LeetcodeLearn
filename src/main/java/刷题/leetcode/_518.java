package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/21 9:58
 */
public class _518 {
    /**
     *二维dp
     */
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=1;i<=amount;i++) dp[0][i]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j-coins[i-1]>=0) dp[i][j]+=dp[i][j-coins[i-1]];
            }
        }
        return dp[n][amount];
    }
    /**
     * 一维dp
     */
}
