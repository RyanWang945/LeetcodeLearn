package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/6/24 19:28
 */
public class _560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int pre=0;
        for(int i:nums){
            pre+=i;
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
