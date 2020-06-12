package 刷题.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/30 14:14
 */
public class _438 {
    /**
     *6月9号重做这道题，除了一点问题，卡在了最后一个样例
     * 原因在while循环内的if判断上
     * if(map.containsKey(d)){
     *     map.put(d,map.getOrDefault(d,1)-1);
     *     if(!map.get(d).equals(need.get(d)))
     *          valid--;
     * }
     * 在什么情况下这种判断方式会出问题呢？没什么不能用这种呢？
     * 比如need中 a的数量是5，而窗口中却是7，那么，如果先对a减了1，是6
     * 还是和valid不相等，这时就是错误的，valid不应该减一
     * 而正确的方式是
     * if(need.containsKey(d)){
     *     if(window.get(d).equals(need.get(d)))
     *          valid--;
     *     window.put(d,window.getOrDefault(d,1)-1);
     * }
     * 只有当存在key d并且window中和need中d 的数量相同时才valid--，这样完全
     * 避免了之前出现的状况。
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> window=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>();
        int left=0,right=0,valid=0;
        List<Integer> ans=new ArrayList<>();
        for(char c:p.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        while(right<s.length()){
            char c=s.charAt(right++);
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while(right-left>=p.length()){
                if(valid==need.size()){
                    ans.add(left);
                }
                char d=s.charAt(left++);
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d,window.getOrDefault(d,1)-1);
                }
            }
        }
        return ans;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); //用total检测窗口中是否已经涵盖了p中的字符
        for(char ch : p.toCharArray()){
            needs[ch - 'a'] ++;
        }
        while(right < s.length()){
            char chr = s.charAt(right);
            if(needs[chr - 'a'] > 0){
                window[chr - 'a'] ++;
                if(window[chr - 'a'] <= needs[chr - 'a']){
                    total --;
                }
            }
            while(total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'a'] > 0){
                    window[chl - 'a'] --;
                    if(window[chl - 'a'] < needs[chl - 'a']){
                        total ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }
}
