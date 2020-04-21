package 刷题.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/4/14 10:02
 */
public class _307 {

}
class NumArray2{
    int[] tree;
    int[] arr;
    public NumArray2(int[] nums){
        int len=nums.length;
        tree=new int[len+1];
        arr=new int[len+1];
        for(int i=0;i<len;i++){
            update(i,nums[i]);
        }
    }
    public int lowbit(int x){
        return x&(-x);
    }
    public void update(int i,int val){
        for(int j=i+1;j<tree.length;j+=lowbit(j)){
            tree[j]+=(val-arr[i+1]);
        }
        arr[i+1]=val;
    }
    public int getSum(int x){
        int sum=0;
        for(int k=x+1;k>=1;k-=lowbit(k)){
            sum+=tree[k];
        }
        return sum;
    }
    public int sumRange(int i,int j){
        return getSum(j)-getSum(i-1);
    }
}

