package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/21 15:08
 */
public class _123 {
    /**
     *二维dp，果断超时了
     */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0||n==1) return 0;
        if(n==2){
            if((prices[1]-prices[0])>0) return prices[1]-prices[0];
            else return 0;
        }
        if(n<=1) return 0;
        int ans=0;
        for(int i=1;i<=n-2;i++){
            int[][]dp1=new int[i+1][2];
            int[][]dp2=new int[n-i][2];
            dp1[0][0]=0;
            dp1[0][1]=-prices[0];
            dp2[0][0]=0;
            dp2[0][1]=-prices[i];
            for(int j=1;j<=i;j++){
                dp1[j][0]=Math.max(dp1[j-1][0],dp1[j-1][1]+prices[j]);
                dp1[j][1]=Math.max(dp1[j-1][1],-prices[j]);
            }
            for(int j=1;j<dp2.length;j++){
                dp2[j][0]=Math.max(dp2[j-1][0],dp2[j-1][1]+prices[j+i]);
                dp2[j][1]=Math.max(dp2[j-1][1],-prices[j+i]);
            }
            ans=Math.max(dp1[i][0]+dp2[dp2.length-1][0],ans);
        }
        return ans;
    }
    public int maxProfit3(int[] prices) {
        int len=prices.length;
        if(len<2) return 0;
        int[][] dp=new int[len][5];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=0;i<len;i++){
            dp[i][3]=Integer.MIN_VALUE;
        }
        for(int i=1;i<len;i++){
            dp[i][0]=0;
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return Math.max(0,Math.max(dp[len-1][2],dp[len-1][4]));
    }
    public int maxProfit2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    /**
     * dp[i][k] means the largest profit at i-th day purchased k times
     * in i-th day we can don't do  anything: dp[i][k]=dp[i-1][k]
     * we can also sell the stock at i-th day,in this case we must buy the stock before i-th day
     * 
     */
    public int maxProfit4(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int K = 2;
        int[][] dp = new int[n][K + 1];
        for (int k = 1; k <= K; k++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, prices[i] - dp[i - 1][k - 1]);
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
            }
        }
        return dp[n - 1][K];
    }

}
