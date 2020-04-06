package leetcode;

/**
 * @author Ryan
 * @date 2020/4/2 17:19
 */
public class _289 {
    /**
     * 空间复杂度为mn的解法，不是最佳解法
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int n=board.length;//行
        int m=board[0].length;//列
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count=0;
                if(i-1>=0){
                    if(j-1>=0&&board[i-1][j-1]==1)
                        count++;
                    if(j+1<m&&board[i-1][j+1]==1)
                        count++;
                    if(board[i-1][j]==1)
                        count++;
                }
                if(i+1<n){
                    if(j-1>=0&&board[i+1][j-1]==1)
                        count++;
                    if(j+1<m&&board[i+1][j+1]==1)
                        count++;
                    if(board[i+1][j]==1)
                        count++;
                }
                if(j-1>=0&&board[i][j-1]==1)
                    count++;
                if(j+1<m&&board[i][j+1]==1)
                    count++;
                if(board[i][j]==1&&(count<2||count>3))
                    dp[i][j]=0;
                else if((board[i][j]==0&&count==3)||(board[i][j]==1&&(count==2||count==3)))
                    dp[i][j]=1;

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=dp[i][j];
            }
        }
    }
    /**
     * 空间复杂度更低的好解法
     */
    public void gameOfLife2(int[][] board) {
        int[] neighbors={0,1,-1};
        int rows=board.length;
        int cols=board[0].length;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                int liveNeighbors=0;
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(!(neighbors[i]==0&&neighbors[j]==0)){
                            int r=row+neighbors[i];
                            int c=col+neighbors[j];
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
