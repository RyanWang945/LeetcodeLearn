package 刷题.程序员面试金典;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/5/1 15:40
 */
public class _17_18 {
    public int[] shortestSeq(int[] big, int[] small) {
        if(big.length<small.length) return new int[0];
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> need=new HashMap<>();
        for(int i:small){
            need.put(i,1);
        }
        int left=0,right=0,valid=0;
        int[] ans=new int[2];
        int start=0,end=0,len=Integer.MAX_VALUE;
        while(right<big.length){
            int a=big[right++];
            map.put(a,map.getOrDefault(a,0)+1);
            if(need.containsKey(a)){
                if(need.get(a).equals(map.get(a)))
                    valid++;
            }
            while(valid==small.length){
                if(right-left<len){
                    start=left;
                    end=right;
                    len=right-left;
                }
                int b=big[left++];
                if(need.containsKey(b)){
                    if(need.get(b).equals(map.get(b)))
                        valid--;
                }
                map.put(b,map.getOrDefault(b,1)-1);
            }
        }
        if(start!=0||end!=0||len!=0){
            ans[0]=start;
            ans[1]=end-1;
        }
        if(ans[1]==-1) return new int[0];
        return ans;
    }
    @Test
    public void test(){
        int[] a=new int[]{1, 2, 1, 2, 1, 2};
        int[] b=new int[]{1, 2};
        int[] ints = shortestSeq(a, b);
        System.out.println(ints[0]+" "+ints[1]);
    }
}
