package algorithmnote;

/**
 * @author Ryan
 * @date 2020/5/2 10:30
 */
public class SegmentTreeDemo {
    private static class NumArray {
        SegmentTree root;
        private class SegmentTree{
            int start;
            int end;
            int sumValue;
            SegmentTree left;
            SegmentTree right;
            SegmentTree parent;
            SegmentTree(int start,int end){
                this(start,end,0);
            }
            SegmentTree(int start,int end,int sumValue){
                this.start=start;
                this.end=end;
                this.sumValue=sumValue;
            }
        }
        public NumArray(int[] nums) {
            root=buildSegmentTree(nums,0,nums.length-1);
        }
        private SegmentTree buildSegmentTree(int[] nums,int start,int end){
            if(start>end){
                return null;
            }else if(start==end)
                return new SegmentTree(start,end,nums[start]);
            int mid=start+(end-start)/2;
            SegmentTree left=buildSegmentTree(nums,start,mid);
            SegmentTree right=buildSegmentTree(nums,mid+1,end);
            SegmentTree curRoot=new SegmentTree(start,end);
            if(left!=null){
                curRoot.left=left;
                left.parent=curRoot;
                curRoot.sumValue+=left.sumValue;
            }
            if(right!=null){
                curRoot.sumValue+=right.sumValue;
                right.parent=curRoot;
                curRoot.right=right;
            }
            return curRoot;
        }
        public void update(int i, int val) {
            if(i<root.start||i>root.end){
                return;
            }
            SegmentTree node=root;
            while(node.start!=node.end){
                int mid=node.start+(node.end-node.start)/2;
                if(mid>=i)
                    node=node.left;
                else
                    node=node.right;
            }
            node.sumValue=val;
            while(node.parent!=null){
                node.parent.sumValue=node.parent.left.sumValue+node.parent.right.sumValue;
                node=node.parent;
            }
        }

        public int sumRange(int i, int j) {
            return sumNode(root,i,j);
        }
        private int sumNode(SegmentTree root,int i,int j){
            if(root.end==j&&root.start==i)
                return root.sumValue;
            else{
                int mid=root.start+(root.end-root.start)/2;
                if(mid>=j){
                    return sumNode(root.left,i,j);
                }else if(mid<i)
                    return sumNode(root.right,i,j);
                else return sumNode(root.left,i,mid)+sumNode(root.right,mid+1,j);
            }
        }
    }
}
