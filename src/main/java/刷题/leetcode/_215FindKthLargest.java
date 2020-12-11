package 刷题.leetcode;
import java.math.BigInteger;

/**
 * @author Ryan
 * @date 2020/2/27 11:03
 */
public class _215FindKthLargest {
    /**
     *首先是基于快速排序的方法
     */
    public int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    private int quickSelect(int[] nums,int left,int right,int index){
        int pos=partition(nums,left,right);
        if(pos==index)
            return nums[pos];
        else{
            return pos<index?quickSelect(nums,pos+1,right,index):quickSelect(nums,left,pos-1,index);
        }
    }
    private int partition(int[] nums, int left, int right){
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

    /**
     *然后是基于堆排序的方法
     */
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        buildHeap(nums,n);
        for(int i=n-1;i>n-1-k;i--){
            swap(nums,i,0);
            heapify(nums,0,i);
        }
        return nums[n-k];
    }
    private void heapify(int[] nums,int i,int n){
        if(i>=n) return;
        int c1=i*2+1;
        int c2=i*2+2;
        int max=i;
        if(c1<n&&nums[c1]>nums[max])
            max=c1;
        if(c2<n&&nums[c2]>nums[max])
            max=c2;
        if(max!=i){
            swap(nums,i,max);
            heapify(nums,max,n);
        }
    }
    private void buildHeap(int[] nums,int n){
        int lastnode=n-1;
        int parent=(lastnode-1)/2;
        for(int i=parent;i>=0;i--){
            heapify(nums,i,n);
        }
    }
    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
