package javalearn.多线程.Thread和Object的相关方法;

/**
 * @author Ryan
 * @date 2020/11/26 15:37
 * 两个线程交替打印1到100
 */
public class WaitNotifyPrintOddEven {
    private static int count;
    private static Object object=new Object();
    //一旦拿到锁就打印
    //打印完后唤醒其他线程，自己进入休眠状态。
    static class TurningRunner implements Runnable{
        @Override
        public void run() {
            while(count<=100){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    object.notify();
                    if(count<=100){
                        try {
                            //如果任务还没结束，就让出锁，并且自己休眠
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }


    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(new TurningRunner(),"偶数").start();
        Thread.sleep(100);
        new Thread(new TurningRunner(),"奇数").start();
    }

}
