package algorithmnote.欧拉路径模板;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/6/1 15:25
 */
public class SolutionOla {
    /**
     * Hierholzer算法
     * edge是邻接矩阵，其中edge[i][j]==1代表i到j有一条路径（如果是有向图代表i到j，如果是无向图也是
     * i到j，但edge[j][i]也会等于1，代表i和j双向可通）
     * n代表有多少个节点
     * 这里我用有向图作为例子，无向图的需要删除一部分东西
     */
    static Stack<Integer> stack=new Stack<>();
    public static List<Integer> Solution(int[][] edge, int n){
        List<Integer> ans=new ArrayList<>();
        int[] inDegree=new int[n+1];
        int[] outDegree=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(edge[i][j]==1){
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }
        for(int i=1;i<=n;i++){
            System.out.print(inDegree[i]+" ");
        }
        System.out.println();
        for(int i=1;i<=n;i++){
            System.out.print(outDegree[i]+" ");
        }
        System.out.println();
        int count=0;
        int start=1;
        //int end=0;
        for(int i=1;i<=n;i++){
            if(inDegree[i]!=outDegree[i]) {
                count++;
                if(count>2) return ans;
                if((inDegree[i]+1)==outDegree[i]){
                    start=i;
                    System.out.println(start);
                }
            }
        }
        if(count==1) return ans;
        dfs(start,edge,n);
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
    private static void dfs(int start,int[][] edge,int n){
        for(int i=1;i<=n;i++) {
            if (edge[start][i] == 1) {
                edge[start][i]--;
                dfs(i, edge, n);
            }
        }
        stack.push(start);
    }
    /**
     * 测试
     */
    public static void main(String[] args) {
        int[][] testCase=new int[][]{{0,0,0,0,0,0},{0,0,0,0,0,1},{0,0,0,1,0,0},
                {0,0,0,0,0,0},{0,0,1,0,0,0},{0,0,0,0,1,0}};
        List<Integer> solution = Solution(testCase, 5);
        for(int i:solution)
            System.out.print(i+" ");
    }
}
