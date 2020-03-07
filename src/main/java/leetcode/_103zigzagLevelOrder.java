package leetcode;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/3/6 14:40
 */
public class _103zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for(int i=0;i<ans.size();i++){
            if(i%2!=0){
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }

    /**
     * 通过在暂时LinkedList的右端末尾添加一个null元素，用来判断是否遍历到LinkedList末尾
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results=new ArrayList<List<Integer>>();
        LinkedList<TreeNode> node_queue=new LinkedList<>();
        node_queue.addLast(root);
        node_queue.addLast(null);
        LinkedList<Integer> level_list=new LinkedList<>();
        boolean is_order_left=true;
        while(node_queue.size()>0){
            TreeNode curr_node=node_queue.pollFirst();
            if (curr_node!=null) {
                if(is_order_left)
                    level_list.addLast(curr_node.val);
                else level_list.addFirst(curr_node.val);
                if(curr_node.left!=null)
                    node_queue.addLast(curr_node.left);
                if(curr_node.right!=null)
                    node_queue.addLast(curr_node.right);
            }else{
                results.add(level_list);
                level_list=new LinkedList<>();
                if(node_queue.size()>0)
                    node_queue.addLast(null);
                is_order_left=!is_order_left;
            }

        }
        return results;
    }
}
