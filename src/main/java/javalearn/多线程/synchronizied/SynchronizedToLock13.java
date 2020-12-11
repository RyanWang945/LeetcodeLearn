package javalearn.多线程.synchronizied;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ryan
 * @date 2020/11/25 14:43
 */
public class SynchronizedToLock13 {
    Lock lock=new ReentrantLock();
    public synchronized void method1(){
        System.out.println("我是synchronized形式的锁");
    }
    public void method2(){
        lock.lock();
        try{
            System.out.println("我是lock形式的锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock13 s=new SynchronizedToLock13();
        s.method1();
        s.method2();
    }
}
