package 刷题.leetcode;

import org.junit.jupiter.api.Test;

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
    @Test
    public void test(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        for(List<Integer> list:levelOrder(root)){
            for(int i:list)
                System.out.println(i);
        }
    }

    /**
     * Official answer,递归的官方解法
     * @param root
     * @return
     */

//    public void helper(TreeNode node,int level){
//        if(levels.size()==level)
//            levels.add(new ArrayList<Integer>());
//        levels.get(level).add(node.val);
//        if(node.left!=null)
//            helper(node.left,level+1);
//        if(node.right!=null)
//            helper(node.right,level+1);
//    }
    public List<List<Integer>> levelOrder2(TreeNode root){
        if(root==null)
            return levels;
        helper(root, 0);
        return levels;
    }
    List<List<Integer>> levels=new ArrayList<>();
    public void helper(TreeNode node,int level){
        if(levels.size()==level){
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if(node.left!=null)
            helper(node.left,level+1);
        if(node.right!=null)
            helper(node.right,level+1);
    }
    public List<List<Integer>> levelOrder3(TreeNode root){
        if(root==null)
            return levels;
        helper(root,0);
        return levels;
    }

    /**
     *5月13号的bfs，用size的话会比较简洁
     */
    public List<List<Integer>> levelOrder4(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer>  temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                temp.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            ans.add(temp);
        }
        return ans;
    }

    /**
     * dfs版本的层序遍历
     */
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> levelOrder5(TreeNode root) {
        if(root==null) return ans;
        dfs(1,root);
        return ans;
    }
    private void dfs(int index,TreeNode root){
        if(ans.size()<index){
            ans.add(new ArrayList<>());
        }
        ans.get(index-1).add(root.val);
        if(root.left!=null){
            dfs(index+1,root.left);
        }
        if(root.right!=null){
            dfs(index+1,root.right);
        }
    }
}
