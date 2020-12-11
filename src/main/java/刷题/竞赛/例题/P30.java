package 刷题.竞赛.例题;

import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/30 9:52
 *
 * 示例数据
 * 4
 * 1 2 4 7
 * 15
 *
 *
 * 4
 * 1 2 4 7
 * 13
 */
public class P30 {
    static boolean flag=false;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        boolean[] hashtable=new boolean[n];
        dfs(arr,target,0,hashtable,0);
        System.out.println(flag);
    }
    private static void dfs(int[] arr,int target,int index,boolean[] hashtable,int sum){
        if(flag==true) return;
        if(sum==target){
            flag=true;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(hashtable[i]==false){
                hashtable[i]=true;
                dfs(arr,target,i+1,hashtable,sum+arr[i]);
                hashtable[i]=false;
            }
        }
    }
}
