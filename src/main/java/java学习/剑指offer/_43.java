package java学习.剑指offer;

/**
 * @author Ryan
 * @date 2020/4/12 8:42
 */
public class _43 {
    /**
     * 暴力，超时了
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int num=i;
            while(num>0){
                if(num%10==1){
                    count++;
                }
                num/=10;
            }
        }
        return count;
    }
    /**
     * 3245
     * pow=1000, high=3, last=245
     * 0-999 1000-1999 2000-2999 3000-3245
     * pow + high*f(pow-1) + f(last)
     * 1245
     * 0-999 1000-1245
     * pow=1000,high=1,last=245
     * f(pow-1)+f(last)+last+1
     *
     */
    public int countDigitOne2(int n) {
        return helper(n);
    }
    private int helper(int n){
        if(n<=0)
            return 0;
        String s=String.valueOf(n);
        int pow=(int)Math.pow(10,s.length()-1);
        int high=s.charAt(0)-'0';
        int last=n-pow*high;
        if(high==1){
            return helper(pow-1)+last+1+helper(last);
        }else{
            return helper(pow-1)*high+pow+helper(last);
        }
    }
}
