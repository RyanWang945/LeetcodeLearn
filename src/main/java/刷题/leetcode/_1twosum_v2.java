package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/1/5 12:25
 * 这个方法不能在leetcode第一题中使用，因为他们的数组是未排序的。
 */
public class _1twosum_v2 {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<j){
            if((nums[i]+nums[j])==target){
                return new int[]{i,j};
            }
            else if((nums[i]+nums[j])<target)
                i++;
            else if((nums[i]+nums[j]>target))
                j--;
        }
        throw new IllegalArgumentException("No such solution");
    }
}
