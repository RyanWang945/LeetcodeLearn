package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/29 16:00
 */
public class _3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int left=0,right=0;
        int ans=0;
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c)>1){
                char d=s.charAt(left);
                left++;
                map.put(d,map.get(d)-1);
            }
            ans=Math.max(ans,right-left);
        }
        return ans;
    }

    /**
     *5月2日没有任何帮助写的船新版本
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int left=0,right=0,ans=0;
        while(right<s.length()){
            char c=s.charAt(right++);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)==1){
                ans=Math.max(right-left,ans);
            }
            while(map.get(c)>1){
                char d=s.charAt(left++);
                map.put(d,map.getOrDefault(d,1)-1);
            }
        }
        return ans;
    }
}
