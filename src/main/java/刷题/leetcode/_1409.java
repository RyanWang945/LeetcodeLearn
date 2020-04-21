package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/4/16 15:52
 */
public class _1409 {
    public int[] processQueries(int[] queries, int m) {
        int n=queries.length;
        int[] bit = new int[m+n+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            update(bit,n+i+1,1);//n+i+1是后半段m个位置，末项索引是m+n
            map.put(i+1,n+i+1);
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int oldIndex=map.get(queries[i]);
            res[i]=getSum(bit,oldIndex-1);
            int newIndex=n-i;
            update(bit,oldIndex,-1);
            map.put(queries[i],newIndex);
            update(bit,newIndex,1);
        }
        return res;
    }
    private void update(int[] bit,int i,int val){
        while(i<bit.length){
            bit[i]+=val;
            i+=i&(-i);
        }
    }
    int getSum(int[] bit,int i){
        int sum=0;
        while(i>0){
            sum+=bit[i];
            i-=i&(-i);
        }
        return sum;
    }
}
