package javalearn.多线程.停止线程;

/**
 * @author Ryan
 * @date 2020/11/23 19:47
 * catchInterruptedException后在方法签名中抛出异常
 * 那么在run方法中会强制try/catch
 */
public class RightWayStopInProd implements Runnable{
    @Override
    public void run() {
        while(true&&!Thread.currentThread().isInterrupted()){
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(1000);
    }
    //private void throw

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
