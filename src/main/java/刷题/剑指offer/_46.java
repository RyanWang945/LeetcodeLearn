package 刷题.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/6/9 9:57
 */
public class _46 {
    public int translateNum(int num) {
        List<Integer> list=new ArrayList<>();
        while(num!=0){
            list.add(num%10);
            num/=10;
        }
        int[] nums=new int[list.size()];
        int index=0;
        for(int i=list.size()-1;i>=0;i--){
            nums[index++]=list.get(i);
        }
        int[] dp=new int[nums.length+1];
        dp[0]=1;
        for(int i=1;i<=nums.length;i++){
            dp[i]=dp[i-1];
            if(i>1){
                if(nums[i-2]==1||(nums[i-2]==2&&nums[i-1]<=5))
                    dp[i]+=dp[i-2];
            }
        }
        return dp[nums.length];
    }
}
