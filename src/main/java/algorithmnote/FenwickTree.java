package algorithmnote;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;

/**
 * @author Ryan
 * @date 2020/4/14 9:02
 * 树状数组的实现
 */
public class FenwickTree {
    int n=100;
    int[] a=new int[n];//原数组
    int[] c=new int[n+1];//树状数组，下标从1开始，到n结束（包含n）
    public int lowbit(int x){
        return x&(-x);
    }

    /**
     * 在i位置上加k，需要将树状数组中在这个节点连接之上的节点值都更新，O(log n)
     */
    public void update(int i,int k){
        while(i<=n){
            c[i]+=k;
            i+=lowbit(i);
        }
    }
    public int getsum(int i){
        int res=0;
        while(i>0){
            res+=c[i];
            i-=lowbit(i);
        }
        return -1;
    }
    public int createSortedArray(int[] instructions){
        int mod=(int) 1e9+7;
        long ans=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<instructions.length;i++){
            set.add(instructions[i]);
        }
        int[] nums=new int[set.size()];
        int index=0;
        for(int i:set){
            nums[index++]=i;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<instructions.length;i++){
            map.put(nums[i],i+1);
        }
        BIT bit=new BIT(nums.length);
        for(int i=0;i<instructions.length;i++){
            int t=map.get(instructions[i]);
            int l=bit.getSum(t-1);
            int r=i-bit.getSum(t);
            ans+=Math.min(l,r);
        }
        return (int)(ans%mod);
    }
    class BIT{
        int n;
        int[] tree;
        public BIT(int n){
            this.n=n;
            tree=new int[n+1];
        }
        public int lowbit(int x){
            return x&(-x);
        }
        public void update(int i,int val){
            while(i<=n){
                tree[i]+=val;
                i+=lowbit(i);
            }
        }
        public int getSum(int i){
            int res=0;
            while(i>0){
                res+=tree[i];
                i-=lowbit(i);
            }
            return res;
        }
    }
}
