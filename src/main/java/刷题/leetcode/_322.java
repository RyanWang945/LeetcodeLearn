package 刷题.leetcode;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/5/19 10:16
 */
public class _322 {
    /**
     * 显然，dfs会超时
     */
    int count=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins,amount,0,0,coins.length-1);
        return count==Integer.MAX_VALUE?-1:count;
    }
    private void dfs(int[] coins,int amount,int tempcount,int temp,int index){
        if(amount==temp){
            count=Math.min(tempcount,count);
            return;
        }
        if(amount<temp) return;
        if(tempcount>count)
            return;
        for(int i=index;i>=0;i--){
            dfs(coins,amount,tempcount+1,temp+coins[i],i);
        }
    }
    public int coinChange2(int[] coins, int amount) {
        int n=coins.length;
        if(n==0||amount<0) return -1;
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int min=Integer.MAX_VALUE;
            //dp[i]=min;
            for(int j=0;j<n;j++){
                if(i-coins[j]>=0&&dp[i-coins[j]]<min)
                    min=dp[i-coins[j]]+1;
            }
            dp[i]=min;
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    int[] memo;
    public int coinChange3(int[] coins, int amount) {
        if(coins.length==0)
            return -1;
        memo=new int[amount];
        return dfs(coins,amount);
    }
    private int dfs(int[] coins,int amount){
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        if(memo[amount-1]!=0)
            return memo[amount-1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res=dfs(coins,amount-coins[i]);
            if(res>=0&&res<min){
                min=res+1;
            }
        }
        memo[amount-1]=(min==Integer.MAX_VALUE?-1:min);
        return memo[amount-1];
    }
}
