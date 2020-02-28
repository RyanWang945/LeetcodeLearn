package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/2/27 16:33
 */
public class MyHeap2 {
    /**
     *
     * @param nums 要排序的完全二叉树
     * @param n 这个二叉树的节点个数
     * @param i 需要heapify（堆化）的节点
     */
    private void heapify(int[] nums,int n,int i){
        if(i>=n){
            return;
        }
        int c1=i*2+1;
        int c2=i*2+2;
        int max=i;
        if(c1<n&&nums[max]<nums[c1])
            max=c1;
        if(c2<n&&nums[max]<nums[c2])
            max=c2;
        if(max!=i){
            swap(nums,max,i);
            heapify(nums,n,max);
        }
    }
    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    private void build_heap(int[] nums,int n){
        int last_node=n-1;
        int parent=(last_node-1)/2;
        int i;
        for(i=parent;i>=0;i--){
            heapify(nums,n,i);
        }
    }
    private void heap_sort(int[] nums,int n){
        build_heap(nums,n);
        int i;
        for(i=n-1;i>=0;i--){
            swap(nums,0,i);
            heapify(nums,i,0);
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
    @Test
    public void test_heapify(){
        int[] nums={4,10,3,5,1,2};
        //int[] nums={2,5,3,1,10,4};
        heapify(nums,6,0);
        for(int i :nums){
            System.out.println(i);
        }
    }

    /**
     * 如果是一个完全混乱的堆，则需要建堆，建堆需要从这个完全二叉树的最后一个叶子的父亲开始heapify，从下往上
     */
    @Test
    public void test_buildheap(){
        int[] tree={2,5,3,1,10,4};
        int n=6;
        build_heap(tree,n);
        for(int i :tree){
            System.out.println(i);
        }
    }
}
