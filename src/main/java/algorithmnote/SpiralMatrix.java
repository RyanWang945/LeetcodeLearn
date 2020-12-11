package algorithmnote;

/**
 * @author Ryan
 * @date 2020/12/4 9:52
 */
public class SpiralMatrix {
    static int n;
    public static void main(String[] args) {
        n=5;
        int[][] ans=solution(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] ans;
    public static int[][] solution(int n){
        ans=new int[n][n];
        dfs(0,0,0,1,new boolean[n][n]);
        return ans;
    }
    static int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public static void dfs(int i,int j,int d,int count,boolean[][] visited){
        ans[i][j]=count++;
        visited[i][j]=true;
        int c=0;
        while(true){
            int newI=i+dirs[d][0];
            int newJ=j+dirs[d][1];
            if(newI>=0&&newJ>=0&&newI<n&&newJ<n&&!visited[newI][newJ]){
                dfs(newI,newJ,d,count,visited);
            }else{
                c++;
                d=(d+1)%4;
            }
            if(c==4) break;
        }
    }
}
