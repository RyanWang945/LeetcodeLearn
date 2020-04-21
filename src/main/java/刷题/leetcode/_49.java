package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/4/21 16:28
 */
public class _49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            StringBuilder sb=new StringBuilder();
            int[] stringhashcode=new int[26];
            for(int i=0;i<s.length();i++){
                stringhashcode[s.charAt(i)-'a']++;
            }
            for(int i:stringhashcode){
                sb.append(i);
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(s);
            }else{
                map.put(sb.toString(),new ArrayList<>());
                map.get(sb.toString()).add(s);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String s:map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
