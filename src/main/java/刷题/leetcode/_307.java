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
class NumArray3 {
    SegmentTreeNode root;
    public SegmentTreeNode buildTree(int start,int end,int[] nums){
        if(start>end) return null;
        if(start==end) return new SegmentTreeNode(start,end,nums[start]);
        int mid=start+(end-start)/2;
        SegmentTreeNode left=buildTree(start,mid,nums);
        SegmentTreeNode right=buildTree(mid+1,end,nums);
        return new SegmentTreeNode(start,end,left.sum+right.sum,left,right);
    }
    public void updateTree(SegmentTreeNode root,int index,int val){
        if(root.start==root.end&&root.start==index){
            root.sum=val;
            return;
        }
        int mid=root.start+(root.end-root.start)/2;
        if(index<=mid)
            updateTree(root.left,index,val);
        else if(index>mid)
            updateTree(root.right,index,val);
        root.sum=root.left.sum+root.right.sum;
    }
    public int query(SegmentTreeNode root,int i,int j){
        if(root.start==i&&root.end==j){
            return root.sum;
        }
        int mid=root.start+(root.end-root.start)/2;
        if(mid>=j)
            return query(root.left,i,j);
        else if(mid<i)//为什么mid不能等于i，因为建树过程中start到mid放在了左子树，而mid+1到end放在了右子树，所以mid==i实际上
            //是跨域区间的情形，应该在第三类。
            return query(root.right,i,j);
        else
            return query(root.left,i,mid)+query(root.right,mid+1,j);
    }
    public NumArray3(int[] nums) {
        root=buildTree(0,nums.length-1,nums);
    }

    public void update(int i, int val) {
        updateTree(root,i,val);
    }

    public int sumRange(int i, int j) {
        return query(root,i,j);
    }
}
class SegmentTreeNode{
    int start;
    int end;
    int sum;
    SegmentTreeNode left;
    SegmentTreeNode right;
    public SegmentTreeNode(int start,int end ,int sum){
        this.start=start;
        this.end=end;
        this.sum=sum;
    }
    public SegmentTreeNode(int start,int end,int sum,SegmentTreeNode left,SegmentTreeNode right){
        this.start=start;
        this.end=end;
        this.sum=sum;
        this.left=left;
        this.right=right;
    }
}

