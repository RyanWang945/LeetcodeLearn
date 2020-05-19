package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/1/6 22:22
 */
public class QuickSort {
    public int partition(int[]nums,int left,int right){
        int temp=nums[left];
        while(left<right){
            while(temp<nums[right]&&left<right) right--;
            nums[left]=nums[right];
            while(temp>=nums[left]&&left<right) left++;
            nums[right]=nums[left];
        }
        nums[left]=temp;
        return left;
    }
    public void quicksort(int[]nums,int left,int right){
        if(left<right){
            int pos=partition(nums,left,right);
            quicksort(nums,left,pos-1);
            quicksort(nums,pos+1,right);
        }
    }
    @Test
    public void test_quicksort(){
        int[] test=new int[]{22,43,13,32,77,96,33,32,11,24,62};
        quicksort2(test,0,test.length-1);
        for(int x :test){
            System.out.println(x);
        }
    }
    public void quicksort2(int[] nums,int left,int right){
        if(left<right){
            int pos=partition2(nums,left,right);
            quicksort2(nums,left,pos-1);
            quicksort2(nums,pos+1,right);
        }
    }
    public int partition2(int[] nums,int left,int right){
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





    public void quickSort4(int[] nums,int left, int right){
        if(left<right){
            int pos=partition(nums,left,right);
            quickSort4(nums,left,pos-1);
            quickSort4(nums,pos+1,right);
        }
    }
    public int partition4(int[] nums,int left, int right){
        int temp=nums[left];
        while(left<right){
            while(left<right&&nums[right]>temp) right--;
            nums[left]=nums[right];
            while(left<right&&nums[left]<temp) left++;
            nums[right]=nums[left];
        }
        nums[left]=temp;
        return left;
    }
    @Test
    public void testQuickSort(){
        int[] nums=new int[]{5,3,6,7,12,2,1,7};
        quickSort4(nums,0,nums.length-1);
        for(int  i:nums){
            System.out.print(i+" ");
        }
    }



















}
