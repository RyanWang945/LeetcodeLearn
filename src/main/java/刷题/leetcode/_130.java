package 刷题.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public void solve2(char[][] board) {
        if(board==null||board.length==0) return;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&&(i==m-1||j==n-1||i==0||j==0)){
                    dfs2(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    board[i][j]='O';
                }else
                    board[i][j]='X';
            }
        }
    }
    private void dfs2(char[][]board,int i,int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return;
        }
        if(board[i][j]=='O')
            board[i][j]='.';
        else if(board[i][j]=='X'||board[i][j]=='.')
            return;
        dfs2(board,i+1,j);
        dfs2(board,i-1,j);
        dfs2(board,i,j+1);
        dfs2(board,i,j-1);
    }
    public void solve3(char[][] board) {
        if(board==null||board.length==0)
            return;
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i>0&&i<m-1)&&j>0&&j<n-1)
                    continue;
                if(board[i][j]=='O'){
                    queue.add(new int[]{i,j});
                    board[i][j]='.';
                }
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];
                if(r>0&&board[r-1][c]=='O'){
                    board[r-1][c]='.';
                    queue.add(new int[]{r-1,c});
                }
                if(r+1<m&&board[r+1][c]=='O'){
                    board[r+1][c]='.';
                    queue.add(new int[]{r+1,c});
                }
                if(c>0&&board[r][c-1]=='O'){
                    board[r][c-1]='.';
                    queue.add(new int[]{r,c-1});
                }
                if(c+1<n&&board[r][c+1]=='O'){
                    board[r][c+1]='.';
                    queue.add(new int[]{r,c+1});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=board[i][j]=='.'?'O':'X';
            }
        }
    }
}
