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
}
