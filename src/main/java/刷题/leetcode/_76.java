package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/29 18:46
 */
public class _76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> window=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int right=0,left=0;
        int start=0,end=0;
        int valid=0;
        int len=Integer.MAX_VALUE;
        while(right<s.length()){
            char c=s.charAt(right++);
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c)))
                    valid++;
            }
            while(valid==need.size()){
                if(right-left<len){
                    start=left;
                    end=right;
                    len=right-left;
                }
                char d=s.charAt(left++);
                if(need.containsKey(d)){
                    window.put(d,window.getOrDefault(d,1)-1);
                    if(window.get(d)<need.get(d))
                        valid--;
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,end);
    }
    public String minWindow2(String s, String t) {
        int[] window=new int[58];
        int[] need=new int[58];
        for(char c:t.toCharArray()){
            need[c-'A']++;
        }
        int count=0;
        for(int i:need){
            if(i!=0)
                count++;
        }
        int left=0,right=0,start=0,end=0,len=Integer.MAX_VALUE,valid=0;
        while(right<s.length()){
            int c=s.charAt(right++)-'A';
            if(need[c]!=0){
                window[c]++;
                if(window[c]==need[c])
                    valid++;
            }
            while(valid==count){
                if(right-left<len){
                    start=left;
                    end=right;
                    len=right-left;
                }
                int d=s.charAt(left++)-'A';
                if(need[d]!=0){
                    window[d]--;
                    if(window[d]<need[d])
                        valid--;
                }
            }
        }
        return s.substring(start,end);
    }
}
