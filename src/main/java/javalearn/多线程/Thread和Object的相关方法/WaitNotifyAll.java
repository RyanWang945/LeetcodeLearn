package javalearn.多线程.Thread和Object的相关方法;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author Ryan
 * @date 2020/11/26 12:07
 * 三个线程，1和2首先被阻塞，线程3唤醒他们，notify，notifyAll
 * start先执行不代表线程先启动。
 */
public class WaitNotifyAll implements Runnable{
    private static final Object A=new Object();
    @Override
    public void run() {
        synchronized (A){
            System.out.println(Thread.currentThread().getName()+"got A lock.");
            try {
                System.out.println(Thread.currentThread().getName()+"waits to start.");
                A.wait();
                System.out.println(Thread.currentThread().getName()+"waiting end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable r=new WaitNotifyAll();
        Thread thread1=new Thread(r);
        Thread thread2=new Thread(r);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    A.notifyAll();
                    System.out.println("Thread3 notified.");
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
    }
}
