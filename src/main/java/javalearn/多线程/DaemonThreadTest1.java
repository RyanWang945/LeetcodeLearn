package javalearn.多线程;

import java.util.concurrent.TimeUnit;

/**
 * @author Ryan
 * @date 2020/9/30 19:39
 * 测试守护线程和守护线程的特点
 *
 */
public class DaemonThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        t.setDaemon(true);
        t.start();
        //2_000是2000的意思。
        Thread.sleep(2_000L);
        System.out.println("main finish");
    }
}

