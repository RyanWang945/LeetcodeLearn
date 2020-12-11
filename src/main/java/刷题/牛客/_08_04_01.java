package 刷题.牛客;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/8/4 9:52
 */
public class _08_04_01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Boolean> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            int a=sc.nextInt();
            while(true){
                int sum=0;
                while(a!=0){
                    int yushu=a%10;
                    sum+=yushu*yushu;
                    a/=10;
                }
                if(set.contains(sum)){
                    System.out.println(sum);
                    list.add(false);
                    break;
                }
                set.add(sum);
                a=sum;
                if(sum==1){
                    list.add(true);
                    break;
                }
            }
        }
        for(boolean s:list){
            System.out.println(s);
        }

    }
}
