package 刷题.竞赛.POJ;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/30 10:03
 * 实例数据
 * 10 12
 * W........WW.
 * .WWW.....WWW
 * ....WW...WW.
 * .........WW.
 * .........W..
 * ..W......W..
 * .W.W.....WW.
 * W.W.W.....W.
 * .W.W......W.
 * ..W.......W.
 */
public class POJ2386 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String[] strs=new String[n];
        for(int i=0;i<n;i++){
            strs[i]=sc.next();
            sc.nextLine();
        }
        char[][] chs=new char[n][m];
        for(int i=0;i<n;i++){
            chs[i]=strs[i].toCharArray();
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(chs[i][j]=='W'){
                    count++;
                    dfs(i,j,chs);
                }
            }
        }
        System.out.println(count);
    }
    static int[][] direction={{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    private static void dfs(int i,int j,char[][] chs){
        chs[i][j]='.';
        for(int k=0;k<direction.length;k++){
            int x=i+direction[k][0];
            int y=j+direction[k][1];
            if(x>=0&&x<chs.length&&y>=0&&y<chs[0].length&&chs[x][y]=='W')
                dfs(x,y,chs);
        }
    }
}
