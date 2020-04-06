package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/3/9 13:01
 * [3,2,6,5,0,3]
 */
public class _121maxProfit {
    /**
     * 还是我自己写的效率最高
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max=0;
        int min=0;
        int temp=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<prices[min]){
                min=i;
                max=i;
            }
            if(prices[i]>prices[max])
                max=i;
            if(prices[max]-prices[min]>temp)
                temp=prices[max]-prices[min];
        }
        if(temp>0)
            return temp;
        else return 0;
    }
    @Test
    public void test(){
        int[] nums={4,7,2,1};
        System.out.println(maxProfit(nums));
    }
    public int maxProfit2(int[] prices){
        int len=prices.length;
        if(len<2)
            return 0;
        int[][] dp=new int[len][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[len-1][0];
    }
    public int maxProfit3(int[] prices){
        int  len=prices.length;
        if(len<2) return 0;
        int res=0;
        int minVal=prices[0];
        for(int i=0;i<len;i++){
            res=Math.max(res,prices[i]-prices[minVal]);
            minVal=Math.min(minVal,prices[i]);
        }
        return res;
    }
    /**
     * 二维dp超出内存限制
     */
    public int maxProfit4(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n][n];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=i)
                    continue;
                res=Math.max(res,prices[j]-prices[i]);
            }
        }
        return res;
    }
}
