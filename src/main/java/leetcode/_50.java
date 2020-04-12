package leetcode;

/**
 * @author Ryan
 * @date 2020/4/7 9:52
 */
public class _50 {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        return helper(x,N);
    }
    private double helper(double x,long n){
        if(n==0) return 1.0;
        double half=helper(x,n/2);
        if(n%2==0)
            return half*half;
        else return half*half*x;
    }
}
