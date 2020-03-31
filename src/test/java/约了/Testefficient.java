package 约了;

import java.util.Timer;

/**
 * @author Ryan
 * @date 2020/3/26 20:59
 */
public class Testefficient {
    public static void main(String[] args) {
        long start_time=System.nanoTime();
        int a=1;
        for(int i=0;i<30;i++){
            a=a*2;
        }
        long end_time=System.nanoTime();
        System.out.println((end_time-start_time)*10000);
        long start_time2=System.nanoTime();
        int b=1;
        for(int i=0;i<30;i++){
            b=b<<1;
        }
        long end_time2=System.nanoTime();
        System.out.println((end_time2-start_time2)*10000);
    }
}
