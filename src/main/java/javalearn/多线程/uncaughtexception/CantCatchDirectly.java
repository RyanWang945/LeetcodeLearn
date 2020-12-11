package javalearn.多线程.uncaughtexception;

/**
 * @author Ryan
 * @date 2020/11/26 18:53
 * 不加try catch时
 * 加了try catch时，期望捕获到第一个线程的异常。
 * 234 不应该运行，希望打印出caughtexception
 * 执行时返现没有这个exception，线程234依然运行，还抛出异常。
 *
 * 说明线程的异常不能用传统的方法捕获。
 */
public class CantCatchDirectly implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        try{
            new Thread(new CantCatchDirectly(),"MyThread-1").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"MyThread-2").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"MyThread-3").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"MyThread-4").start();
            Thread.sleep(300);
        }catch (RuntimeException e){
            System.out.println("caught exception.");
        }

    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
