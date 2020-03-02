package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/2/27 9:38
 */
public class MyHeap {
    /**
     * 堆一共需要这几个函数
     * heapify，build_heap，swap，heap_sort
     * @param nums 需要排序的完全二叉树数组
     * @param i 需要堆化（heapify）的节点的索引
     */
    private static void heapify(int[] nums,int n,int i){

        if(i>=n){
            return;
        }
        int c1=2*i+1;
        int c2=2*i+2;
        int max=i;
        if(c1<n&&nums[c1]>nums[max])
            max=c1;
        if(c2<n&&nums[c2]>nums[max])
            max=c2;
        if(max!=i){
            swap(nums,max,i);
            heapify(nums,n,max);
        }
    }
    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /**
     * 如果一个大顶堆只有最上面的不符合规则，则需要从最上面往下递归heapify
     * 从上往下
     *
     */
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
    private void build_heap(int[] tree,int n){
        int last_node=n-1;
        int parent=(last_node-1)/2;
        int i;
        for(i=parent;i>=0;i--){
            heapify(tree,n,i);
        }
    }
    /**
     * 堆并不代表完全有序，若想完全有序，需要一定操作
     * 我们知道，大顶堆最上面的节点一定是最大的，
     * 因此我们可以把这个最大的节点放在一个单独的数组中，然后把最后一个叶子放在堆顶
     * 这时堆变成了部分符合堆规则，只有堆顶不符合的堆。
     * 这时我们可以从上到下heapify一遍，即可选出最大的上来当堆顶，同时使全部堆节点符合规则。
     */
    private void heap_sort(int[] tree,int n){
        build_heap(tree,n);
        int i;
        //从最末的叶子往上循环
        for(i=n-1;i>=0;i--){
            swap(tree,i,0);
            heapify(tree,i,0);//由于是从0开始的，所以是从上往下heapify
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
