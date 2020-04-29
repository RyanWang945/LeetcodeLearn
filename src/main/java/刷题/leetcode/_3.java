package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/29 16:00
 */
public class _3 {
    public int lengthOfLongestSubstring(String s){
        int n=s.length(),ans=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int end=0,start=0;end<n;end++){
            char alpha=s.charAt(end);
            if(map.containsKey(alpha)){
                start=Math.max(map.get(alpha),start);
            }
            ans=Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }
}
