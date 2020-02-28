package leetcode;

/**
 * @author Ryan
 * @date 2019/12/25 15:47
 * @version 1.0
 */
public class _1twosum {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int array[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    array[0]=i;
                    array[1]=j;
                    //return array;
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no such value");
    }
}
