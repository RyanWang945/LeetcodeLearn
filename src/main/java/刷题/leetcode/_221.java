package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/8 8:20
 */
public class _221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int max=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0') continue;
                else if(i==0||j==0) {
                    max=Math.max(max,1);
                    dp[i][j]=1;
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    }
}
