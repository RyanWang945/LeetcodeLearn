package algorithmnote;

/**
 * @author Ryan
 * @date 2020/5/2 14:50
 */
public class testSegment {
    private class NumArray{
        private SegmentTreeNode root;
        private SegmentTreeNode buildTree(int start, int end ,int[] nums){
            if(start>end) return null;
            if(start==end) return new SegmentTreeNode(start, end, nums[start]);
            int mid=start+(end-start)/2;
            SegmentTreeNode left=buildTree(start,mid,nums);
            SegmentTreeNode right=buildTree(mid+1,end,nums);
            return new SegmentTreeNode(start, end,left.sum+right.sum,left,right);
        }
        private void updateTree(SegmentTreeNode root,int i,int val){
            if(root.start==root.end&&root.start==i){
                root.sum=val;
                return;
            }
            int mid=root.start+(root.end-root.start)/2;
            if(i<=mid)
                updateTree(root.left,i,val);
            else
                updateTree(root.right,i,val);
            root.sum=root.left.sum+root.right.sum;
        }
        private int query(SegmentTreeNode root,int i,int j){
            if(root.start==i&&root.end==j)
                return root.sum;
            int mid=root.start+(root.end-root.start)/2;
            if(j<=mid)
                return query(root.left,i,j);
            else if(i>mid)
                return query(root.right,i,j);
            else
                return query(root.left,i,mid)+query(root.right,mid+1,j);
        }
        public NumArray(int[] nums){
            root=buildTree(0,nums.length-1,nums);
        }
        public void update(int i,int val){
            updateTree(root,i,val);
        }
        public int sumRange(int i,int j){
            return query(root,i,j);
        }
    }
    private static class SegmentTreeNode{
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start,int end,int sum){
            this.start=start;
            this.end=end;
            this.sum=sum;
        }
        SegmentTreeNode(int start,int end,int sum,SegmentTreeNode left,SegmentTreeNode right){
            this.start=start;
            this.end=end;
            this.sum=sum;
            this.left=left;
            this.right=left;
        }
    }
}
