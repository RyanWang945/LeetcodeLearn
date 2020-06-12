package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/4/6 21:05
 */
public class _54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix==null||matrix.length==0)  return list;
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        int count=(Math.min(m,n)+1)/2;
        while(i<count){
            for(int j=i;j<n-i;j++){
                list.add(matrix[i][j]);
            }
            for(int j=i+1;j<m-i;j++)
                list.add(matrix[j][(n-1)-i]);
            for(int j=n-1-i-1;j>=i&&(m-1-i!=i);j--)
                list.add(matrix[(m-1)-i][j]);
            for(int j=(m-1)-(i+1);j>=i+1&&(n-1-i)!=i;j--)
                list.add(matrix[j][i]);
            i++;
        }
        return list;
    }
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if(matrix==null||matrix.length==0)
            return ans;
        int m=matrix.length;
        int n=matrix[0].length;
        int total=m*n;
        int r=0,c=0;
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        int di=0;
        boolean[][] seen=new boolean[m][n];
        for(int i=0;i<total;i++){
            ans.add(matrix[r][c]);
            seen[r][c]=true;
            int newr=r+dr[di];
            int newc=c+dc[di];
            if(newr>=0&&newc>=0&&newr<m&&newc<n&&seen[newr][newc]==false){
                r=newr;
                c=newc;
            }else{
                di=(di+1)%4;
                r+=dr[di];
                c+=dc[di];
            }
        }
        return ans;
    }
}
