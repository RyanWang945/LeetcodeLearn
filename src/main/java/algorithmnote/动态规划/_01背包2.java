package algorithmnote.动态规划;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/11/3 12:00
 */
public class _01背包2 {
    //有时重量限制过大，这是可以针对价值进行dp
    //dp[i][j]意为第i个物品时价值为j的最小重量
    //dp[0][0]=0;
    //dp[0][j]=INF
    //dp[i+1][j]=min(dp[i][j],dp[i][j-v[i]+w[i])
    public static void main(String[] args){
        //n件物品，每个物品用一次，重量限制为W，第i件物品重量为w，价值为v
        int n=4,W=5;
        int[] w={2,1,3,2};
        int[] v={3,2,4,1};
        int[][] dp=new int[n+1][21];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],(int)1e5);
        }
        dp[0][0]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=20;j++){
                if(j<v[i]){
                    dp[i+1][j]=dp[i][j];
                }else{
                    dp[i+1][j]=Math.min(dp[i][j],dp[i][j-v[i]]+w[i]);
                }
            }
        }
        int ans=0;
        for(int i=0;i<20;i++){
            if(dp[n][i]<=W) ans=i;
        }
        System.out.println(ans);
    }
}
