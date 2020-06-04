package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/4 9:21
 */
public class _785 {
    public boolean isBipartite(int[][] graph) {
        if(graph==null||graph.length==0)
            return false;
        int v=graph.length;
        int[]colors=new int[v];
        for(int i=0;i<v;i++){
            if(!dfs(graph,i,colors,0)) return false;
        }
        return true;
    }
    private boolean dfs(int[][] graph,int i,int[] colors,int lastColor){
        if(colors[i]!=0) return colors[i]!=lastColor;
        colors[i]=lastColor==1?2:1;
        for(int j=0;j<graph[i].length;j++){
            if(!dfs(graph,graph[i][j],colors,colors[i]))
                return false;
        }
        return true;
    }
}
