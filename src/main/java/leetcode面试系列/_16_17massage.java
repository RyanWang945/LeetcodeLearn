package leetcode面试系列;

/**
 * @author Ryan
 * @date 2020/3/24 8:34
 */
public class _16_17massage {
    /**
     * dfs超时了
     */
    int res=-1;
    public int massage(int[] nums) {
        if(nums.length==1) return nums[0];
        dfs(nums,0,0,true);
        return res;
    }
    private void dfs(int[]nums,int index,int temp,boolean flag){
        if(index==nums.length){
            res=Math.max(res,temp);
            return;
        }
        if(flag==true){
            dfs(nums,index+1,temp+nums[index],false);
            dfs(nums,index+1,temp,true);
        }
        else dfs(nums,index+1,temp,true);
    }
    public int massage2(int[] nums){
        int n=nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[1];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
