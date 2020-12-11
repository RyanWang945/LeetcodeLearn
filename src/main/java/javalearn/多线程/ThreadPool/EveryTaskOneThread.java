package javalearn.多线程.ThreadPool;

import java.util.concurrent.Executors;

/**
 * @author Ryan
 * @date 2020/11/21 15:29
 */
public class EveryTaskOneThread {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new Task());
            thread.start();
        }
        Executors.newFixedThreadPool(3);
    }
    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }
}
