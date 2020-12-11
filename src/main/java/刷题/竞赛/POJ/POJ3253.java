package 刷题.竞赛.POJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/30 14:26
 */
public class POJ3253 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            sc.nextLine();
        }
        //Arrays.sort(nums);
        long ans=0;
        while(n>1){
            int a=0,b=1;
            if(nums[a]>nums[b]) swap(a,b,nums);
            for(int i=2;i<n;i++){
                if(nums[i]<nums[a]){
                    b=a;
                    a=i;
                }else if(nums[i]<nums[b]){
                    b=i;
                }
            }
            int t=nums[a]+nums[b];
            ans+=t;
            if(a==n-1) swap(a,b,nums);
            nums[a]=t;
            nums[b]=nums[n-1];
            n--;
        }
        System.out.print(ans);
    }
    private static void swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
