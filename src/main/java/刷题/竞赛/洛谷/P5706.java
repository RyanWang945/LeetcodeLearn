package 刷题.竞赛.洛谷;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/6/30 9:47
 */
public class P5706 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double v = sc.nextDouble();
        int n = sc.nextInt();
        double ans=v/n;
        System.out.println(String.format("%.2f",ans));
        System.out.println(2*n);
    }
}
