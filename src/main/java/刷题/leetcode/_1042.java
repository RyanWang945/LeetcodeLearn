package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/6/1 10:24
 */
public class _1042 {
    class Solution{
        public int[] gardenNoAdj(int N, int[][] paths) {
            //int[] indegrees=new int[N+1];
            Node[] nodes=new Node[N+1];
            for(int i=1;i<=N;i++){
                nodes[i]=new Node();
            }
            for(int[] p:paths){
                nodes[p[0]].adj.add(nodes[p[1]]);
                nodes[p[1]].adj.add(nodes[p[0]]);
            }
            int[] ans=new int[N];
            for(int i=1;i<=N;i++){
                if(nodes[i].flower==0)
                    dfs(nodes[i]);
            }
            for(int i=0;i<N;i++)
                ans[i]=nodes[i+1].flower;
            return ans;
        }
        private void dfs(Node node){
            if(node.flower!=0) return;
            int[] table=new int[5];
            for(Node n:node.adj){
                table[n.flower]++;
            }
            for(int i=1;i<=4;i++){
                if(table[i]==0){
                    node.flower=i;
                    break;
                }
            }
            for(Node n:node.adj){
                dfs(n);
            }
        }
    }
    class Node{
        int flower=0;
        List<Node> adj=new ArrayList<Node>();
    }


}

