package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/7/11 20:24
 */
public class _315 {
    /**
     * 暴力理所应当地超时了
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j])
                    count++;
            }
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(1.2*(64/1.7/1.7)+0.23*24-16.2);
    }
}
