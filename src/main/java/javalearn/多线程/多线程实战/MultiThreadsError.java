package javalearn.多线程.多线程实战;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ryan
 * @date 2020/11/27 14:23
 */
public class MultiThreadsError implements Runnable{
    int index=0;
    static AtomicInteger readIndex=new AtomicInteger();
    static AtomicInteger wrongCount=new AtomicInteger();
    static volatile CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2=new CyclicBarrier(2);
    final static boolean[] marked=new boolean[100000000];

    static MultiThreadsError instance=new MultiThreadsError();
    public static void main(String[] args) throws InterruptedException {
        marked[0]=true;
        Thread thread1=new Thread(instance);
        Thread thread2=new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(instance.index);
        System.out.println("真正运行次数"+readIndex);
        System.out.println("错误次数"+wrongCount);
    }
    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            try {
                cyclicBarrier2.reset();
                cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            readIndex.incrementAndGet();
            synchronized (instance){
                if(marked[index]&&marked[index-1]){
                    System.out.println("发生了冲突："+index);
                    wrongCount.incrementAndGet();
                }
                marked[index]=true;
            }

        }
    }
}
