package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/25 12:43
 */
public class _1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [][] dp =new int [n + 1][m + 1];//dp[i][j] 代表nums1[0----i]和nums2[0----j]的最大点积,有四种状态，找出最大点积即可,见下面分析
        for(int i = 0 ;i < n + 1 ;i++){
            for(int j = 0 ;j < m + 1 ;j++){
                dp[i][j] = -100001;
            }
        }
        for(int i = 1 ;i <= n ;i++)
            for(int j = 1 ; j <= m ;j++){
                dp[i][j] = nums1[i - 1] * nums2[j - 1];//只选当前两个位置的点积，从下标0开始
                dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1] + dp[i][j]);//选择当前两个位置+选择之前的最大点积
                dp[i][j] = Math.max(dp[i][j],dp[i - 1][j]);//只选nums2[j]
                dp[i][j] = Math.max(dp[i][j],dp[i][j - 1]);//只选nums1[i]
                //dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1]);//两个都不选
            }//最后得出的dp[i][j]就是考虑了上述四种状态后得出的当前位置的最大点积

        return dp[n][m];
    }
}
