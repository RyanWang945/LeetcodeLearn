package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/30 14:43
 */
public class _424 {
    //第一种用数组的方法是10ms以内，但第二种用map的方法是40ms
    public int characterReplacement(String s, int k) {
        int[] map=new int[26];
        int left=0,right=0,max=0,res=0;
        int len=s.length();
        while(right<len){
            int c=s.charAt(right++)-'A';
            map[c]++;
            max=Math.max(max,map[c]);
            while(right-left>max+k){
                int d=s.charAt(left++)-'A';
                map[d]--;
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
    public int characterReplacement2(String s, int k) {
        if(s==null||s.length()==0) return 0;
        Map<Character,Integer> map=new HashMap<>();
        int left=0,right=0,max=0;
        while(right<s.length()){
            char c=s.charAt(right++);
            map.put(c,map.getOrDefault(c,0)+1);
            max=Math.max(max,map.get(c));
            if(right-left>max+k){
                char d=s.charAt(left++);
                map.put(d,map.getOrDefault(d,1)-1);
            }
        }
        return s.length()-left;
    }
}
