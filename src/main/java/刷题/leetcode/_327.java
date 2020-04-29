package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/22 12:06
 */
public class _327 {
    /**
     *一维dp效率比较低，从二维dp优化过来
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n=nums.length;
        long[] dp=new long[n];
        int count=0;
        for(int i=0;i<n;i++){
            dp[i]=nums[i];
            if(dp[i]>=lower&&dp[i]<=upper)
                count++;
        }
        for(int l=1;l<n;l++){
            int index=0;
            for(int i=0;i<n-l;i++){
                int j=i+l;
                dp[index]=(long)(dp[index]+nums[j]);
                if(dp[index]>=lower&&dp[index]<=upper)
                    count++;
                index++;
            }
        }
        return count;
    }
}
