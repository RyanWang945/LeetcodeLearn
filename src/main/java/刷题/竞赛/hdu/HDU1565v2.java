package 刷题.竞赛.hdu;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/29 23:01
 */
public class HDU1565v2 {
    static int[][] matrix;
    public static void main(String[] args) {
        int n=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        matrix=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                matrix[i][j]=sc.nextInt();
            }
            sc.nextLine();
        }
        int cnt=0;
        int[] tot=new int[1<<n];
        for(int i=0;i<(1<<n);i++){
            if((i&i>>1)==0)
                tot[cnt++]=i;
        }
        int[][] dp=new int[n+1][cnt];
        for(int i=1;i<=n;i++){
            for(int k=0;k<cnt;k++){
                int val=cal(i,tot[k]);
                for(int j=0;j<cnt;j++){
                    if((tot[k]&tot[j])==0){
                        dp[i][k]=Math.max(dp[i][k],dp[i-1][j]+val);
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<cnt;i++){
            ans=Math.max(ans,dp[n][i]);
        }
        System.out.print(ans);

    }
    private static int cal(int i,int x){
        int cnt=1,res=0;
        while(x!=0){
            if((x&1)==1) res+=matrix[i][cnt];
            x/=2;cnt++;
        }
        return res;
    }
}
