package 刷题.周赛;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/5/30 23:13
 */
public class Solution0530 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[][] graph=new int[n+1][n+1];
        for(int[] p:prerequisites){
            graph[p[0]][p[1]]=1;
        }
        List<Boolean> res=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            if(set.contains(new String(queries[0]+"-"+queries[1])))
                res.add(true);
            else{
                boolean flag=dfs(n,graph,queries[i][0],queries[i][1]);
                res.add(flag);
            }
        }
        return res;
    }
    Set<String> set=new HashSet<>();
    //i是起点，j是目的地
    private boolean dfs(int n,int[][] graph,int i,int j){
        if(i==j) return true;
        for(int x=0;x<n;x++){
            if(graph[i][x]==1){
                set.add(i+"-"+x);
                boolean flag=dfs(n,graph,x,j);
                if(flag==true) return flag;
            }
        }
        return false;
    }
}
