package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/21 15:48
 */
public class _290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        String[] strs=str.split(" ");
        if(pattern.length()!=strs.length) return false;
        for(int i=0;i<strs.length;i++){
            if(!map.containsKey(pattern.charAt(i))){
                String p=strs[i];
                for(char c:map.keySet()){
                    if(p.equals(map.get(c)))
                        return false;
                }
                map.put(pattern.charAt(i),strs[i]);
            }else{
                if(!map.get(pattern.charAt(i)).equals(strs[i]))
                    return false;
            }
        }
        return true;
    }
}
