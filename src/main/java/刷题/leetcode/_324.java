package 刷题.leetcode;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/4/22 10:45
 */
public class _324 {
    public void wiggleSort(int[] nums) {
        int len=nums.length;
        int[] copy= Arrays.copyOfRange(nums,0,len);
        Arrays.sort(copy);
        int end=len-1,mid=(len+1)/2-1;
        for(int i=0;i<len;i++){
            nums[i]=i%2==0?copy[mid--]:copy[end--];
        }
    }
}
