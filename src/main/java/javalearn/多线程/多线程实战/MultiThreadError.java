package javalearn.多线程.多线程实战;

import com.google.common.collect.Multimap;

/**
 * @author Ryan
 * @date 2020/11/27 15:05
 * 演示死锁
 */
public class MultiThreadError implements Runnable{
    public static void main(String[] args) {
        MultiThreadError r1=new MultiThreadError();
        MultiThreadError r2=new MultiThreadError();
        r1.flag=1;
        r2.flag=0;
        Thread thread1=new Thread(r1);
        Thread thread2=new Thread(r2);
        thread1.start();
        thread2.start();
    }

    int flag=1;
    static Object o1=new Object();
    static Object o2=new Object();
    @Override
    public void run() {
        System.out.println("flag="+flag);
        if(flag==1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }else{
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }
}
