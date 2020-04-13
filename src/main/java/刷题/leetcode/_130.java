package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/25 14:07
 */
public class _130 {
    public static void main(String[] args) {
        char[][]chs=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','X','X'},{'X','O','X','X'}};
        _130 a=new _130();
        a.solve(chs);
        for(char[] cs:chs){
            for(char c:cs)
                System.out.print(c);
            System.out.println();
        }
    }
    boolean flag=false;
    public void solve(char[][] board) {
        if(board.length==0)
            return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O'){
                    List<Integer[]> temp=new ArrayList<>();
                    //false代表没有碰到边界墙壁，如果是true代表碰到了，就不能修改所有元素了
                    dfs(board,i,j,temp);
                    if(flag==true)
                        for(Integer[] pos:temp){
                            board[pos[0]][pos[1]]='O';
                        }
                    flag=false;
                }
            }
        }
    }
    private void dfs(char[][]board,int i,int j,List<Integer[]> temp){
        if(i<0||j<0||i>=board.length||j>=board[i].length){
            flag=true;
            return;
        }
        // if(flag==true)
        //     return;
        if(board[i][j]=='X') return;
        temp.add(new Integer[]{i,j});
        board[i][j]='X';
        dfs(board,i+1,j,temp);
        dfs(board,i-1,j,temp);
        dfs(board,i,j+1,temp);
        dfs(board,i,j-1,temp);
    }
}
