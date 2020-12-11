package 刷题.牛客;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/8/4 10:53
 */
public class _08_04_03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        String[] strs1=a.split(" ");
        String[] strs2=b.split(" ");
        StringBuilder sb=new StringBuilder();
        int index=0;
        int i=0;
        for(;i<strs1.length;i++){
            if(i==0){
                sb.append(strs1[0]);
                continue;
            }
            if(((i+1)%5)==0){
                if(index<strs2.length)
                    sb.append(" "+strs2[index++]);
            }else{
                sb.append(" "+strs1[i]);
            }
        }
        while(i<strs1.length){
            sb.append(" "+strs1[i++]);
        }
        while(index<strs2.length)
            sb.append(" "+strs2[index++]);
        System.out.println(sb.toString());
    }
}
