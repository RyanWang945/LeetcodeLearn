package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/4 9:11
 */
public class _238 {
    public int[] productExceptSelf(int[] nums) {
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        dp1[0]=1;
        for(int i=1;i<nums.length;i++){
            dp1[i]=dp1[i-1]*nums[i-1];
        }
        dp2[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            dp2[i]=dp2[i+1]*nums[i+1];
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=dp1[i]*dp2[i];
        }
        return ans;
    }
}
