package 刷题.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ryan
 * @date 2020/4/29 14:58
 */
public class _1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        //dp[i]表示以i为结尾的最大子序列和
        //较远的数据放在队头，最新的数据放在队尾
        int[] dp = new int[n];
        int ans = nums[0];
        Deque<int[]> queue = new ArrayDeque<>(); //双端队列
        for(int i=0; i<n; i++) {
            dp[i] = nums[i];
            //从队头开始查找dp[i-k,i-1]的最大值
            while(!queue.isEmpty()) {
                int[] node = queue.peekFirst();
                //在[i-k,i-1]范围内
                if(i - node[0] <= k) {
                    dp[i] = Math.max(dp[i], node[1] + nums[i]);
                    break;
                } else {
                    queue.pollFirst();
                }
            }
            //队尾加入dp[i]，把小于dp[i]的数据移除
            while(!queue.isEmpty() && queue.peekLast()[1] <= dp[i]) {
                queue.pollLast();
            }
            queue.addLast(new int[]{i, dp[i]});
            ans = Math.max(ans, dp[i]);
            //  System.out.println(dp[i] + "," + queue.peekLast()[1]);
        }
        return ans;
    }
}
