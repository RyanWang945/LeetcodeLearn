package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/6 13:50
 */
public class _102levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            Queue<TreeNode> temp=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                if(node!=null)
                    list.add(node.val);
                if(node.left!=null){
                    temp.add(node.left);
                }
                if(node.right!=null) {
                    temp.add(node.right);
                }
            }
            queue=temp;
            ans.add(list);
        }
        return ans;
    }

    /**
     * Official answer,递归的官方解法
     * @param root
     * @return
     */
    List<List<Integer>> levels=new ArrayList<>();
    public void helper(TreeNode node,int level){
        if(levels.size()==level)
            levels.add(new ArrayList<Integer>());
        levels.get(level).add(node.val);
        if(node.left!=null)
            helper(node.left,level+1);
        if(node.right!=null)
            helper(node.right,level+1);
    }
    public List<List<Integer>> levelOrder2(TreeNode root){
        if(root==null)
            return levels;
        helper(root, 0);
        return levels;
    }
}