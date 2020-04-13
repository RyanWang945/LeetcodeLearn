package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/13 13:03
 */
public class _110isBalanced {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        dfs(root,1);
        return flag;
    }
    public int dfs(TreeNode root,int depth){
        if(root==null) return depth;
        int left=dfs(root.left,depth+1);
        int right=dfs(root.right,depth+1);
        if(Math.abs(left-right)>1)
            flag=false;
        return left>right?left:right;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        list.remove(list.size()-1);
        System.out.println(list.size());
        list.remove(list.size()-1);
        System.out.println(list.size());
    }

}
