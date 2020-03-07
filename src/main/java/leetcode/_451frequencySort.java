package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/2/27 19:46
 */
public class _451frequencySort {
    public String frequencySort(String s) {
        if(s.length()==0)
            return s;
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>[] buckets=new ArrayList[s.length()+1];
        for(char c:map.keySet()){
            int f=map.get(c);
            if(buckets[f]==null)
                buckets[f]=new ArrayList<>();
            buckets[f].add(c);
        }
        StringBuilder str=new StringBuilder();
        for(int i=buckets.length-1;i>=0;i--){
            if(buckets[i]==null)
                continue;
            for(char c:buckets[i]){
                for(int j=0;j<i;j++){
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
