package javalearn.多线程.Thread和Object的相关方法;

/**
 * @author Ryan
 * @date 2020/11/26 15:19
 * 交替打印奇偶数
 */
public class OddEvenTestSynchronized{
    private static int count=0;
    private static Object lock=new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count<100){
                    synchronized (lock){
                        if((count&1)==0){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }else{

                        }
                    }
                }
            }
        },"偶数").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count<100){
                    synchronized (lock){
                        if((count&1)==1){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"奇数").start();
    }
}
