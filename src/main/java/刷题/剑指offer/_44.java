package 刷题.剑指offer;

/**
 * @author Ryan
 * @date 2020/4/12 9:53
 */
public class _44 {
    public int findNthDigit(int n) {
        if(n==0)  return 0;
        int temp=n;
        int i=1;
        for(;;i++){
            double v = Math.pow(10, i) - Math.pow(10, i - 1);
            if(temp-i*v <=0)
                break;
            else temp-=i*v;
        }
        int start=(int)Math.pow(10,i-1);
        for(;temp>=0;){
            temp-=i;
            start++;
        }
        start=start-1;
        String s=String.valueOf(start);
        String s2=String.valueOf(start-1);
        if((temp+i-1)==-1)
            return s2.charAt(i-1)-'0';
        else return s.charAt(temp+i-1)-'0';

    }
}
