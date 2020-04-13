package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/31 15:29
 */
public class _199 {
    List<Integer> ans=new ArrayList<>();
    int depth=0;
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return ans;
    }
    private void helper(TreeNode node,int now){
        if(node==null)
            return;
        if(now==depth){
            ans.add(node.val);
            depth++;
        }
        helper(node.right,now+1);
        helper(node.left,now+1);
    }
    /**
     * 更加巧妙的，都不需要深度这个值了
     * List<Integer> list = new ArrayList<>();
     *     public List<Integer> rightSideView(TreeNode root) {
     *         helper(root, 0);
     *         return list;
     *     }
     *     public void helper(TreeNode root, int n) {
     *         if (root == null) return;
     *         if (n == list.size()) list.add(root.val);
     *         helper(root.right, n + 1);
     *         helper(root.left, n + 1);
     *     }
     */
}
