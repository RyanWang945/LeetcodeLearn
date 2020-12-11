package 刷题.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/7/28 9:20
 */
public class _1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set=new HashSet<>();
        for(int i:to_delete){
            set.add(i);
        }
        List<TreeNode> ans=new ArrayList<>();
        dfs(root,set,ans,false);
        return ans;
    }
    private boolean dfs(TreeNode root,Set<Integer> set,List<TreeNode> ans,boolean flag){
        boolean f=false;
        if(root==null)
            return f;
        f=set.contains(root.val);
        if(dfs(root.left,set,ans,!f))
            root.left=null;
        if(dfs(root.right,set,ans,!f))
            root.right=null;
        if(!f&&!flag)
            ans.add(root);
        return f;
    }
}
