package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/6/2 8:31
 */
public class _1466 {
    public int minReorder(int n, int[][] connections) {
        int res=0;
        Map<Integer, Set<Integer>> conn_idx=new HashMap<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(!conn_idx.containsKey(u)) conn_idx.put(u,new HashSet<>());
            conn_idx.get(u).add(i);
            if(!conn_idx.containsKey(v)) conn_idx.put(v,new HashSet<>());
            conn_idx.get(v).add(i);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int i:conn_idx.get(curr)){
                if(visited[i]) continue;
                visited[i]=true;
                int a=connections[i][0];
                int b=connections[i][1];
                res+=((a==curr)?1:0);
                a=((a==curr)?b:a);
                queue.offer(a);
            }
        }
        return res;
    }
}
