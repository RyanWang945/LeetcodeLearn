package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/6/4 12:34
 */
public class _743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }
    public int networkDelayTime2(int[][] times, int N, int K) {
        int[][] graph=new int[N+1][N+1];
        for(int[] row:graph){
            Arrays.fill(row,-1);
        }
        for(int[] time:times){
            graph[time[0]][time[1]]=time[2];
        }
        int[] distance=new int[N+1];
        Arrays.fill(distance,-1);
        for(int i=1;i<=N;i++){
            distance[i]=graph[K][i];
        }
        distance[K]=0;
        boolean[] visited=new boolean[N+1];
        visited[K]=true;
        for(int i=1;i<=N-1;i++){
            int minDis=Integer.MAX_VALUE;
            int minIndex=1;
            for(int j=1;j<=N;j++){
                if(!visited[j]&&distance[j]!=-1&&distance[j]<minDis){
                    minDis=distance[j];
                    minIndex=j;
                }
            }
            visited[minIndex]=true;
            for(int j=1;j<=N;j++){
                if(graph[minIndex][j]!=-1){
                    if(distance[j]==-1)
                        distance[j]=distance[minIndex]+graph[minIndex][j];
                    else distance[j]=Math.min(distance[j],distance[minIndex]+graph[minIndex][j]);
                }
            }
        }
        int ans=-1;
        for(int i=1;i<=N;i++){
            if(distance[i]==-1)
                return -1;
            ans=Math.max(ans,distance[i]);
        }
        return ans;
    }
}
