package javalearn.多线程.synchronizied;

/**
 * @author Ryan
 * @date 2020/11/24 16:44
 * 对象锁实例，代码块形式
 */

public class SynchronizedObjectBlock2 implements Runnable{
    public static void main(String[] args) {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finish");
    }

    static SynchronizedObjectBlock2 instance=new SynchronizedObjectBlock2();
    @Override
    public void run() {
        synchronized (this){
            System.out.println("我是对象锁的代码块形式，我叫："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }

    }
}
