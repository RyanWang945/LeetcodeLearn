package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/1 16:16
 */
public class _1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                sum+=customers[i];
            }
        }
        int left=0,right=0,max=0,ans=0;
        while(right<customers.length){
            int a=customers[right++];
            if(grumpy[right-1]==1){
                max+=a;
            }
            if(right-left==X){
                ans=Math.max(max,ans);
                int b=customers[left++];
                if(grumpy[left-1]==1){
                    max-=b;
                }
            }
        }
        return ans+sum;
    }
}
