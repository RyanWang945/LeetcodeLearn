package leetcode;


/**
 * @author Ryan
 * @date 2020/2/27 11:03
 */
public class _215FindKthLargest {
    public int findKthLargest(int[] nums, int k) {

        return 1;
    }
    public void heapify(int[] nums,int n,int i){
        int max=i;
        int c1=i*2+1;
        int c2=i*2+2;
        if(c1<n&&nums[max]<nums[c1])
            max=c1;
        if(c2<n&&nums[max]<c2)
            max=c2;
        if(max!=i){
            swap(nums,i,max);
            heapify(nums,n,max);
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void build_heap(int[] nums,int n){
        int last_node=n-1;
        int parent=(last_node-1)/2;
        int i;
        for(i=parent;i>=0;i--){
            heapify(nums,n,i);
        }
    }
}
