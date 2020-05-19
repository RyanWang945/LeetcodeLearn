package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/18 8:56
 */
public class _152 {
    /**
     *二维dp转滚动数组
     */
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int temp=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j) continue;
                if(i==j) temp=nums[i];
                else{
                    temp=temp*nums[j];
                }
                max=Math.max(max,temp);
            }
        }
        return max;
    }
    //0是最小值，1是最大值
    public int maxProduct2(int[] nums) {
        int len=nums.length;
        if(len==0)
            return 0;
        int[][] dp=new int[len][2];
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        for(int i=1;i<len;i++){
            if(nums[i]>=0){
                dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][0]);
                dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][1]);
            }else{
                dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][1]);
                dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][0]);
            }
        }
        int res=dp[0][1];
        for(int i=1;i<len;i++){
            res=Math.max(res,dp[i][1]);
        }
        return res;
    }

    /**
     *一维dp改滚动数组，最高效
     */
    public int maxProduct3(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int preMax = nums[0];
        int preMin = nums[0];

        // 滚动变量
        int curMax;
        int curMin;

        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            } else {
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }
            res = Math.max(res, curMax);

            // 赋值滚动变量
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}
