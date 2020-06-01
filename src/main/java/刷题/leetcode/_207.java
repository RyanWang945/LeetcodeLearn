package 刷题.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/6/1 8:37
 */
public class _207 {
    /**
     *入度表加bfs是解决DAG（有向无环图）最标准的解法
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int pre=queue.poll();
            numCourses--;
            for(int cur:adj.get(pre))
                if(--indegrees[cur]==0) queue.add(cur);
        }
        return numCourses==0;
    }

    /**
     *图问题dfs同样是可以用的，这个的效率和bfs是相同的
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] flags=new int[numCourses];
        for(int[] cp:prerequisites){
            adj.get(cp[1]).add(cp[0]);
        }
        for(int i=0;i<numCourses;i++)
            if(!dfs(adj,flags,i))
                return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> adj,int[] flags,int i){
        if(flags[i]==1) return false;
        if(flags[i]==-1) return true;
        flags[i]=1;
        for(int j:adj.get(i))
            if(!dfs(adj,flags,j))
                return false;
        flags[i]=-1;
        return true;
    }
}
