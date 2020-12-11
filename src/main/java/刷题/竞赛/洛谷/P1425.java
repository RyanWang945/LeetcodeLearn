package 刷题.竞赛.洛谷;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/6/30 9:53
 */
public class P1425 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        if(b<d){
            System.out.println((c-a)+" "+(d-b));
        }else{
            System.out.println((c-1-a)+" "+(d-b+60));
        }
    }
}
