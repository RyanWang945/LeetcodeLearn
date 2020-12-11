package 刷题.竞赛.洛谷;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/6/30 10:02
 */
public class P1042 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        while(true){
            String c=sc.next();
            for(char ch:c.toCharArray()) {
                if (ch == 'E'){
                    flag=true;
                    break;
                }else {
                    sb.append(ch);
                }
            }
            if(flag==true)
                break;
        }
        //System.out.println(sb.toString());
        char[] chs=sb.toString().toCharArray();
        int W=0,L=0;
        for(int i=0;i<chs.length;i++){
            if(chs[i]=='E')
                break;
            if(chs[i]=='W'){
                W++;
            }else if(chs[i]=='L'){
                L++;
            }
            if((W>=11||L>=11)&&Math.abs(W-L)>=2){
                System.out.println(W+":"+L);
                W=0;
                L=0;
            }

        }
        System.out.println(W+":"+L);
        System.out.println();
        W=0;
        L=0;
        for(int i=0;i<chs.length;i++){
            if(chs[i]=='E')
                break;
            if(chs[i]=='W'){
                W++;
            }else if(chs[i]=='L'){
                L++;
            }
            if((W>=21||L>=21)&&Math.abs(W-L)>=2){
                System.out.println(W+":"+L);
                W=0;
                L=0;
            }

        }
        System.out.println(W+":"+L);
    }
}
