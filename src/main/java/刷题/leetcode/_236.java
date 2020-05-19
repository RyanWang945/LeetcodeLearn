package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/5/10 8:55
 */
public class _236 {
    /**
     * 存储方法的正确版本
     */
    ArrayList<TreeNode> pathRecord = new ArrayList<>();
    ArrayList<TreeNode> pAncestor = null;
    ArrayList<TreeNode> qAncestor = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //找到p、q的祖先
        preOrderedTraversal(root, p, q);
        //进行最近公共祖先寻找,从左向右找第一个不一样的
        int i = 0;
        while(i < pAncestor.size() && i < qAncestor.size() && pAncestor.get(i) == qAncestor.get(i)) i++;

        return pAncestor.get(i-1);
    }
    private void preOrderedTraversal(TreeNode node, TreeNode p, TreeNode q){
        //递归结束条件
        if(node == null)    return;

        pathRecord.add(node);
        if(node == p)
            pAncestor = new ArrayList(pathRecord);
        if(node == q)
            qAncestor = new ArrayList(pathRecord);
        preOrderedTraversal(node.left,p,q);
        preOrderedTraversal(node.right,p,q);
        pathRecord.remove(pathRecord.size() - 1);
    }
    /**
     * 递归LCA
     */
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {//当遍历到叶结点后就会返回null
            return root;
        }
        if (root == p || root == q) {//当找到p或者q的是时候就会返回pq
            return root;/*当然，值得一提的是，如果公共祖先是自己（pq），并不需要寻找另外
                     一个，我们在执行前序遍历会先找上面的，后找下面的，我们会直接返回公共祖先。*/
        }
        TreeNode left = LowestCommonAncestor(root.left, p, q);//返回的结点进行保存，可能是null
        TreeNode right = LowestCommonAncestor(root.right, p, q);//也可能是pq，还可能是公共祖先
        if (left != null && right != null) {
            return root;//如果左右都存在，就说明pq都出现了，这就是，公共祖先，此时不用考虑公共祖先是自己的情况，因为上面已经做过判断了。
        } else if (left != null) {//否则我们返回已经找到的那个值（存储在left，与right中），p或者q
            return left;//还有一种可能就是，由下面返回的公共祖先，并将这个值一路返回到最表层
        } else if (right != null) {
            return right;
        }
        return null;
    }
    /**
     * 方法一，超时
     */
    List<Integer> pList;
    List<Integer> qList;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pList=new ArrayList<>();
        qList=new ArrayList<>();
        dfs1(root,p,new ArrayList<>());
        dfs2(root,q,new ArrayList<>());
        int res=0;
        boolean flag=false;
        for(int i=pList.size()-1;i>=0;i--){
            for(int j=qList.size()-1;j>=0;j--){
                if(pList.get(i)==qList.get(j)){
                    res=pList.get(i);
                    flag=true;
                    break;
                }
            }
            if(flag==true)
                break;
        }
        for(int i:pList){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:qList){
            System.out.print(i+" ");
        }
        return new TreeNode(res);
    }
    private void dfs1(TreeNode root,TreeNode target,List<Integer> temp){
        if(root==null||pList.size()!=0){
            return;
        }
        if(root.val==target.val){
            temp.add(root.val);
            pList.addAll(temp);
            return;
        }
        temp.add(root.val);
        List<Integer> a=new ArrayList<>(temp);
        List<Integer> b=new ArrayList<>(temp);
        dfs1(root.left,target,a);
        dfs1(root.right,target,b);
    }
    private void dfs2(TreeNode root,TreeNode target,List<Integer> temp){
        if(root==null||qList.size()!=0){
            return;
        }
        if(root.val==target.val){
            temp.add(root.val);
            qList.addAll(temp);
            return;
        }
        temp.add(root.val);
        List<Integer> a=new ArrayList<>(temp);
        List<Integer> b=new ArrayList<>(temp);
        dfs2(root.left,target,a);
        dfs2(root.right,target,b);
    }
}
