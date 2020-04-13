package 刷题.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/13 14:20
 */
public class _113pathSum {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return ans;
        List<Integer> a=new ArrayList<>();
        a.add(root.val);
        dfs(root,root.val,a,sum);
        return ans;
    }
    public void dfs(TreeNode root,int temp,List<Integer> list,int target){
        if(root.left==null&&root.right==null){
            if(temp==target){
                List<Integer> r=new ArrayList<>();
                for(Integer i:list){
                    r.add(i);
                }
                ans.add(r);
                return;
            }else{
                //list.remove(list.size()-1);
                return;
            }
        }
        if(temp>=target) return;
        if(root.left!=null){
            list.add(root.left.val);
            dfs(root.left,temp+root.left.val,list,target);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            list.add(root.right.val);
            dfs(root.right,temp+root.right.val,list,target);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        TreeNode root=new TreeNode(5);
        TreeNode left1=root.left=new TreeNode(4);
        TreeNode right1=root.right=new TreeNode(8);
        left1.left=new TreeNode(11);
        left1.left.left=new TreeNode(7);
        left1.left.right=new TreeNode(2);
        right1.right=new TreeNode(8);
        right1.right.left=new TreeNode(13);
        right1.right.right=new TreeNode(4);
        right1.right.right.left=new TreeNode(5);
        right1.right.right.right=new TreeNode(1);
        pathSum(root,22);
    }
}
