package 刷题.竞赛.例题;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/30 10:51
 */
public class P39 {
    static int[] v=new int[]{1,5,10,50,100,500};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[]{3,2,1,3,0,2};
        for(int i=0;i<6;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        int ans=0;
        for(int i=5;i>=0;i--){
            int t=Math.min(target/v[i],arr[i]);
            target-=t*v[i];
            ans+=t;
        }
        System.out.println(ans);
    }
}
