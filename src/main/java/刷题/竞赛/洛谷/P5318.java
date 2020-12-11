package 刷题.竞赛.洛谷;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/10/10 10:33
 */
public class P5318 {
    static List<Integer> dfsList=new ArrayList<>();
    static List<Integer> bfsList=new ArrayList<>();
    static int[][] g;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();//点数
        int S=sc.nextInt();//边数
        g=new int[N+1][N+1];
        for(int i=0;i<S;i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            g[s][e] = 1;
        }
        boolean[] v=new boolean[N+1];
        v[1]=true;
        dfs(1,v);
        v=new boolean[N+1];
        v[1]=true;
        bfs(1,v);
        for(int i:dfsList){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:bfsList){
            System.out.print(i+" ");
        }
    }
    private static void dfs(int s, boolean[] v){
        dfsList.add(s);
        for(int i=1;i<g.length;i++){
            if(!v[i]&&g[s][i]==1){
                v[i]=true;
                dfs(i,v);
            }
        }
    }
    private static void bfs(int s,boolean[] v){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        v[s]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int a=queue.poll();
                bfsList.add(a);
                for(int j=1;j<g.length;j++){
                    if(g[a][j]==1&&!v[j]&&a!=j){
                        v[j]=true;
                        queue.add(j);
                    }
                }
            }
        }
    }
}