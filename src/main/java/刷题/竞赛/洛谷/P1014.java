package 刷题.竞赛.洛谷;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/6/30 6:55
 */
public class P1014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=(int)Math.ceil((-1+Math.sqrt(1+8*n))/2);
        int pre=(1+i-1)*(i-1)/2;
        int index=n-pre;
        if ((i % 2) == 0) {
            System.out.println(index + "/" + (i + 1 - index));
        } else {
            System.out.println((i+1-index)+ "/" +index);
        }
    }
}
