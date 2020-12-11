package javalearn.多线程.线程的六种状态;

/**
 * @author Ryan
 * @date 2020/11/24 14:43‘
 * 展示new，runnable，terminated，即使正在运行，也是runnable状态，而不是running
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印runnable
        System.out.println(thread.getState());
    }
}
