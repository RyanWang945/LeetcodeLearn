package javalearn.多线程;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * @author Ryan
 * @date 2020/9/30 14:18
 */
public class FatherSunTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(2);
        t.start();
    }
}
