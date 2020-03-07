package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/2 15:03
 */
public class MyQuickSort {
    public int partition(int[] nums,int left,int right){
        int temp=nums[left];
        while(left<right){
            while(left<right&&temp<nums[right]) right--;
            nums[left]=nums[right];
            while(left<right&&temp>=nums[left]) left++;
            nums[right]=nums[left];
        }
        nums[left]=temp;
        return left;
    }
    public void quick_sort(int[] nums,int left,int right){
        if(left<right){
            int pos=partition(nums,left,right);
            quick_sort(nums,left,pos-1);
            quick_sort(nums,pos+1,right);
        }
    }
    @Test
    public void test_quicksort(){
        int[] test=new int[]{22,43,13,32,77,96,33,32,11,24,62};
        quick_sort(test,0,test.length-1);
        for(int x :test){
            System.out.println(x);
        }
    }
}
