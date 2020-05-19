package 刷题.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ryan
 * @date 2020/5/6 10:48
 */
public class _1438 {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxQueue=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue=new PriorityQueue<>();
        int left=0,right=0,ans=0;
        while(right<nums.length){
            int a=nums[right++];
            maxQueue.add(a);
            minQueue.add(a);
            if(maxQueue.peek()-minQueue.peek()<=limit)
                ans=Math.max(right-left,ans);
            if(maxQueue.peek()-minQueue.peek()>limit){
                int b=nums[left++];
                maxQueue.remove(b);
                minQueue.remove(b);
            }
        }
        return  ans;
    }
}
