package 刷题.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/4/28 21:07
 */
public class _239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<=nums.length-k;i++){
            int temp=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                temp=Math.max(temp,nums[j]);
            }
            ans[index++]=temp;
        }
        return ans;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if(nums.length==0||nums==null) return new int[]{};
        PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
        int left=0,right=0;
        int[] ans=new int[nums.length-k+1];
        int index=0;
        while(left<nums.length-k+1&&right<nums.length){
            int a=nums[right++];
            queue.add(a);
            if(queue.size()>k){
                int b=nums[left++];
                queue.remove(b);
            }
            if(queue.size()==k)
                ans[index++]=queue.peek();
        }
        return ans;
    }
}
