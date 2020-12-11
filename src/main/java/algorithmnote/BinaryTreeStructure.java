package algorithmnote;


/**
 * @author Ryan
 * @date 2020/3/10 8:36
 * 这个类是二叉搜索树的工具类，包含二叉搜索树的常见操作
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class BinaryTreeStructure {
    boolean isInBST(TreeNode root,int target){
        if(root==null) return  false;
        if(root.val==target)
            return true;
        return isInBST(root.left,target)||isInBST(root.right,target);
    }
    boolean isInBST2(TreeNode root,int target){
       if(root==null) return false;
       if(root.val==target) return true;
       if(root.val>target) return isInBST2(root.left,target);
       if(root.val<target) return isInBST2(root.right,target);
       return false;
    }
    TreeNode insertIntoBST(TreeNode root,int val){
        if(root==null) return new TreeNode(val);
        if(root.val<val) root.right=insertIntoBST(root.right,val);
        if(root.val>val) root.left=insertIntoBST(root.left,val);
        return root;
    }

    /**
     * 搜索二叉树删除时有三种情况
     * 1. 叶子节点，直接去世
     * 2. 非叶子，但只有一个非空子节点，让这个非空子节点接替自己的位置。
     * 3.
     * @param root
     * @param key
     * @return
     */
    TreeNode deleteNode(TreeNode root,int key){
        if(root==null) return null;
        if(root.val==key){
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode minNode=getMin(root.right);
            root.val=minNode.val;
            root.right=deleteNode(root.right,minNode.val);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }
    TreeNode getMin(TreeNode root){
        while(root.left!=null) root=root.left;
        return root;
    }
}
