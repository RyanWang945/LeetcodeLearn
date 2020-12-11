package 刷题.牛客;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/8/1 17:36
 */
public class _08_01_01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        int x=Integer.valueOf(a.substring(1,a.length()-1));
        int y=Integer.valueOf(b.substring(1,b.length()-1));
        int ans=x+y;
        System.out.println("\""+ans+"\"");
    }
}
