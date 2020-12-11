package javalearn.多线程.concurrency_tools_practice.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ryan
 * @date 2020/12/11 10:08
 * 用30个线程分别打印日期信息
 * 显然30个线程我们可以用for循环新建30个线程，但是如果是1000个线程，我们其实没办法新建
 * 1000个线程，这时候需要线程池
 *
 * 1000个打印日期的任务，用线程池执行
 * 这里有个问题，一共新建了1000个SimpleDateFormat对象
 */
public class _3ThreadLocalUse {
    public static ExecutorService threadPool=Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            int finalI=i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new _3ThreadLocalUse().date(finalI);
                    System.out.println(date);
                }
            });
        }
        threadPool.shutdown();
    }
    public String date(int seconds){
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
