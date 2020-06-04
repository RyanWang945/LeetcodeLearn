package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/3 9:00
 */
public class _837 {
    //dp[i]表示当前点数为i时再抽取达到终止条件时小于21点的概率
    //f(x)=1/w *(f(x+1)+f(x+2)+...+f(x+w))
    //f(x-1)=1/w *(f(x)+f(x+1)+...+f(x+w-1))
    public double new21Game(int N, int K, int W) {
        if(K==0) return 1.0;
        double[] dp=new double[K+W+1];
        for(int i=K;i<=N&&i<K+W;i++){
            dp[i]=1.0;
        }
        dp[K-1]=1.0*Math.min(N-K+1,W)/W;
        for(int i=K-2;i>=0;i--)
            dp[i]=dp[i+1]-(dp[i+W+1]-dp[i+1])/W;
        return dp[0];
    }

    /**
     * 超时
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game2(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j] / W;
            }
        }
        return dp[0];
    }
}
