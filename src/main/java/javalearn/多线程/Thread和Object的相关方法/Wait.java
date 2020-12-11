package javalearn.多线程.Thread和Object的相关方法;

/**
 * @author Ryan
 * @date 2020/11/24 15:57
 */
public class Wait {
    public static Object object=new Object();
    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"开始执行了");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"获取到课锁");
            }

        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                object.notify();
                System.out.println(Thread.currentThread().getName()+"调用了notify");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(2000);
        thread2.start();
    }
}
