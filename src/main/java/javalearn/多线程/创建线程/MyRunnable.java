package javalearn.多线程.创建线程;

/**
 * @author Ryan
 * @date 2020/11/23 16:18
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("执行");
    }

    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();
    }
}
