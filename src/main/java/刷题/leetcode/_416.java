package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/18 15:31
 */
public class _416 {
    //状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        //Arrays.sort(nums);
        int target=total/2;
        if(target*2!=total) return false;
        boolean[][] dp=new boolean[nums.length][target+1];
        if(nums[0]<=target)
            dp[0][nums[0]]=true;

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                //dp[i][j]=dp[i-1][j];
                if(nums[i]==j){
                    dp[i][j]=true;
                    continue;
                }
                if(nums[i]<j)
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                if(dp[i][target]) return true;
            }
        }
        return dp[nums.length-1][target];
    }
    public boolean canPartition2(int[] nums) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        int target=total/2;
        if(target*2!=total) return false;
        boolean[] dp=new boolean[target+1];
        if(nums[0]<=target)
            dp[nums[0]]=true;

        for(int i=1;i<nums.length;i++){
            for(int j=target;0<=j;j--){
                if(dp[target]) return true;
                dp[j]=dp[j]||dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
