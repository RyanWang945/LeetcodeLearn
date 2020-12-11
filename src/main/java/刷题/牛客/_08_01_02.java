package 刷题.牛客;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/8/1 22:32
 */
public class _08_01_02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(judge(s.substring(i,j))){
                    //System.out.print(i+","+j+"__");
                    count++;
                }

            }
        }
        System.out.println(count);
    }
    private static boolean judge(String s){
        if((s.length()%2)==0){
            int right=s.length()/2,left=right-1;
            while(left>=0&&right<s.length()){
                if(s.charAt(left)!=s.charAt(right))
                    return false;
                left--;
                right++;
            }
        }else{
            int left=s.length()/2,right=s.length()/2;
            while(left>=0&&right<s.length()){
                if(s.charAt(left)!=s.charAt(right))
                    return false;
                left--;
                right++;
            }
        }
        return true;
    }
}
