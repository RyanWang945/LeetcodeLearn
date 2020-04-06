package leetcode;

/**
 * @author Ryan
 * @date 2020/4/6 14:14
 */
public class _55 {
    public boolean canJump(int[] nums) {
        int len=nums.length-1;
        int temp=0;
        for(int i=0;i<=temp;i++){
            temp=Math.max(temp,nums[i]+i);
            if(i==len) return true;
        }
        return false;
    }
}
