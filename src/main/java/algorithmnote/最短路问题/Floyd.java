package algorithmnote.最短路问题;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/6/4 21:33
 */
public class Floyd {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph=new int[N+1][N+1];
        for(int[] row:graph)
            Arrays.fill(row,-1);
        for(int[] time:times)
            graph[time[0]][time[1]]=time[2];

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j) graph[i][j]=0;
                    if(graph[i][j]==-1){
                        if(graph[i][k]!=-1&&graph[k][j]!=-1)
                            graph[i][j]=graph[i][k]+graph[k][j];
                    }else{
                        if(graph[i][k]!=-1&&graph[k][j]!=-1&&graph[i][k]+graph[k][j]<graph[i][j])
                            graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        // for(int i=1;i<=N;i++){
        //     for(int j=1;j<=N;j++){
        //         System.out.print(graph[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int ans=-1;
        for(int i=1;i<=N;i++){
            if(graph[K][i]==-1)
                return -1;
            ans=Math.max(graph[K][i],ans);
        }
        return ans;
    }
}
