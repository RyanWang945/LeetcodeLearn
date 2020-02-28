package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/1/4 10:18
 */
public class _1_4FindSqurt2 {
    double squart(double n){
        return n*n;
    }
    double getSquart(double target){
        double left=0;
        double right=target;
        double mid;
        while(right-left>0.00001){
            mid=(right+left)/2;
            if(squart(mid)>target){
                right=mid;
            }
            else{
                left=mid;
            }
        }
        return left;
    }
    @Test
    public void test_findsquart2(){
        int a=2;
        System.out.println(getSquart(a));
    }
}
