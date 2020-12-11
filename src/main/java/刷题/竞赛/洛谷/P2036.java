package 刷题.竞赛.洛谷;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/6/30 7:17
 */
public class P2036 {
    static int[] S;
    static int[] B;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        S=new int[n];
        B=new int[n];
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            sc.nextLine();
            S[i]=a;
            B[i]=b;
        }
        int ans=Integer.MAX_VALUE;
        //int s=1,b=0;
        for(int i=1;i<Math.pow(2,n);i++){
            int s=1,b=0;
            int temp=i;
            int x=0;
            while(temp!=0){
                if((temp%2)==1){
                    s=s*S[x];
                    b=b+B[x];
                }
                x++;
                temp/=2;
            }
            ans=Math.min(ans,Math.abs(s-b));
        }
        System.out.println(ans);
    }
    public void ans2(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] S=new int[n];
        int[] B=new int[n];
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            sc.nextLine();
            S[i]=a;
            B[i]=b;
        }
        dfs(0,1,0,n);
    }
    int ans=Integer.MAX_VALUE;
    private void dfs(int i,int x,int y,int n){
        if(i==n){
            if(x==1&&y==0) return;
            ans=Math.min(Math.abs(x-y),ans);
            return;
        }
        dfs(i+1,x*S[i],y+B[i],n);
        dfs(i+1,x,y,n);
    }
}
