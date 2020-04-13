package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/5 21:23
 */
public class _27 {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<nums.length-count;i++){
            if(nums[i]==val){
                count++;
                int temp=i;
                while(temp<nums.length-1){
                    nums[temp]=nums[temp+1];
                    temp++;
                }
                i--;
            }
        }
        return n-count;
    }
}
