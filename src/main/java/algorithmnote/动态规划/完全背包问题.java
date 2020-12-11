package algorithmnote.动态规划;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/11/3 10:26
 */
public class 完全背包问题 {
    public static void solution(int[] w,int[] v,int n,int W){
        int[][] dp=new int[n+1][W+1];
        //显然dp[0][x]始终为0，dp[i][j]是前i件商品重量不超过j时的最大价值。
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                for(int k=0;k*w[i]<=j;k++){
                    dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j-k*w[i]]+k*v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }
    public static void solution2(int[] w,int[] v,int n,int W){
        int[][] dp=new int[n+1][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                if(j<w[i])
                    dp[i+1][j]=dp[i][j];
                else
                    dp[i+1][j]=Math.max(dp[i][j],dp[i+1][j-w[i]]+v[i]);
            }
        }
        System.out.println(dp[n][W]);
    }
    public static void main(String[] args) {
        int n=3,W=7;
        int[] w={3,4,2};
        int[] v={4,5,3};
        solution2(w,v,n,W);
    }
}

















