package leetcode;

/**
 * @author Ryan
 * @date 2020/3/14 15:45
 */
public class _70climbStairs {
    /**
     * dp[i]=dp[i-1]+dp[i-2]
     * dp[1]=1,dp[2]=2;
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        if(n==1) return 1;
        dp[2]=2;
        if(n==2) return 2;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
