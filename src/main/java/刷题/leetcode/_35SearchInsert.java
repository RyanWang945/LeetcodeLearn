package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/1/3 22:18
 */
public class _35SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        int a=search(0,nums.length-1,nums,target);
        return a;
    }
    private int search(int left,int right,int[]nums,int target ){
        int mid;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return left;
    }
}
