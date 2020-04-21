package 刷题.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/4/13 10:37
 */
public class _95 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generate_trees(1,n);
    }
    public List<TreeNode> generate_trees(int start,int end){
        List<TreeNode> all_trees=new ArrayList<>();
        if(start>end){
            all_trees.add(null);
            return all_trees;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left_trees=generate_trees(start,i-1);
            List<TreeNode> right_trees=generate_trees(i+1,end);
            for(TreeNode l:left_trees){
                for(TreeNode r:right_trees){
                    TreeNode current_tree=new TreeNode(i);
                    current_tree.left=l;
                    current_tree.right=r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
}
