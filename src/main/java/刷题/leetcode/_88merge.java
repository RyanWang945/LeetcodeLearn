package 刷题.leetcode;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/2/25 19:09
 */
public class _88merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1;
        int index2=n-1;
        int indexmerge=m+n-1;
        while(index1>=0||index2>=0){
            if(index1<0){
                nums1[indexmerge--]=nums2[index2--];
            }else if(index2<0){
                nums1[indexmerge--]=nums1[index1--];
            }else if(nums1[index1]>nums2[index2]){
                nums1[indexmerge--]=nums1[index1--];
            }else{
                nums1[indexmerge--]=nums2[index2--];
            }
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        System.arraycopy(nums2, 0, nums1, m, n);
        //nums2是要复制的数列，0是这个数列的起始位置，
        // nums1是复制到的目标数列，m是目标数列的起始位置，n是要复制的元素个数。
        Arrays.sort(nums1);
    }
}
