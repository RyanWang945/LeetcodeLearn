package 刷题.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/7 21:22
 */
public class _111minDepth {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) {
            return 0;
        }
        queue.add(root);
        int depth=1;
        while(!queue.isEmpty()){
            Queue<TreeNode> temp=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left!=null) temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
                if(node.right==null&&node.left==null) return depth;
            }
            queue=temp;
            depth++;
        }
        return depth;
    }
}
