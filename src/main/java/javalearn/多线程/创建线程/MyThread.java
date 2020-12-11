package javalearn.多线程.创建线程;

/**
 * @author Ryan
 * @date 2020/11/23 16:20
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("执行");
    }

    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();
    }
}
