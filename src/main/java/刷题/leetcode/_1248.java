package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/4/21 10:15
 */
public class _1248 {
    /**
     *一维dp加遍历，超时了
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                dp[i+1]=dp[i]+1;
            }else dp[i+1]=dp[i];
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<=nums.length;j++){
                if(dp[j]-dp[i]==k)
                    count++;
            }
        }
        return count;
    }
    private class Solution {
        /**
         *双指针
         */
        public int numberOfSubarrays(int[] nums, int k) {
            if (nums == null || nums.length == 0 || nums.length < k) return 0;
            // 双指针
            int left = 0, right = 0;
            int count = 0; // 连续子数组中奇数的个数
            int res = 0;
            int preEven = 0; // 记录第一个奇数前面的偶数个数
            while (right < nums.length){
                // 连续子数组中奇数个数不够
                if (count < k){
                    if (nums[right] % 2 != 0) count++;
                    right++; // 移动右侧指针
                }
                // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
                if (count == k) {
                    preEven = 0;
                    while (count == k){
                        res++;
                        if (nums[left] % 2 != 0) count--;
                        left++;
                        preEven++;
                    }
                } else res += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
            }
            return res;
        }

        /**
         *不需要双指针的两次遍历。
         */
        public int numberOfSubarrays2(int[] nums, int k) {
            int preEven=0;
            List<Integer> list=new ArrayList<>();
            for(int i:nums){
                if ((i&1)==0){
                    preEven++;
                }else{
                    list.add(preEven+1);
                    preEven=0;
                }
            }
            list.add(preEven+1);
            // list.forEach(o-> System.out.println(o));
            int count=0;
            for (int i=0;i<list.size()-k;i++){
                count+=(list.get(i)*list.get(i+k));
            }
            return count;
        }
    }
}
