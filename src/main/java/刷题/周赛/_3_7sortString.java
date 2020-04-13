package 刷题.周赛;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/3/7 22:32
 */
public class _3_7sortString {
    public String sortString(String s) {
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        Map<Character,Integer> map=new LinkedHashMap<>();
        for(char c:chars)
            map.put(c,map.getOrDefault(c,0)+1);
        StringBuilder str=new StringBuilder();
        int flag=0;
        int all=s.length()-1;
        while(all>0){
            if(flag==0){
                for(char c:map.keySet()){
                    if(map.get(c)>0){
                        str.append(c);
                        map.put(c,map.get(c)-1);
                        all--;
                    }
                }
            }else if(flag==1){
                StringBuilder temp=new StringBuilder();
                for(char c:map.keySet()){
                    if(map.get(c)>0){
                        temp.append(c);
                        map.put(c,map.get(c)-1);
                        all--;
                    }
                }

            }
        }
        return str.toString();
    }

    /**
     * 刷题.leetcode
     * cdeeelot
     * cdelotee
     * cdteloee
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder str=new StringBuilder();
        str.append('a');
        str.append('b');
        str.append('c');
        str.reverse();
        System.out.println(str);
        String s= "刷题/leetcode";
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
    }
}
