package javalearn.多线程.concurrency_tools_practice.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ryan
 * @date 2020/12/11 10:08
 * 用30个线程分别打印日期信息
 * 显然30个线程我们可以用for循环新建30个线程，但是如果是1000个线程，我们其实没办法新建
 * 1000个线程，这时候需要线程池
 */
public class _2ThreadLocalUse {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<30;i++){
            int finalI=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String date = new _2ThreadLocalUse().date(finalI);
                    System.out.println(date);
                }
            }).start();
            Thread.sleep(100);
        }
    }
    public String date(int seconds){
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
