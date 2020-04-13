package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/30 19:10
 */
public class _300 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp=new int[nums.length];
        dp[0]=1;
        int res=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[j]+1,dp[i]);
            }
            dp[i]=Math.max(1,dp[i]);
            res=Math.max(dp[i],res);
        }
        return res;
    }
}
