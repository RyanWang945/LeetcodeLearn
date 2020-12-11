package 刷题.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/6/28 22:20
 */
public class _1488 {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int[] res=new int[n];
        List<Integer> zeros=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(rains[i]==0){
                zeros.add(i);
            }else{
                res[i]=-1;
                int pool=rains[i];
                if(map.containsKey(pool)){
                    int lastFull=map.get(pool);
                    int id=lower_bound2(zeros,lastFull);
                    if(id==-1) return new int[0];
                    int zeroIdx=id>=zeros.size()?-1:zeros.get(id);
                    if(zeroIdx>lastFull){
                        res[zeroIdx]=pool;
                        zeros.remove(Integer.valueOf(zeroIdx));
                        map.put(pool,i);
                    }else{
                        return new int[0];
                    }
                }else{
                    map.put(pool,i);
                }
            }
        }
        for(int i:zeros){
            res[i]=1;
        }
        return res;
    }
    private int lower_bound(List<Integer> list,int target){
        int left=0,right=list.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)>=target) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
    private int lower_bound2(List<Integer> list, int target){
        //int ans=0;
        int i=0;
        for(;i<list.size();i++){
            if(list.get(i)>target)
                return i;
        }
        return -1;
    }
}
