package leetcode;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/3/12 17:51
 * 从中序遍历和后序遍历中建树
 */
public class _106buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        for(int i=inorder.length-1;i>=0;i--){
            if(inorder[i]==postorder[postorder.length-1]){
                int[] post_left= Arrays.copyOfRange(postorder,0,i);
                int[] post_right=Arrays.copyOfRange(postorder,i,postorder.length-1);
                int[] in_left=Arrays.copyOfRange(inorder,0,i);
                int[] in_right=Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left=buildTree(in_left,post_left);
                root.right=buildTree(in_right,post_right);
                break;
            }
        }
        return root;
    }
}
