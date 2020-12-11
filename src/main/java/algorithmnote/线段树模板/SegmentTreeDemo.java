package algorithmnote.线段树模板;


/**
 * @author Ryan
 * @date 2020/6/17 20:03
 */
public class SegmentTreeDemo {
    SegmentTreeNode root;
    public SegmentTreeNode buildTree(int start, int end, int[] nums){
        if(start>end) return null;
        if(start==end) return new SegmentTreeNode(start,end,nums[start]);
        int mid=start+(end-start)/2;
        SegmentTreeNode left=buildTree(start,mid,nums);
        SegmentTreeNode right=buildTree(mid+1,end,nums);
        return new SegmentTreeNode(start,end,left.sum+right.sum,left,right);
    }
    public void updateTree(SegmentTreeNode root, int index, int val){
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
    public int query(SegmentTreeNode root, int i, int j){
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
    public void NumArray3(int[] nums) {
        root=buildTree(0,nums.length-1,nums);
    }

    public void update(int i, int val) {
        updateTree(root,i,val);
    }

    public int sumRange(int i, int j) {
        return query(root,i,j);
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
        public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right){
            this.start=start;
            this.end=end;
            this.sum=sum;
            this.left=left;
            this.right=right;
        }
    }
}
