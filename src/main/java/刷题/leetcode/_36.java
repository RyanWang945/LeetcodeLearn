package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/21 17:13
 */
public class _36 {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            int[] map=new int[10];
            for(int j=0;j<board.length;j++){
                if(i%3==0&&j%3==0){
                    int[] map2=new int[10];
                    for(int m=i;m<i+3;m++){
                        for(int n=j;n<j+3;n++){
                            if(board[m][n]=='.') continue;
                            if(map2[board[m][n]-'0']!=0)
                                return false;
                            else map2[board[m][n]-'0']++;
                        }
                    }
                }
                if(board[i][j]=='.') continue;
                if(map[board[i][j]-'0']!=0)
                    return false;
                else map[board[i][j]-'0']++;
            }
            int[] map3=new int[10];
            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.') continue;
                if(map3[board[j][i]-'0']!=0)
                    return false;
                else map3[board[j][i]-'0']++;
            }
        }
        return true;
    }
}
