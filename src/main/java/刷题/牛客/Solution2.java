package 刷题.牛客;

import java.util.*;
public class Solution2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n];
        int[] preSum = new int[n];
        for(int i = 0; i < n; i++){
            money[i] = sc.nextInt();
            if(i == 0) preSum[i] = money[i];
            else preSum[i] = preSum[i-1] + money[i];
        }
        sc.close();

        int[][] dp = new int[n][n];
        for(int len = 2; len <= n; len++){
            for(int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = 0;
                if(i-1==-1)
                    sum=preSum[j]-0;
                else sum=preSum[j] - preSum[i - 1];
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }

    /**
     * 这个是向后移一位的写法，这种写法似乎更为简便
     * @param args
     */
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n+1];
        int[] preSum = new int[n+1];
        for(int i = 1; i <= n; i++){
            money[i] = sc.nextInt();
            if(i == 1) preSum[i] = money[i];
            else preSum[i] = preSum[i-1] + money[i];
        }
        sc.close();

        int[][] dp = new int[n + 1][n + 1];
        for(int len = 2; len <= n; len++){
            for(int i = 1; i <= n - len + 1; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = preSum[j] - preSum[i - 1];
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
