package javalearn.多线程.启动线程;

/**
 * @author Ryan
 * @date 2020/11/23 18:10
 */
public class StartAndRun {
    public static void main(String[] args) {
        Runnable runnable=()->{
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        new Thread(runnable).start();
    }
}
