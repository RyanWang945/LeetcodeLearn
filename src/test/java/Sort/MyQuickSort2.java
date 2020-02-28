package Sort;

/**
 * @author Ryan
 * @date 2020/2/28 21:02
 */
public class MyQuickSort2 {
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
    public void quicksort(int[] nums,int left,int right){
        if(left<right){
            int pos=partition(nums,left,right);
            quicksort(nums,left,pos-1);
            quicksort(nums,pos+1,right);
        }
    }
}
