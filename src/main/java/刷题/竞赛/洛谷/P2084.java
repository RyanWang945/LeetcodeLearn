package 刷题.竞赛.洛谷;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/6/30 7:50
 */
public class P2084 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        String N=sc.next();
        StringBuilder sb=new StringBuilder();
        char[] chs=N.toCharArray();
        for(int i=0;i<chs.length;i++){
            int a=chs[i]-'0';
            if(a!=0)
                sb.append(a+"*"+M+"^"+(chs.length-1-i)+"+");
        }
        System.out.println(sb.substring(0,sb.length()-1).toString());
    }
}
