package javalearn.多线程.synchronizied;

/**
 * @author Ryan
 * @date 2020/11/24 16:30
 */
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance=new DisappearRequest1();
    static int i=0;
    @Override
    public void run() {
        method();
    }
    private static synchronized void method(){
        for(int j=0;j<100000;j++){
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
