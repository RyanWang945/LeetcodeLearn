package algorithmnote.最短路问题;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/6/4 15:54
 */
public class Dijkstra {

    public int networkDelayTime(int[][] times, int N, int K) {
        //初始化邻接矩阵
        int[][]graph=new int[N+1][N+1];
        for(int[] row:graph){
            Arrays.fill(row,-1);
        }
        //遍历times填充邻接矩阵
        for(int[] time:times){
            graph[time[0]][time[1]]=time[2];
        }
        //存放K到各点的最短路径，最大那个即为结果
        int[] distance=new int[N+1];
        Arrays.fill(distance,-1);
        //初始化distance为K到各点的距离
        for(int i=1;i<=N;i++){
            distance[i]=graph[K][i];
        }
        //K到自己的距离为0
        distance[K]=0;
        //判断是否找到K点到N个节点的最短路径
        boolean[] visited=new boolean[N+1];
        visited[K]=true;
        //遍历除K以外的N-1个节点
        for(int i=1;i<=N-1;i++) {
            int minDis=Integer.MAX_VALUE;
            int minIndex=1;
            //遍历所有节点，找到离K最近的节点
            for(int j=1;j<=N;j++){
                if(!visited[j]&&distance[j]!=-1&&distance[j]<minDis){
                    minDis=distance[j];
                    minIndex=j;
                }
            }
            //标记最近距离被找到
            visited[minIndex]=true;
            //通过刚刚找到的这个节点更新K与其他节点的距离
            for(int j=1;j<=N;j++){
                if(graph[minIndex][j]!=-1){
                    if(distance[j]==-1){
                        distance[j]=distance[minIndex]+graph[minIndex][j];
                    }
                    else {
                        distance[j]=Math.min(distance[j],distance[minIndex]+graph[minIndex][j]);
                    }
                }
            }
        }
        //答案为到各点最短路径的最大值，应该最大的已经到了,其余都能到
        int ans=-1;
        for(int i=1;i<=N;i++){
            if(distance[i]==-1){
                return -1; //表示不可达
            }
            ans=Math.max(ans,distance[i]);
        }
        return ans;
    }
}
