package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/26 16:47
 */
public class _303 {



}
class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums=new int[nums.length];
        if(nums.length==0)
            return;
        sums[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            sums[i]+=sums[i-1]+nums[i];
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return sums[j];
        else return sums[j]-sums[i-1];
    }
}

