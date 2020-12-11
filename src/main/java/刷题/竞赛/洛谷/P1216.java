package 刷题.竞赛.洛谷;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/5 23:04
 */
public class P1216 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int[][] nums=new int[r][r];
        for(int i=0;i<r;i++){
            for(int j=0;j<=i;j++){
                int num=sc.nextInt();
                nums[i][j]=num;
            }
            //sc.nextLine();
        }
        int[][] dp=new int[r][r];
        for(int i=0;i<r;i++){
            dp[r-1][i]=nums[r-1][i];
        }
        for(int i=r-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.max(dp[i+1][j],dp[i+1][j+1])+nums[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }
}
