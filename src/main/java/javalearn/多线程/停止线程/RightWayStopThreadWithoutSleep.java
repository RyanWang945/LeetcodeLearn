package javalearn.多线程.停止线程;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author Ryan
 * @date 2020/11/23 19:13
 * run方法内没有sleep或者wait时停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new RightWayStopThreadWithoutSleep());
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }

    @Override
    public void run() {
        int num=0;
        while(!Thread.currentThread().isInterrupted()&&num<=Integer.MAX_VALUE/2){
            if((num%10000)==0){
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
        System.out.println("结束");
    }
}
