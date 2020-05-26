package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/26 8:55
 */
public class _1025 {
    public boolean divisorGame(int N) {
        if(N==1) return false;
        boolean[] dp=new boolean[N+1];
        dp[1]=false;
        dp[2]=true;
        for(int i=3;i<=N;i++){
            for(int j=1;j<i;j++){
                if(i%j==0&&!dp[i-j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
