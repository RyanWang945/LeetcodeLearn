package algorithmnote.动态规划;

/**
 * @author Ryan
 * @date 2020/11/3 10:03
 */
public class _01背包1{
    public static void main(String[] args){
        //n件物品，每个物品用一次，重量限制为W，第i件物品重量为w，价值为v
        int n=4,W=5;
        int[] w={2,1,3,2};
        int[] v={3,2,4,1};
        //dp(i,j)，前i件物品当重量限制为j时最大价值为多少
        //dp(i+1,j)=max(dp(i,j),dp(i,j-w(i))+v(i);
        int[][] dp=new int[n+1][W+1];
        //显然dp(0,0)=0
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                if(w[i]>j){
                    dp[i+1][j]=dp[i][j];
                }else{
                    dp[i+1][j]=Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }


}
