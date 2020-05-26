package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/26 9:29
 */
public class _1027 {
    public int longestArithSeqLength(int[] A) {
        if(A==null||A.length<3)
            return 0;
        int[][] dp=new int[A.length][20001];
        int max=0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<i;j++){
                int distance=A[i]-A[j]+10000;
                if(dp[j][distance]>0)
                    dp[i][distance]= Math.max(dp[i][distance], dp[j][distance] + 1);
                else
                    dp[i][distance]=2;
                max=Math.max(max,dp[i][distance]);
            }
        }
        return max;
    }
}
