package javalearn.多线程.创建线程;

/**
 * @author Ryan
 * @date 2020/11/23 16:23
 */
public class BothRunnableThread{
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("thread");
            }
        }.start();
    }
}
