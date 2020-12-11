package javalearn.多线程.uncaughtexception;

/**
 * @author Ryan
 * @date 2020/11/26 18:46
 */
public class ExceptionInChildThread implements Runnable {
    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for(int i=0;i<1000;i++){
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
