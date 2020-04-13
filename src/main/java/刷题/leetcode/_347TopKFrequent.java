package 刷题.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/2/27 12:29
 */
public class _347TopKFrequent {
    @Test
    public void test_KeySet(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,2);
        Set<Integer> n = map.keySet();
        for(int i:n){
            System.out.println(i);
        }

    }
    @Test
    public void test_TopFrequent(){
        int[] nums={1,1,1,2,2,3};
        int k=2;
        List<Integer> n = topKFrequent(nums, 2);
        for(int i:n){
            System.out.println(i);
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            //这句话很显然，当key对应的value未初始化的时候，将其初始化为0，否则取出value
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        //frequencyForNum.keySet()返回一个由这个Map的key组成的Set。
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] !=null) {
                if (buckets[i].size() <= (k - topK.size())) {
                    topK.addAll(buckets[i]);
                } else {
                    topK.addAll(buckets[i].subList(0, k - topK.size()));
                }
            }
        }
        return topK;
    }
}
