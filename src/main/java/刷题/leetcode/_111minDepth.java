package 刷题.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/7 21:22
 */
public class _111minDepth {
    /**
     *bfs写法
     */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left==null&&curr.right==null)
                    return depth;
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }

    /**
     * dfs写法
     */
    int temp=Integer.MAX_VALUE;
    public int minDepth2(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,1);
        return temp;
    }
    private void dfs(TreeNode root,int depth){
        if(root.left==null&&root.right==null){
            if(depth<temp)
                temp=depth;
        }
        if(root.left!=null)
            dfs(root.left,depth+1);
        if(root.right!=null)
            dfs(root.right,depth+1);
    }
}
