package Sort;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/2/26 21:26
 */
public class MyQuickSort {
    public void quickSort(int[] nums,int left,int right){
        if(left<right){
            int pos=partition(nums,left,right);
            quickSort(nums,left,pos-1);
            quickSort(nums,pos+1,right);
        }
    }
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
    @Test
    public void test_quicksort(){
        int[] test=new int[]{22,43,13,32,77,96,33,32,11,24,62};
        quickSort(test,0,test.length-1);
        for(int x :test){
            System.out.println(x);
        }
    }
}
