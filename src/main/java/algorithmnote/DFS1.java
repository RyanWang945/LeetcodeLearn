package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/4 11:31
 */
public class DFS1 {
    int goal_x=9,goal_y=9;
    int[][]used={{1,0,0,0,0,0,0,0,0,0,1},{1,0,1,0,0,0,1,0,0,0,0},{1,0,1,0,0,0,1,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,1,0,0,0,0},{1,0,1,0,0,0,1,0,0,0,0},{1,0,1,0,0,0,1,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,1,0,0,0},{1,0,1,0,0,0,0,0,0,1,0}};
    int[] px={-1,0,1,0};
    int[] py={0,-1,0,1};
    int[][] graph=new int[10][10];
    boolean flag=false;//标记是否到达了终点，0是未到达
    public void DFS(int[][] graph,int[][]used,int x,int y){
        if(graph[x][y]==graph[goal_x][goal_y]){
            System.out.println("success");
            flag=true;
            return;
        }
        for(int i=0;i!=4;i++){
            int new_x=x+px[i],new_y=y+py[i];
            if(new_x>=0&&new_x<10&&new_y>=0&&new_y<10&&used[new_x][new_y]==0&&!flag){
                used[new_x][new_y]=1;
                DFS(graph,used,new_x,new_y);
                used[new_x][new_y]=0;
            }
        }
    }
    @Test
    public void test_DFS(){
        DFS(graph,used,0,2);
    }
}
