package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/20 8:57
 */
public class _1140 {
    public int stoneGameII(int[] piles) {
        if(piles==null||piles.length==0)
            return 0;
        int n=piles.length;
        suffixSum=new int[n];
        suffixSum[n-1]=piles[n-1];
        //后缀和数组,suffixSum[i]存储的是piles[i]到piles[n-1]的和
        for(int i=n-2;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+piles[i];
        }
        dp=new int[n][n];
        return findMaxStones(piles,0,1);//i指的是已经拿走了多少堆，初始显然是0，末尾显然是n，当拿走n堆时终止。
    }
    private int[] suffixSum;
    private int[][] dp;
    private int findMaxStones(int[] piles,int i,int M){
        if(i==piles.length)
            return 0;
        if(i+2*M>=piles.length)
            return suffixSum[i];
        if(dp[i][M]!=0)
            return dp[i][M];
        int minStones=Integer.MAX_VALUE;
        for(int X=1;X<=2*M;X++){
            minStones=Math.min(minStones,findMaxStones(piles,i+X,Math.max(X,M)));
        }
        dp[i][M]=suffixSum[i]-minStones;
        return dp[i][M];
    }
}
