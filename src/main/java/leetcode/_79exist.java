package leetcode;

/**
 * @author Ryan
 * @date 2020/3/24 18:19
 */
public class _79exist {
    boolean flag=false;
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
            return true;
        int[][] hashtable=new int[board.length][board[0].length];
        char[] chs=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==chs[0]){
                    hashtable[i][j]=1;
                    dfs(chs,1,board,i,j,hashtable);
                    hashtable[i][j]=0;
                }
            }
        }
        return flag;
    }
    private void dfs(char[] chs,int index,char[][] board,int i,int j,int[][]hashtable){
        if(index==chs.length){
            flag=true;
            return;
        }
        if(!flag){
            if(i+1<board.length&&board[i+1][j]==chs[index]&&hashtable[i+1][j]==0){
                hashtable[i+1][j]=1;
                dfs(chs,index+1,board,i+1,j,hashtable);
                hashtable[i+1][j]=0;
            }
            if(i-1>=0&&board[i-1][j]==chs[index]&&hashtable[i-1][j]==0){
                hashtable[i-1][j]=1;
                dfs(chs,index+1,board,i-1,j,hashtable);
                hashtable[i-1][j]=0;
            }
            if(j+1<board[i].length&&board[i][j+1]==chs[index]&&hashtable[i][j+1]==0){
                hashtable[i][j+1]=1;
                dfs(chs,index+1,board,i,j+1,hashtable);
                hashtable[i][j+1]=0;
            }
            if(j-1>=0&&board[i][j-1]==chs[index]&&hashtable[i][j-1]==0){
                hashtable[i][j-1]=1;
                dfs(chs,index+1,board,i,j-1,hashtable);
                hashtable[i][j-1]=0;
            }
        }
    }

    /**
     * 前面是我自己写的，不符合标准的写法，有些麻烦
     * @param board
     * @param word
     * @return
     */
    public boolean exist2(char[][] board, String word){
        if(board==null||board.length==0||board[0].length==0)
            return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs2(board,i,j,word,0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs2(char[][]board,int i,int j,String word,int index){
        if(index==word.length())
            return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(index))
            return false;
        board[i][j]='.';
        return dfs2(board,i+1,j,word,index+1)||dfs2(board,i-1,j,word,index+1)||
                dfs2(board,i,j+1,word,index+1)||dfs2(board,i,j-1,word,index+1);
    }
}
