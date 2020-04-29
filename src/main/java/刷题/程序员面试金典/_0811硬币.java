package 刷题.程序员面试金典;

/**
 * @author Ryan
 * @date 2020/4/23 9:00
 */
public class _0811硬币 {
    public int waysToChange(int n) {
        int[][] dp=new int[4][n+1];
        int[] nums=new int[]{1,5,10,25};
        int count=0;
        int mod=1000000007;
        for(int i=0;i<=n;i++)
            dp[0][i]=1;
        for(int i=0;i<4;i++)
            dp[i][0]=1;
        for(int i=1;i<4;i++){
            for(int j=1;j<=n;j++){
                if(j>=nums[i])
                    dp[i][j]=(dp[i-1][j]+dp[i][j-nums[i]])%mod;
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[3][n];
    }
}
