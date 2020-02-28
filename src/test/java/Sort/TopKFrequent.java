package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/2/27 19:05
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer,Integer> maps=new HashMap<>();
        for(int num:nums){
            maps.put(num,maps.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets=new List[nums.length+1];
        for(int key:maps.keySet()){
            int frequency=maps.get(key);
            if(buckets[frequency]==null){
                buckets[frequency]=new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK=new ArrayList<>();
        for(int i=buckets.length-1;i>=0&&topK.size()<k;i--){
            if(buckets[i]!=null){
                if(buckets[i].size()<k-topK.size()){
                    topK.addAll(buckets[i]);
                }else{
                    topK.addAll(buckets[i].subList(0,k-topK.size()));
                }
            }else
                continue;
        }
        return topK;
    }
}
