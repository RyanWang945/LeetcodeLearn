package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/5 20:45
 */
public class _523 {
    /**
     * 感觉二维dp转滚动数效率并不是很高
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(i - j == 0)
                    temp = nums[i];
                else temp = temp + nums[j];
                if(j - i >= 1) {
                    if(k != 0 && temp % k == 0)
                        return true;
                    if(k == 0 && temp == 0)
                        return true;
                }
            }
        }
        return false;
    }
}
