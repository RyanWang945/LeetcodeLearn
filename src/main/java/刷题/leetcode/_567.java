package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/5/1 11:37
 */
public class _567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>();
        int left=0,right=0,valid=0;
        for(char c:s1.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        while(right<s2.length()){
            char c=s2.charAt(right++);
            if(need.containsKey(c)){
                map.put(c,map.getOrDefault(c,0)+1);
                if(map.get(c).equals(need.get(c)))
                    valid++;
            }
            while(right-left>=s1.length()){
                if(valid==need.size()){
                    return true;
                }
                char d=s2.charAt(left++);
                if(need.containsKey(d)){
                    if(map.get(d).equals(need.get(d)))
                        valid--;
                    map.put(d,map.getOrDefault(d,1)-1);
                }
            }
        }
        return false;
    }
}
