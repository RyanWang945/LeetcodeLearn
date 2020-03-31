package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/24 18:35
 */
public class _257binaryTreePaths {
    public static void main(String[] args) {
        String temp=String.valueOf(2);
        System.out.println(temp);
        temp=temp+3;
        System.out.println(temp);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        if(root==null)
            return ans;
        String temp=String.valueOf(root.val);
        dfs(ans,temp,root);
        return ans;
    }
    private void dfs(List<String>ans,String temp,TreeNode root){
        if(root.left==null&&root.right==null){
            ans.add(temp);
            return;
        }
        if(root.left!=null)
            dfs(ans,temp+"->"+root.left.val,root.left);
        if(root.right!=null)
            dfs(ans,temp+"->"+root.right.val,root.right);
    }
}
