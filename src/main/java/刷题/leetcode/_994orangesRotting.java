package 刷题.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/4 16:00
 * 0,空单元格
 * 1,新鲜
 * 2,腐烂
 */
public class _994orangesRotting {
    public int orangesRotting(int[][] grid) {
        int R=grid.length;
        int C=grid[0].length;
        int minute=0;
        Queue<Pos> queue=new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j=0;i<C;j++){
                if(grid[i][j]==2)
                    //把初试的烂橘子放上
                    queue.add(new Pos(i,j,minute));
            }
        }
        while(!queue.isEmpty()){
            Pos pos=queue.poll();
            minute=pos.minute;
            for(int k=0;k<4;k++){
                int newX=pos.x+dir[k][0];
                int newY=pos.y+dir[k][1];
                if(newX>=0&&newX<R&&newY>=0&&newY<C&&grid[newX][newY]==1){
                    grid[newX][newY]=2;
                    queue.add(new Pos(newX,newY,pos.minute+1));
                }
            }
        }
        for(int[] row:grid){
            for(int i:row){
                if(i==1) return -1;
            }
        }
        return minute;
    }
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

    class Pos{
        int x,y,minute;
        public Pos(int _x,int _y,int _minute){
            x=_x;
            y=_y;
            minute=_minute;
        }
    }
}

