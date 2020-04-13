package 刷题.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**1302 2031
 * @author Ryan
 * @date 2020/3/24 21:23
 */
public class _51 {
    List<List<String>>res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][]board=new int[n][n];
        dfs(n,0,board);
        return res;
    }
    private void dfs(int n,int row,int[][]board){
        if(row==n){
            res.add(track(board,n));
            return;
        }
        for(int col=0;col<n;col++){
            if(isUsable(board,row,col)){
                board[row][col]=1;
                dfs(n,row+1,board);
                board[row][col]=0;
            }
        }
    }
    private boolean isUsable(int[][]board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]==1) return false;
        }
        for(int i=col-1;i>=0;i--){
            if(i+row-col<0) break;
            if(board[i+row-col][i]==1) return false;
        }
        for(int i=col+1;i<board.length;i++){
            if(col+row-i<0) break;
            if(board[row+col-i][i]==1) return false;
        }
        return true;
    }
    private List<String> track(int[][]board,int n){
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder temp=new StringBuilder();
            for(int j=0;j<n;j++){
                if(board[i][j]==0)temp.append('.');
                else temp.append('Q');
            }
            list.add(temp.toString());
        }
        return list;
    }

    @Test
    public void test(){
        List<List<String>> lists = solveNQueens(4);
        for(List<String> list:lists){
            for(String s:list){
                System.out.println(s);
            }
        }
    }

}
