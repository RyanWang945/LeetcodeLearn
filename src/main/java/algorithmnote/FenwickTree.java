package algorithmnote;

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
        while(i>=0){
            res+=c[i];
            i-=lowbit(i);
        }
        return -1;
    }
}
