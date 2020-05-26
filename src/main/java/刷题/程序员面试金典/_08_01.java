package 刷题.程序员面试金典;

/**
 * @author Ryan
 * @date 2020/5/26 9:52
 */
public class _08_01 {
    public int waysToStep(int n) {
        int[] dp=new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        int mod=1000000007;
        for(int i=4;i<=n;i++){
            dp[i]=((dp[i-1]+dp[i-2])%mod+dp[i-3])%mod;
        }
        return dp[n];
    }
}
