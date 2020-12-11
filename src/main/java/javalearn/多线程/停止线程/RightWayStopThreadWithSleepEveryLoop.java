package javalearn.多线程.停止线程;

/**
 * @author Ryan
 * @date 2020/11/23 19:31
 * 如果在执行过程中每次循环都会sleep或者wait，那么
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            int num=0;

            try {
                while(num<=10000){
                    if((num%100)==0){
                        System.out.println(num+"是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
