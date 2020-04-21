package 刷题.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/4/15 15:48
 */
public class _1162 {
    public int maxDistance(int[][] grid) {
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        Queue<int[]> queue=new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    queue.offer(new int[]{i,j});
            }
        }
        int[] point=null;
        boolean hasOcean=false;
        while(!queue.isEmpty()){
            point=queue.poll();
            int x = point[0], y = point[1];
            for(int i=0;i<4;i++){
                int newX=x+dx[i];
                int newY=y+dy[i];
                if(newX<0||newY<0||newX>=m||newY>=n||grid[newX][newY]!=0)
                    continue;
                grid[newX][newY]=grid[x][y]+1;
                hasOcean=true;
                queue.offer(new int[]{newX,newY});
            }
        }
        if(!hasOcean||point==null)
            return -1;
        return grid[point[0]][point[1]]-1;
    }

    /**
     * 熟练掌握多源bfs后，我写出了比sweet姐姐更好的代码，不需要额外数组指示是否访问过。
     * @param grid
     * @return
     */
    public int maxDistance2(int[][] grid) {
        if(grid==null||grid.length==0) return -1;
        Queue<int[]> queue=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    queue.add(new int[]{i,j});
            }
        }
        int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            int i=now[0],j=now[1];
            for(int k=0;k<4;k++){
                int di=i+direction[k][0],dj=j+direction[k][1];
                if(di>=0&&dj>=0&&di<m&&dj<n&&grid[di][dj]==0){
                    grid[di][dj]=grid[i][j]+1;
                    queue.add(new int[]{di,dj});
                }
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=Math.max(res,grid[i][j]);
            }
        }
        if(res==1) return -1;
        return res-1;
    }
}
