package 周赛;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/15 8:24
 */
public class _3_15 {
    List<Integer> list=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)
            return root;
        dfs(root);
        TreeNode res=build_tree(list);
        return res;

    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    public TreeNode build_tree(List<Integer> list){
        if(list.size()==0)
            return null;
        if(list.get(list.size()/2)==null)
            return null;
        else{
            TreeNode root=new TreeNode(list.get(list.size()/2));
            root.left=build_tree(list.subList(0,list.size()/2));
            root.right=build_tree(list.subList(list.size()/2+1,list.size()));
            return root;
        }

    }
}
