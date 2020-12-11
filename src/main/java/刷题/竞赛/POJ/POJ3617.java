package 刷题.竞赛.POJ;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/30 11:11
 */
public class POJ3617 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[] chs=new char[n];
        for(int i=0;i<n;i++){
            chs[i]=sc.next().toCharArray()[0];
        }
        int a=0,b=chs.length-1;
        StringBuilder ans=new StringBuilder();
        while (a <= b) {
            boolean left=false;
            for(int i=0;a+i<=b;i++){
                if(chs[a+i]<chs[b-i]){
                    left=true;
                    break;
                }else if(chs[a+i]>chs[b-i]){
                    left=false;
                    break;
                }
            }
            if(left)
                ans.append(chs[a++]);
            else
                ans.append(chs[b--]);
        }
        String ss=ans.toString();
        int count=0;
        for(int i=0;i<ss.length();i++){
            if(count<79){
                System.out.print(ss.charAt(i));
                count++;
            }
            else {
                System.out.println(ss.charAt(i));
                count=0;
            }
        }

    }
}
