package 刷题.牛客;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/8/4 10:22
 */
public class _08_04_02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        List<Boolean> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            boolean flag=false;
            String a=sc.next();
            String b=sc.next();
            //System.out.println(a.length()+" "+b.length());
            List<Integer> aList=new ArrayList<>();
            List<Integer> bList=new ArrayList<>();
            transfer(aList,a);
            transfer(bList,b);
            for(int j=0;j<bList.size();j++){
                int x=0,y=0;
                if(aList.size()-1<j){
                    x=0;
                }else{
                    x=aList.get(j);
                }
                y=bList.get(j);
                if(y>x){
                    flag=true;
                    ans.add(true);
                    break;
                } else if(y<x){
                    flag=true;
                    ans.add(false);
                    break;
                }
            }
            if(flag==false){
                ans.add(flag);
            }
        }
        //System.out.println(ans.size());
        for(boolean i:ans){
            System.out.println(i);
        }
    }
    private static void transfer(List<Integer> list,String a){
        String[] strs=a.split("\\.");
        //System.out.println(strs.length);
        for(int i=0;i<strs.length;i++){
            //System.out.print(strs[i]+" ");
            list.add(Integer.valueOf(strs[i]));
        }
    }
}
