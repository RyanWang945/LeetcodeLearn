package javalearn.多线程.concurrency_tools_practice.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ryan
 * @date 2020/12/11 10:08
 * 用两个线程分别打印日期信息
 */
public class _1ThreadLocalUse {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new _1ThreadLocalUse().date(10);
                System.out.println(date);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new _1ThreadLocalUse().date(1007);
                System.out.println(date);
            }
        }).start();

    }
    public String date(int seconds){
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
