package 刷题.竞赛.POJ;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/30 9:35
 */
public class POJ1852 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cases=sc.nextInt();
        for(int x=0;x<cases;x++) {
            int len = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int min = 0;
            for (int i = 0; i < n; i++) {
                min = Math.max(min, Math.min(arr[i], len - arr[i]));
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, Math.max(arr[i], len - arr[i]));
            }
            System.out.println(min + " " + max);
        }
    }
}
