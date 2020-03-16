package leetcode;

/**
 * @author Ryan
 * @date 2020/3/14 15:07
 */
public class _53maxSubArray {
    /**
     * 贪心
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int currSum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(nums[i],currSum+nums[i]);
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            if(res<dp[i])
                res=dp[i];
        }
        return  res;
    }
}
