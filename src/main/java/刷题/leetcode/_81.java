package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/27 16:01
 */
public class _81 {
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return false;
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target) return true;
            else if(nums[left]==nums[mid])
                left++;
            else if(nums[left]<=nums[mid]){
                if(target>=nums[left]&&target<nums[mid])
                    right=mid-1;
                else left=mid+1;
            }else{
                if(target>nums[mid]&&target<=nums[right])
                    left=mid+1;
                else right=mid-1;
            }
        }
        return false;
    }
}
