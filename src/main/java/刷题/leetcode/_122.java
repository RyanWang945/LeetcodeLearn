package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/20 19:08
 */
public class _122 {
    /**
     *第一种方法暴力，寻找所有上升沿
     */
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int sum=0;
        int buy=0;
        for(int i=1;i<prices.length&&buy<prices.length;i++){
            if(prices[i]<prices[buy]){
                buy=i;
            }
            else if(prices[i]>=prices[buy]){
                int start=i;
                while(start<prices.length&&prices[start]>=prices[start-1]){
                    start++;
                }
                sum+=(prices[start-1]-prices[buy]);
                i=start;
                buy=start;
            }
        }
        return sum;
    }
    /**
     * 第二种方法，dp
     */
    public int maxProfit2(int[] prices) {
        if(prices.length==0) return 0;
        int[][] dp=new int[prices.length][2];
        int sum=0;
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
