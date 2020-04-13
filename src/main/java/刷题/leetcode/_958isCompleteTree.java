package 刷题.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/16 16:00
 */
public class _958isCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode prev=root;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null&&prev==null)
                return false;
            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
            }
            prev=node;
        }
        return true;
    }
    @Test
    public void test(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        System.out.println(isCompleteTree(root));
    }
}
