package algorithmnote.快排;

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
        int[] test=new int[]{41,0,88,48,60,42,49,21,48,88};
        quicksort(test,0,test.length-1);
        for(int x :test){
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        int i=0;
        for(;i<10;i++){
            if(i==5)
                break;
        }
        System.out.println(i);
    }
    public void quicksort(int[] nums,int left,int right){
        if(left<right){
            int pos=partition2(nums,left,right);
            quicksort(nums,left,pos-1);
            quicksort(nums,pos+1,right);
        }
    }
    public int partition2(int[] nums,int left, int right){
        int temp=nums[left];
        while(left<right){
            while(left<right&&nums[right]>temp) right--;
            nums[left]=nums[right];
            while(left<right&&nums[left]<=temp) left++;
            nums[right]=nums[left];
        }
        System.out.println(temp);
        nums[left]=temp;
        return left;
    }

}
