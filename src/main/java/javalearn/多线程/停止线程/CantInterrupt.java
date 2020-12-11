package javalearn.多线程.停止线程;

/**
 * @author Ryan
 * @date 2020/11/23 19:37
 * 如果while里面放try catch，中断会失效
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            int num=0;
            while(num<=10000&&!Thread.currentThread().isInterrupted()){
                if(num%100==0){
                    System.out.println(num+"是100倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t=new Thread(runnable);
        t.start();
        Thread.sleep(5000);
        t.interrupt();
    }
}
