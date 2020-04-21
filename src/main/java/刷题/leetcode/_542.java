package 刷题.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/4/15 11:02
 */
public class _542 {
    public int[][] updateMatrix1(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0)
                    ans[i][j]=0;
                else if(matrix[i][j]==1){
                    ans[i][j]=Integer.MAX_VALUE;
                    //matrix[i][j]=-1;
                    dfs(matrix,ans,i,j,0,i,j);
                    //matrix[i][j]=1;
                }
            }
        }
        return ans;
    }
    private void dfs(int[][]matrix,int[][]ans,int i,int j,int depth,int r,int c){
        if(i<0||j<0||i>=matrix.length||j>=matrix[i].length||matrix[i][j]==-1)
            return;
        if(depth>ans[r][c])
            return;
        if(matrix[i][j]==0){
            ans[r][c]=Math.min(ans[r][c],depth);
            return;
        }
        matrix[i][j]=-1;
        dfs(matrix,ans,i+1,j,depth+1,r,c);
        dfs(matrix,ans,i-1,j,depth+1,r,c);
        dfs(matrix,ans,i,j+1,depth+1,r,c);
        dfs(matrix,ans,i,j-1,depth+1,r,c);
        matrix[i][j]=1;
    }
    public int[][] updateMatrix2(int[][] matrix) {
        if(matrix==null||matrix.length==0) return null;
        int m=matrix.length,n=matrix[0].length;
        int[][] res=new int[m][n];
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    res[i][j]=0;
                    visited[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] direction={{-1,0},{1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] poll=queue.poll();
            int i=poll[0],j=poll[1];
            for(int k=0;k<4;k++){
                int di=i+direction[k][0],dj=j+direction[k][1];
                if(di>=0&&di<m&&dj>=0&&dj<n&&!visited[di][dj]){
                    res[di][dj]=res[i][j]+1;
                    visited[di][dj]=true;
                    queue.offer(new int[]{di,dj});
                }
            }
        }
        return res;
    }
}
