package javalearn.多线程.创建线程.ohter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ryan
 * @date 2020/11/23 16:33
 */
public class WrongThread {
    public static void main(String[] args) {
        ExecutorService tp = Executors.newCachedThreadPool();
        for(int i=0;i<1000;i++){
            tp.execute(new Task());
        }
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
