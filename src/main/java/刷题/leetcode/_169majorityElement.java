package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/13 8:59
 */
public class _169majorityElement {
    public int majorityElement(int[] nums) {
        int count=1;
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==temp){
                count++;
            }else{
                count--;
                if(count==-1){
                    temp=nums[i];
                    count=1;
                }

            }
        }
        return temp;
    }
}
