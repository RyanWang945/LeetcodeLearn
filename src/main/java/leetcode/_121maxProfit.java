package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/3/9 13:01
 * [3,2,6,5,0,3]
 */
public class _121maxProfit {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=0;
        int temp=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<prices[min]){
                if(prices[max]-prices[min]>temp)
                    temp=prices[max]-prices[min];
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
}
