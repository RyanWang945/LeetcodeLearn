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
        Map<Character,Integer> maps=new HashMap<>();
        for(int i=0;i<s.length();i++){
            maps.put(s.charAt(i),maps.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character>[] buckets=new ArrayList[s.length()+1];
        for(Character c:maps.keySet()){
            int frequency=maps.get(c);
            if(buckets[frequency]==null){
                buckets[frequency]=new ArrayList<>();
            }
            buckets[frequency].add(c);
        }
        char[] reverse=new char[s.length()];
        int index=0;
        for(int i=buckets.length-1;i>=0;i--){
            if(buckets[i]!=null){
                for(int j=0;j<buckets[i].size();j++) {
                    for (int count = 1; count <= i; count++) {
                        reverse[index] = buckets[i].get(j);
                        index++;
                    }
                }
            }else
                continue;
        }
        return String.valueOf(reverse);
    }
}
