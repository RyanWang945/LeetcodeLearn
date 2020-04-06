package algorithmnote;

/**
 * @author Ryan
 * @date 2020/4/1 11:39
 */
public class _01bag {
    public int bag(int[] w,int[] v,int W,int N){
        int[][] dp=new int[N][W];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=W;j++){
                if(j-w[i-1]<0)
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.max(dp[i-1][j-w[i-1]]+v[i-1],dp[i-1][j]);
                }
            }
        }
        return dp[N][W];
    }
}
