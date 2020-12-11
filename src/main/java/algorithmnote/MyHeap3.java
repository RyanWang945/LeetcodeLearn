package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/2 14:25
 */
public class MyHeap3 {
    public void heapify(int[] nums,int len,int i){
        if(i>len) return;
        int c1=i*2+1;
        int c2=i*2+2;
        int max=i;
        if(c1<len&&nums[max]<nums[c1])
            max=c1;
        if(c2<len&&nums[max]<nums[c2])
            max=c2;
        if(max!=i){
            swap(nums,max,i);
            heapify(nums,len,max);
        }
    }
    public void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void buildHeap(int[] nums){
        for(int i=(nums.length-2)/2;i>=0;i--){
            heapify(nums,nums.length,i);
        }
    }
    public void heapSort(int[] nums){
        buildHeap(nums);
        for(int i=nums.length-1;i>=0;i--){
            swap(nums,0,i);
            heapify(nums,i-1,0);
        }
    }
    @Test
    public void test_heap_sort(){
        int[] tree={2,5,3,1,10,4};
        int n=6;
        heapSort(tree);
        for(int i : tree){
            System.out.println(i);
        }
    }
}
