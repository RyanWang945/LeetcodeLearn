package 刷题.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/5/5 23:00
 */
public class _1277 {
    public int countSquares(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        if(matrix[0][0] == 0)
            dp[0][0] = 0;
        else dp[0][0] = 1;
        for(int i = 1; i < n; i++) {
            if(matrix[0][i] == 1)
                dp[0][i] = dp[0][i - 1] + 1;
            else
                dp[0][i] = dp[0][i - 1];
        }
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 1)
                dp[i][0] = dp[i - 1][0] + 1;
            else
                dp[i][0] = dp[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                if(matrix[i][j] == 1)
                    dp[i][j] += bfs(i, j, matrix);
            }
        }
        return dp[m-1][n-1];
    }
    private int bfs(int i, int j, int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int index = 0;
        int n = Math.min(i, j);
        queue.offer(new int[]{i, j});
        while(index <= n) {
            Queue<int[]> temp = new LinkedList<>();
            boolean flag = true;
            while(!queue.isEmpty()) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                if(matrix[x][y] != 1) {
                    flag = false;
                    break;
                }
                if(i - x == j - y) {
                    temp.offer(new int[]{x - 1, y - 1});
                    temp.offer(new int[]{x - 1, y});
                    temp.offer(new int[]{x, y - 1});
                } else if(i - x > j - y) {
                    temp.offer(new int[]{x - 1, y});
                } else if(i - x < j - y) {
                    temp.offer(new int[]{x, y - 1});
                }
            }

            if(flag == false)
                break;
            else index++;
            queue = temp;
        }
        return index;
    }
    public int countSquares2(int[][] matrix) {
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) continue;
                else if(i==0||j==0) ans++;
                else{
                    matrix[i][j]=Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1]))+1;
                    ans+=matrix[i][j];
                }
            }
        }
        return ans;
    }
}
