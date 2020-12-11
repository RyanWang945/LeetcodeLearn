package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/23 21:41
 */
public class _313 {
    public static void main(String[] args) {
        int[] primes=new int[]{2,7,13,19};
        int i = nthSuperUglyNumber(12, primes);
        System.out.println(i);
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp=new int[n];
        dp[0]=1;
        int[] ptr=new int[primes.length];
        for(int i=1;i<n;i++){
            int temp=dp[ptr[0]]*primes[0];
            int tempptr=0;
            for(int j=1;j<primes.length;j++){
                if(dp[ptr[j]]*primes[j]<temp){
                    temp=dp[ptr[j]]*primes[j];
                    tempptr=j;
                }
            }
            ptr[tempptr]++;
            dp[i]=temp;
        }
        for(int i:dp)
            System.out.print(i+" ");
        return dp[n-1];
    }
}
