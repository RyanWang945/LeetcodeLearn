package 刷题.竞赛.POJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/30 14:05
 */
public class POJ3069 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int r=sc.nextInt();
        int n=sc.nextInt();
        while(r!=-1&&n!=-1){
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int i=0;
            int ans=0;
            while(i<n){
                int s=arr[i++];
                while(i<n&&arr[i]<=s+r) i++;
                int p=arr[i-1];
                while(i<n&&arr[i]<=p+r) i++;
                ans++;
            }
            System.out.println(ans);
            sc.nextLine();
            r=sc.nextInt();
            n=sc.nextInt();
        }
    }
}
