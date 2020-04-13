package 刷题.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/6 21:00
 */
public class _104maxDepth {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return 0;
        queue.add(root);
        int depth=0;
        while(!queue.isEmpty()){
            Queue<TreeNode> temp=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);

            }
            if(temp!=null);
            depth++;
            queue=temp;
            temp=null;
        }
        return depth;
    }
}
