package javalearn.多线程.线程的六种状态;

/**
 * @author Ryan
 * @date 2020/11/24 15:01
 */
public class BlockedWaitingTimedWaiting implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread t1=new Thread(runnable);
        t1.start();

        Thread t2=new Thread(runnable);
        t2.start();
        Thread.sleep(2000);//如果不sleep，可能主线程执行太快了以至于还没sleep就打印了
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t1.getState());
    }
    @Override
    public void run() {
        syn();
    }
    private synchronized void syn(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
