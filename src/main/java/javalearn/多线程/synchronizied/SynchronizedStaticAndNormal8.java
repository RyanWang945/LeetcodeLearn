package javalearn.多线程.synchronizied;

/**
 * @author Ryan
 * @date 2020/11/24 19:44
 * 同时访问一个类的不同的普通同步方法
 */
public class SynchronizedStaticAndNormal8 implements Runnable{
    static SynchronizedStaticAndNormal8 instance1=new SynchronizedStaticAndNormal8();
    //static SynchronizedDifferentMethod7 instance2=new SynchronizedDifferentMethod7();
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else{
            method2();
        }
    }
    private synchronized static void method1(){
        System.out.println("我是静态加锁方法1，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
    private synchronized void method2(){
        System.out.println("我是非静态普通加锁方法2，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1=new Thread(instance1);
        Thread t2=new Thread(instance1);
        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finish");
    }
}
