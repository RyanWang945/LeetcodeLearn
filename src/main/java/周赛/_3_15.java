package 周赛;

import java.util.*;

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
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k){
        int[][]items=new int[n][2];
        for(int i=0;i<n;i++){
            items[i][0]=speed[i];
            items[i][1]=efficiency[i];
        }
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        long res=0,sum=0;
        for(int i=0;i<n;i++){
            if(queue.size()>k-1){
                sum-=queue.poll();
            }
            res=Math.max(res,(sum+items[i][0])*items[i][1]);
            queue.add(items[i][0]);
            sum+=items[i][0];
        }
        return (int)(res%((int)1e9+7));
    }

    public static void main(String[] args) {
        //默认的priorityqueue是从队尾到队头降序，队尾进入，队头出。
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        queue.add(1);
        queue.add(3);
        queue.add(2);
        for(int i=0;i<3;i++){
            System.out.println(queue.poll());
        }
    }
    
}
