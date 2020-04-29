package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/27 18:02
 */
public class _154 {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<=right){
            if(nums[left]<nums[right]||left==right)
                return nums[left];
            int mid=left+(right-left)/2;
            if(nums[left]<nums[mid]){
                left=mid+1;
            }else if(nums[left]==nums[mid])
                left++;
            else
                right=mid;
        }
        return -1;
    }
}
