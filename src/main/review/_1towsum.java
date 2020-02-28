/**
 * @author Ryan
 * @date 2019/12/27 12:18
 */
public class _1towsum {
    public int[] twoSum(int[] nums, int target){
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No such soulution");
    }
}
