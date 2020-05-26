package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/18 20:13
 */
public class _494 {
    /**
     * 第一种方法，回溯，时间很长
     */
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,0,0,S);
        return count;
    }
    private void dfs(int[] nums,int sum,int index,int S){
        if(index==nums.length){
            if(sum==S)
                count++;
            return;
        }
        dfs(nums,sum+nums[index],index+1,S);
        dfs(nums,sum-nums[index],index+1,S);
        return;
    }
    /**
     * 动态规划，非常高效
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int[][] dp=new int[nums.length][2001];
        dp[0][nums[0]+1000]=1;
        //由于存在初始值为0的情况，故+=1
        dp[0][-nums[0]+1000]+=1;
        for(int i=1;i<nums.length;i++){
            for(int sum=-1000;sum<=1000;sum++){
                if(dp[i-1][sum+1000]>0){
                    //这里并不需要+=，但原先的+=了，第二个需要+=，是为了排除sum+nums[i]==sum-nums[i]的情况
                    dp[i][sum+nums[i]+1000]=dp[i-1][sum+1000];
                    dp[i][sum-nums[i]+1000]+=dp[i-1][sum+1000];
                }
            }
        }
        return S>1000?0:dp[nums.length-1][S+1000];
    }
}
