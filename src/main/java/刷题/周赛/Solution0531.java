package 刷题.周赛;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ryan
 * @date 2020/5/31 11:45
 */
public class Solution0531 {
    int count=0;
    public int minReorder(int n, int[][] connections) {
        Arrays.sort(connections,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[0]-o2[0];
            }
        });
        for(int[] p:connections){
            if(p[0]==0)
                dfs(p,connections,1);
            else if(p[1]==0)
                dfs(p,connections,0);
        }
        return count;
    }
    //di代表方向，0表明由0位置出发，1表明由1位置
    private void dfs(int[] p,int[][] connections,int di){
        int a=p[0];
        int b=p[1];
        p[0]=-1;
        p[1]=-1;
        if(di==1){
            //System.out.print(a+","+b+" ");
            count++;
        }

        if(di==0){
            for(int[] path:connections){
                if(path[0]==-1||path[1]==-1)
                    continue;
                if(path[0]==a){
                    dfs(path,connections,1);
                }else if(path[1]==a){
                    dfs(path,connections,0);
                }
            }
        }else{
            for(int[] path:connections){
                if(path[0]==-1||path[1]==-1)
                    continue;
                if(path[0]==b){
                    dfs(path,connections,1);
                }else if(path[1]==b){
                    dfs(path,connections,0);
                }
            }
        }

    }
}
