package javalearn.多线程.Thread和Object的相关方法;

/**
 * @author Ryan
 * @date 2020/11/26 12:16
 * 证明wait只释放当前的锁
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object A=new Object();
    private static volatile Object B=new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    System.out.println("ThreadA got A Lock");
                    synchronized (B) {
                        System.out.println("ThreadA got B lock");
                        try {
                            System.out.println("ThreadA releases A lock");
                            A.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("ThreadB got A lock");
                    System.out.println("ThreadB try to get B lock");
                    synchronized (B) {
                        System.out.println("ThreadB got B lock");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
