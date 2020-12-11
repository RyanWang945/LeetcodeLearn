package algorithmnote.动态规划;

/**
 * @author Ryan
 * @date 2020/11/6 15:57
 */
public class 划分数 {
    //
    public static void main(String[] args) {
        int n=4;
        int m=3;//n个相同物品，分成m份
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j>=i){
                    dp[i][j]=dp[i][j-i]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
