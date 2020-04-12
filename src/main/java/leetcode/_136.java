package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/7 10:58
 */
public class _136 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            if(map.get(i)==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a=32;
        String b=String.valueOf(32);
        System.out.println(b);
        char[] chars = b.toCharArray();
        int sum=chars[0]-'0'+chars[1]-'0';
        System.out.println(sum);
        List<Integer> list=new ArrayList<>();
    }
}
