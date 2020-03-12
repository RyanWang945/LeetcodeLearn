package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/11 10:05
 */
public class _145postorderTraversal {
    /**
     * 后序遍历的递归方法
     */
    List<Integer> ans=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node){
        if(node==null) return ;
        dfs(node.left);
        dfs(node.right);
        ans.add(node.val);

    }
    /**
     * 后序遍历的迭代方法
     */

}
