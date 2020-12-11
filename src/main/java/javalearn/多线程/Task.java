package javalearn.多线程;

import java.util.concurrent.TimeUnit;

/**
 * @author Ryan
 * @date 2020/10/1 21:28
 */
public class Task implements Runnable{
    private final Object MUTEX=new Object();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized (MUTEX){

            try {

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(Task::new).start();
        }
    }
}