package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/6/2 10:14
 */
public class _802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> path=new ArrayList<>();
        if(graph==null) return path;
        int[] flag=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(flag[i]==2||!hasCycle(graph,i,flag)) path.add(i);
        }
        return path;
    }
    private boolean hasCycle(int[][] graph,int node,int[] flag){
        if(flag[node]==1) return true;
        if(flag[node]==2) return false;
        flag[node]=1;
        for(int branch:graph[node])
            if(hasCycle(graph,branch,flag)) return true;
        flag[node]=2;
        return false;
    }
}
