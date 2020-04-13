package 刷题.周赛;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/3/7 23:04
 * id 输出是0，预期是1；
 */
public class _3_7findTheLongestSubstring {
    Set<Character> set=new HashSet<>(Arrays.asList('a','e','i','o','u'));
    public int findTheLongestSubstring(String s) {
        int temp=0;
        int len=s.length();
        for(int i=0;i<len-1;i++){
            for(int j=i;j<len;j++){
                if(isValid(s.substring(i,j)))
                    if((j-i+1)>temp)
                        temp=j-i+1;
            }
        }
        return temp;
    }
    public boolean isValid(String s){
        char[] chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            if(set.contains(chars[i]))
                map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        if(map.size()==0)
            return true;
        for(char c:map.keySet()){
            if(map.get(c)%2!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str= "刷题/leetcode";
        System.out.println(str.substring(0,3));
    }
}
