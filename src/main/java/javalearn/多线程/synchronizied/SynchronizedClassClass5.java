package javalearn.多线程.synchronizied;

/**
 * @author Ryan
 * @date 2020/11/24 19:05
 * 类锁的第一种形式，static形式
 */
public class SynchronizedClassClass5 implements Runnable{
    static SynchronizedClassClass5 instance1=new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2=new SynchronizedClassClass5();

    @Override
    public void run() {
        method();
    }
    public  void method(){
        synchronized (SynchronizedClassClass5.class){
            System.out.println("类锁的第二种形式*.class。我叫："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(instance1);
        Thread t2=new Thread(instance2);
        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finish");
    }
}
