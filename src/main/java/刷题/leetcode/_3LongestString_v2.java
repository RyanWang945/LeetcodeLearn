package 刷题.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ryan
 * @date 2019/12/26 11:56
 * 值得注意的是，int数组的length是一个属性，而String的length（）是一个方法。
 * 这道题需要注意的是更新条件，i的更新取决于set中存在重复值，直接加一，而j的更新取决于新添加了一个元素。
 */
public class _3LongestString_v2 {
    public int lengthOfLongestSubstring(String s){
        int n=s.length();
        int i=0,j=0,ans=0;
        Set<Character> set=new HashSet<>();
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
