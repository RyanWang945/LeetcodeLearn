package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/2 14:25
 */
public class MyHeap3 {
    public void heapify(int[] nums,int n,int i){
        if(i>=n)
            return;
        int c1=i*2+1;
        int c2=i*2+2;
        int max=i;
        if(c1<n&&nums[c1]>nums[max])
            max=c1;
        if(c2<n&&nums[c2]>nums[max])
            max=c2;
        if(max!=i) {
            swap(nums, max, i);
            heapify(nums, n, max);
        }
    }
    public void build_heap(int[] nums,int n){
        int last=n-1;
        int parent=(last-1)/2;
        for(;parent>=0;parent--){
            heapify(nums,n,parent);
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void heap_sort(int[] nums,int n){
        build_heap(nums,n);
        for(int i=n-1;i>=0;i--){
            swap(nums,0,i);
            heapify(nums,i,0);
        }
    }
    @Test
    public void test_heapify(){
        int[] nums={4,10,3,5,1,2};
        //int[] nums={2,5,3,1,10,4};
        heapify(nums,6,0);
        for(int i :nums){
            System.out.println(i);
        }
    }
    @Test
    public void test_buildheap(){
        int[] tree={2,5,3,1,10,4};
        int n=6;
        build_heap(tree,n);
        for(int i :tree){
            System.out.println(i);
        }
    }
    @Test
    public void test_heap_sort(){
        int[] tree={2,5,3,1,10,4};
        int n=6;
        heap_sort(tree,n);
        for(int i : tree){
            System.out.println(i);
        }
    }
}
