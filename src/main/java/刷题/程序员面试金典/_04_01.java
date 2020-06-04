package 刷题.程序员面试金典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/6/4 9:47
 */
public class _04_01 {
    class Node{
        int mark;
        List<Node> adj=new ArrayList<>();
    }
    //[start,end]
    boolean flag=false;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Node[] nodes=new Node[n];
        for(int i=0;i<n;i++){
            nodes[i]=new Node();
            nodes[i].mark=i;
        }

        for(int[] p:graph){
            int s=p[0];
            int e=p[1];
            nodes[s].adj.add(nodes[e]);
        }
        boolean[] visited=new boolean[n];
        dfs(nodes,start,target,visited);
        return flag;
    }
    private void dfs(Node[] nodes,int start,int end,boolean[] visited){
        if(flag==true)
            return;
        if(start==end){
            flag=true;
            return;
        }
        if(visited[start]) return;
        visited[start]=true;
        for(Node node:nodes[start].adj){
            dfs(nodes,node.mark,end,visited);
        }
    }
}
