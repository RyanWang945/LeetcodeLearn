package 刷题.竞赛.hdu;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/9/21 16:08
 */
public class HDU1556 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] diff = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                diff[a] += 1;
                diff[b + 1] -= 1;
            }
            for (int i = 1; i <= n; i++) {
                diff[i] += diff[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                if(i!=n)
                    System.out.print(diff[i]+" ");
                else
                    System.out.println(diff[i]);
            }

        }
    }
}
